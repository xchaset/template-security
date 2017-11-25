package com.xchaset.bean;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority {

	
	private static final long serialVersionUID = 1L;

	private int authId;
	
	private String username;
	
	private String authority;

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
