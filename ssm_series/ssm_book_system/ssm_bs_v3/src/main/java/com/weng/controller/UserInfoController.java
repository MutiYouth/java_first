package com.weng.controller;

import static com.weng.common.MD5Util.toMd5;

import com.alibaba.fastjson.JSON;
import com.weng.bean.request.UserLoginRequest;
import com.weng.bean.request.UserRegisterRequest;
import com.weng.bean.response.UserLoginResponse;
import com.weng.common.CookieUtil;
import com.weng.service.UserInfoService;


import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserInfoController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    //  post changed to get
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String login(HttpServletResponse res, HttpServletRequest req, UserLoginRequest request) {
        request.setPwd(toMd5(request.getPwd()));
        log.info("[UserInfoController] - [login] 入参-> " + request.toString());
        UserLoginResponse login = userInfoService.login(request);
        log.info("[UserInfoController] - [login] 出参-> " + login.toString());


        // 放置cookies
        Map<String, String> map = new HashMap<String, String>();
        map.put("jwt", login.getJwt());
        map.put("name", login.getName());
        CookieUtil.addCookieMap(res, map);


        return JSON.toJSONString(login);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String test(HttpServletResponse response) {
        // 放置cookies
        Map<String, String> map = new HashMap<String, String>();
        map.put("md5", "test");
        map.put("pwd", "weng");
        CookieUtil.addCookieMap(response, map);

        return "hello";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String testJWT(HttpServletResponse res, HttpServletRequest req) {
        Boolean checkJWT = userInfoService.checkJWT(req);
        if (checkJWT) {
            return "成功";
        }
        return "失败";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    // public String register(HttpServletRequest req, HttpServletResponse res, String req_data_str) {
    public String register(HttpServletRequest req, HttpServletResponse res, UserRegisterRequest req_data) {


        // 打印请求头
        Enumeration<?> enum1 = req.getHeaderNames();
        while (enum1.hasMoreElements()) {
            String key = (String) enum1.nextElement();
            String value = req.getHeader(key);
            System.out.println(key + "\t" + value);
        }

        // 取出jwt中的加密信息,与数据库比对,看是否正确
        Boolean aBoolean = userInfoService.checkJWT(req);

        return aBoolean ? "成功" : "失败";
    }
}
