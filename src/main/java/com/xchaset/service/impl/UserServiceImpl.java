package com.xchaset.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xchaset.bean.UserInfo;
import com.xchaset.dao.AuthoritiesMapper;
import com.xchaset.dao.UserInfoMapper;
import com.xchaset.service.UserService;
@Service
public class UserServiceImpl implements UserService,UserDetailsService {

	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private AuthoritiesMapper authoritiesMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoMapper.getByName(username);
		if (null == userInfo){
			throw new UsernameNotFoundException("user:"+username+" not found");
		}
		 List<GrantedAuthority> authorities = authoritiesMapper.getByUsername(username);
		 log.info(authorities.toString());
		 userInfo.setAuthorities(authorities);
	     return userInfo;
		
	}

}
