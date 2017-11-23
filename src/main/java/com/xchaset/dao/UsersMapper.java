package com.xchaset.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xchaset.bean.Users;
@Repository
public interface UsersMapper {

	
	Users getByName(@Param("user_name")String username);
}
