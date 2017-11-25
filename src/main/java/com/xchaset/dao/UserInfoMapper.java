package com.xchaset.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xchaset.bean.UserInfo;
@Repository
public interface UserInfoMapper {

	
	UserInfo getByName(@Param("user_name")String username);
}
