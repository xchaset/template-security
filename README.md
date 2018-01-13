工程描述：该工程主要描述springboot项目的主要文档结构和配置文件的格式

使用到的安全框架为springsecurity:
  spring security主要需要实现三个接口
  		1.配置文件WebSecurityConfigurerAdapter超类，主要配置spring的安全规则，需要重写三个方法
  		configureGlobal(AuthenticationManagerBuilder auth)
  		configure(WebSecurity web)
  		configure(HttpSecurity http)
  		
  		2.pojo  user类实现UserDetails接口
  		3.实现UserDetailService接口，重写loadUserByUsername，返回一个UserDetails类型的对象（User）