package com.xchaset.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring工具类，可以运行时获取bean
 * @author xiaozhaoming
 *
 */
public class SpringUtil implements ApplicationContextAware {

	
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringUtil.applicationContext == null){
			SpringUtil.applicationContext = applicationContext;
		}
	}
	
	/**
	 * 获取ApplicationContext
	 * @return
	 */
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	/**
	 * 通过
	 * @param name
	 * @return
	 */
	public static Object getBean(String name){
		return getApplicationContext().getBean(name);
	}
	
	
	/**
	 * 根据Class获取Bean
	 * @param clazz
	 * @return
	 */
	public static<T> T getBean(Class<T> clazz){
		return getApplicationContext().getBean(clazz);
	}
	
	/**
	 * 根据name和class获取bean
	 * @param name
	 * @param clazz
	 * @return
	 */
	public static<T> T getBean(String name,Class<T> clazz){
		return getApplicationContext().getBean(name,clazz);
	}
}
