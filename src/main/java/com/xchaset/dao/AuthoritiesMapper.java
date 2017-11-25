package com.xchaset.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;
@Repository
public interface AuthoritiesMapper {

	List<GrantedAuthority> getByUsername(@Param("user_name")String username);
}
