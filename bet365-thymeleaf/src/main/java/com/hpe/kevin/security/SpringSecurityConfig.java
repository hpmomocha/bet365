package com.hpe.kevin.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	public SpringSecurityConfig() {
		super();
	}
	
	/**
	 * 默认实现
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin().and()
        .httpBasic();
    }
	 * */
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	CharacterEncodingFilter filter = new CharacterEncodingFilter();
    	filter.setEncoding("UTF-8");
    	filter.setForceEncoding(true);
    	http.addFilterBefore(filter,CsrfFilter.class);
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/webjars/**", "/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//基于内存的用户存储
//		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("hpmomocha").password("hpmomocha").roles("USER").and()
//		.withUser("admin").password("admin").roles("USER", "ADMIN");
		
//		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("hpmomocha").password("hpmomocha").authorities("ROLE_USER").and()
//		.withUser("admin").password("admin").authorities("ROLE_USER", "ROLE_ADMIN");
		
		// 基于数据库查询
		auth.jdbcAuthentication().passwordEncoder(new MyPasswordEncoder()).dataSource(dataSource).
		usersByUsernameQuery("select user_name, password,enabled from t_user where user_name=?").
		authoritiesByUsernameQuery("select t1.user_name, t2.user_role from t_user t1, t_user_role t2 where t1.user_id = t2.user_id and t1.user_name=?");
	}
    
    
}
