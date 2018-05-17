package com.demo.service;

import com.demo.pojo.User;
import com.demo.util.ResultUtil;

/**
 * service接口
 * @author sheng
 *
 */
public interface UserService {
	public ResultUtil addUser(User user);
	public ResultUtil querybyUser(User user);
	public ResultUtil querybyUserId(String userId);
}
