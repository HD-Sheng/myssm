package com.demo.service.impl;


import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.pojo.User;
import com.demo.service.UserService;
import com.demo.util.ConstantUtil;
import com.demo.util.ResultUtil;
import com.demo.util.UNIDUtil;

@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	@Resource
	private UserDao userDao;
	
	@Override
	public ResultUtil addUser(User user) {
		ResultUtil result = null;
		try {
			String username = user.getUserName();
			User isHasUser = userDao.querybyName(username);
			if(isHasUser != null){
				result = new ResultUtil(ConstantUtil.RET_STATUS_F, "用户名已存在", null);
				return result;
			}
			UNIDUtil unid = new UNIDUtil();
			user.setUserId(unid.getUNID());
			userDao.addUser(user);
			result = new ResultUtil(ConstantUtil.RET_STATUS_S, "注册成功", null);
			logger.info("logger======================注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResultUtil(ConstantUtil.RET_STATUS_F, "系统异常", null);
		}
		return result;
	}

	@Override
	public ResultUtil querybyUser(User user) {
		ResultUtil result = null;
		try {
			User temp = userDao.querybyUser(user);
			if(temp == null){
				result = new ResultUtil(ConstantUtil.RET_STATUS_F, "用户名或密码错误", null);
			} else {
				result = new ResultUtil(ConstantUtil.RET_STATUS_S, "登陆成功", temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResultUtil(ConstantUtil.RET_STATUS_F, "系统异常", null);
		}
		
		return result;
	}

	@Override
	public ResultUtil querybyUserId(String userId) {
		ResultUtil result = null;
		try {
			User user = userDao.querybyId(userId);
			if(user != null){
				result = new ResultUtil(ConstantUtil.RET_STATUS_S, null, user);
			} else {
				result = new ResultUtil(ConstantUtil.RET_STATUS_F, "用户不存在", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResultUtil(ConstantUtil.RET_STATUS_F, "系统异常", null);
		}
		return result;
	}


}
