package com.sunlab.helloworld.controller;

import com.sunlab.helloworld.model.HelloUser;
import com.sunlab.helloworld.service.IHelloUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloUserController {

    // @Autowired
    private IHelloUserService userService;

    // set方法注入
    @Autowired
    public void SetIHelloUserService(IHelloUserService iUserService) {
        this.userService = iUserService;
    }

    @RequestMapping("/get_all")
    public String getAllUser(Model model) throws Exception {

        List<HelloUser> userList = userService.getAll();
        model.addAttribute("userList", userList);

        return "user_list";  // 返回一个use_list.jsp网页

    }


}