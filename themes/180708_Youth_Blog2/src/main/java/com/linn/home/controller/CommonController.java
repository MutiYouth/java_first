package com.linn.home.controller;

import com.linn.frame.shiro.realm.ShiroUser;
import com.linn.home.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

	/**
	 * 跳转到用户资料修改页面
	 *
	 * @param model
	 * @return 500 page
	 */
	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String toPage500(Model model) {
		return "common/500";
	}

	/**
	 * 系统错误页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String toError(Model model)
	{
		return "common/error";
	}

}
