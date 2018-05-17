package com.demo.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.pojo.User;
import com.demo.service.UserService;
import com.demo.util.ResultUtil;

@Controller
@RequestMapping(value="/user")
public class RegisterController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/register.do")
	@ResponseBody
	public ResultUtil register(User user){
		return userService.addUser(user);
	}
	
}
