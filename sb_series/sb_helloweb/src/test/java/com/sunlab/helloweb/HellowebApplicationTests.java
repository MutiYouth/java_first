package com.sunlab.helloweb;

import com.sunlab.helloweb.bean.UserBean;
import com.sunlab.helloweb.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HellowebApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        UserBean userBean = userService.login("weng", "2019");
        System.out.println("该用户的ID为: ");
        System.out.println(userBean.getId());
    }

}
