package com.weng.service.impl;

import com.alibaba.fastjson.JSON;
import com.weng.bean.contains.CommonEnum;
import com.weng.bean.entity.JWTInfo;
import com.weng.bean.entity.UserInfo;
import com.weng.bean.entity.UserInfoExample;
import com.weng.bean.request.UserLoginRequest;
import com.weng.bean.response.UserLoginResponse;
import com.weng.common.CookieUtil;
import com.weng.common.JWTUtil;
import com.weng.dao.UserInfoMapper;
import com.weng.service.UserInfoService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	UserInfoMapper mapper;

	public UserLoginResponse login(UserLoginRequest request) {
		log.info("[UserInfoServiceImpl]-[login]-入参:{}", JSON.toJSONString(request));
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andNameEqualTo(request.getName()).andPwdEqualTo(request.getPwd());
		List<UserInfo> userInfos = mapper.selectByExample(example);

		// check if empty
		UserLoginResponse login = new UserLoginResponse();
		if (userInfos == null || userInfos.size() == 0 || !request.getPwd().equals(userInfos.get(0).getPwd())) {
			login.setResCode(CommonEnum.LOGIN_FAILED.getCode());
			login.setResMsg(CommonEnum.LOGIN_FAILED.getMsg());
			return login;
		}
		log.info("[UserLoginResponse]-[login]-[selectByExample]-出参:{}", JSON.toJSONString(userInfos));

		// 判断账户的当前状态
		UserInfo userInfo = userInfos.get(0);
		if (1 == userInfo.getUserState()) {
			login.setResCode(CommonEnum.LOGIN_LOCKED.getCode());
			login.setResMsg(CommonEnum.LOGIN_LOCKED.getMsg());
			return login;
		}

		// 未登录过
		// 生成token
		JWTInfo jwtInfo = new JWTInfo();
		jwtInfo.setPassword(userInfo.getPwd());
		jwtInfo.setUsername(userInfo.getName());
		String jwt = JWTUtil.sign(jwtInfo, Long.parseLong(CommonEnum.JWT_MAXAGE.getMsg()));

		// 放入返回
		login.setJwt(jwt);
		login.setName(userInfo.getName());
		login.setUserType(userInfo.getUserType());
		login.setResCode(CommonEnum.LOGIN_SUCCESS.getCode());
		login.setResMsg(CommonEnum.LOGIN_SUCCESS.getMsg());
		log.info("[UserLoginResponse]-[login]-出参:{}", JSON.toJSONString(login));

		return login;
	}

	public Boolean checkJWT(HttpServletRequest req) {
		String jwt = null;
		String name = null;
		Map<String, Cookie> stringCookieMap = CookieUtil.ReadCookieMap(req);
		log.info("[UserLoginResponse]-[checkJWT]-入参:{}", JSON.toJSONString(stringCookieMap));

		// 从cookies中取数据
		if (!stringCookieMap.isEmpty()) {
			jwt = stringCookieMap.get("jwt").getValue();
			name = stringCookieMap.get("name").getValue();
			System.out.println("checkJWT 1:" + jwt + "\t" + name);
		}
		else {
			// 从Header中取数据
			jwt = req.getHeader("Authorization");
			name = req.getHeader("name");
			System.out.println("checkJWT 2:" + jwt + "\t" + name);
		}
		// 获得加密之前的数据
		JWTInfo jwtInfo = JWTUtil.unsign(jwt, JWTInfo.class);
		// 利用name去查询密码
		String checkJWT = mapper.checkJWT(jwtInfo.getUsername());

		return Objects.equals(jwtInfo.getPassword(), checkJWT);
	}
}
