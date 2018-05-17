package com.demo.pojo;

/**
 * 用户实体类
 * @author sheng
 *
 */
public class User {
	String userId;
	String userName;
	String passWord;

	public User() {
		super();
	}

	public User(String userId, String userName, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + "]";
	}

}
