package com.demo.controller.user;

import com.demo.pojo.User;
import com.demo.service.UserService;
import com.demo.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public ResultUtil login(User user) {
        return userService.querybyUser(user);
    }

}
