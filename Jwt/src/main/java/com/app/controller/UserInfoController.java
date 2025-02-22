package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.UserInfo;
import com.app.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController
{

	@Autowired
	private UserInfoService userInfoService;
	
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserInfo userInfo)
	{
		userInfoService.saveUser(userInfo);
		return "User Created Successfully saved in db";
	}
	
}
