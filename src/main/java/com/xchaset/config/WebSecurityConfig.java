package com.xchaset.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.xchaset.service.impl.UserServiceImpl;
/**
 * springsecurity配置
 * @author xiaozhaoming
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userServiceImpl);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring().antMatchers("/js/**","/css/**","/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();//测试时可通过此进行关闭
		http
			.authorizeRequests()
			.antMatchers("/")
			.permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
			.anyRequest()
			.authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
		.rememberMe()
			.tokenValiditySeconds(60*60*24*15)
			.key("xchaset")
			.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//logout建议使用post方法，如果一定要使用get，需要这样处理
			.logoutSuccessUrl("/");  //退出时跳转到首页
	}

	
	
}
