package com.xchaset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xchaset.bean.Users;
import com.xchaset.dao.UsersMapper;

@RestController
public class Controller {
	@Autowired
	private UsersMapper usersMapper;

	@RequestMapping("/user/{username}")
	public Users getUser(@PathVariable String username){
		Users users = usersMapper.getByName(username);
		System.out.println(users.getUsername());
		return users;
	}
}
