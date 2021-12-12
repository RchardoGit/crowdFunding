package com.atguigu.atcrowdfunding.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @auther konglingyang
 * @date 2021/12/12 11:51
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()  //对请求进行授权
                .antMatchers("/static/**")  // 对静态资源进行设置
                .permitAll()  // 无条件访问
                .antMatchers("/WEB-INF/templates/admin-login.jsp")  // 对登录页进行设置
                .permitAll()  // 无条件访问
                .anyRequest()
                .hasAuthority("ADMIN")
                .and()
                .formLogin()
                .loginPage("/WEB-INF/templates/admin-login.jsp")
                ;
    }
}
