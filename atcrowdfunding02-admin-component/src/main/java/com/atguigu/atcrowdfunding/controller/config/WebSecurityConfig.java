package com.atguigu.atcrowdfunding.controller.config;

import com.atguigu.atCrowdFunding.stant.CrowdConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther konglingyang
 * @date 2021/12/12 11:51
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private SecurityUserDetailsService userDetailsService;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth/*.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("tom")
                .password(new BCryptPasswordEncoder().encode("456789"))
                .authorities("ADMIN")
                */
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder)
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()  //?????????????????????
                .antMatchers("/static/**")  // ???????????????????????????
                .permitAll()  // ???????????????
                .antMatchers("/admin/do/login/page.html")  // ????????????????????????
                .permitAll()  // ???????????????
//                .antMatchers("/index.jsp")
//                .permitAll()
                .antMatchers("/admin/list/page.html")
                .hasRole("??????")
                .anyRequest()
                .permitAll()
                .and()
                .csrf()  // ??????csrf
                .disable()
                .formLogin()
                .loginPage("/admin/do/login/page.html")  // ??????????????????
                .loginProcessingUrl("/security/do/login.html")  // ??????????????????
                .usernameParameter("loginAcct")
                .passwordParameter("userPswd")
                .defaultSuccessUrl("/admin/do/main/page.html")  // ??????????????????
                .and()
                .logout()
                .logoutUrl("/security/main/logout.html")  // ??????????????????
                .logoutSuccessUrl("/admin/do/login/page.html")  // ??????????????????
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                        httpServletRequest.setAttribute("exception",new Exception(CrowdConstant.MESSAGE_ACCESS_DENIED));
                        httpServletRequest.getRequestDispatcher("/WEB-INF/templates/system-error.jsp")
                                .forward(httpServletRequest,httpServletResponse);
                    }
                })
                ;
    }
}
