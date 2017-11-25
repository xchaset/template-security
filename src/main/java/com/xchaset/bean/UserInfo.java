package com.xchaset.bean;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public final class UserInfo  implements UserDetails {

	private static final long serialVersionUID = 1L;

	private int userId;
	
	private String username;
	
	private String password;
	
	private boolean enabled ;
	/**
	 * 是否过期
	 */
	private boolean accountNonExpired;
	
	/**
	 * 是否加锁
	 */
	private boolean  accountNonLocked;
	
	/**
	 * 是否禁用
	 */
	private boolean credentialsNonExpired;
	
	/**
	 * 权限列表
	 */
	private Collection<? extends GrantedAuthority> authorities; 

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	 @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
         return authorities;
     }

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities2) {
		this.authorities = authorities2;
		
	}
	
	
}
