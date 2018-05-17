package com.demo.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转公用.do
 * @author sheng
 *
 */
@Controller
public class JumpPage {
	@RequestMapping("/jumppage.do")
	public String jumpPage(String destPageName){
		return destPageName;
	}
}
