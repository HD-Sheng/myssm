package com.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.pojo.User;
import com.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-config.xml")
public class TestDemo {
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		User user = new User("123123123", "aopTest", "mima");
		userService.addUser(user);
		
	}
}
