package com.atguigu.atcrowdfunding.interceptor;

import com.atguigu.atCrowdFunding.exception.AccessForbiddenException;
import com.atguigu.atCrowdFunding.stant.CrowdConstant;
import com.atguigu.atcrowdfunding.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @auther konglingyang
 * @date 2021/12/6 15:47
 * 拦截未登录用户访问受限资源
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);

        if(admin == null) {
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_USER_NOT_LOGIN);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
