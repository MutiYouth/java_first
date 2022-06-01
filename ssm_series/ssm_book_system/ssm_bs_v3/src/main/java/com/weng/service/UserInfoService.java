package com.weng.service;

import com.weng.bean.request.UserLoginRequest;
import com.weng.bean.response.UserLoginResponse;
import javax.servlet.http.HttpServletRequest;


public interface UserInfoService {
  public UserLoginResponse login(UserLoginRequest request);
  public Boolean checkJWT(HttpServletRequest req);
}
