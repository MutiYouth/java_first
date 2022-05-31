package com.weng.service;

import com.weng.bean.request.UserLoginRequest;
import com.weng.bean.response.UserLoginResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by weng on 17-8-26.
 * E-mail: hisenyuan@gmail.com
 */
public interface UserInfoService {
  public UserLoginResponse login(UserLoginRequest request);
  public Boolean checkJWT(HttpServletRequest req);
}
