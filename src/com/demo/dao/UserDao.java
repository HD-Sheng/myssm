package com.demo.dao;

import com.demo.pojo.User;

/**
 * DataBase crud操作
 * @author sheng
 *
 */
public interface UserDao {
	public void addUser(User user);
	public User querybyName(String username);
	public User querybyUser(User user);
	public User querybyId(String userId);
}
