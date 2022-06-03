package com.weng.bean.request;

import lombok.Data;

@Data
public class UserRegisterRequest {
	private String name;
	private String gender;
	private String age;
	private String pwd;
	private String pwd_again;
}
