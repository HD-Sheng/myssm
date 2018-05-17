package com.demo.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.service.UserService;
import com.demo.util.ResultUtil;

/**
 * 查询用户
 * @author sheng
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/queryUserbyuserId.do")
	@ResponseBody
	public ResultUtil queryUserbyuserId(String userId){
		return userService.querybyUserId(userId);
	}
	
}
