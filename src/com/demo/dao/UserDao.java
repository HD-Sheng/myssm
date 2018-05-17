package com.demo.dao;

import com.demo.pojo.User;

public interface UserDao {
	public void addUser(User user);
	public User querybyName(String username);
	public User querybyUser(User user);
	public User querybyId(String userId);
}
