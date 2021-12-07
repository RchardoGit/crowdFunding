package com.atguigu.atcrowdfunding.mvcResolver;

import com.atguigu.atCrowdFunding.exception.LoginFailedException;
import com.atguigu.atCrowdFunding.exception.UpdateAdminAlreadyException;
import com.atguigu.atCrowdFunding.stant.CrowdConstant;
import com.atguigu.atCrowdFunding.util.CrowdUtil;
import com.atguigu.atcrowdfunding.commResult.CommonResult;
import com.atguigu.atCrowdFunding.exception.LoginAdminAlreadyException;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @auther konglingyang
 * @date 2021/12/5 20:42
 * 异常处理类
 */
@ControllerAdvice
public class CrowdExceptionResolver {

    /**
     * 登陆异常
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = LoginFailedException.class)
    public ModelAndView resolverLoginFailedException(LoginFailedException exception,
                                                   HttpServletRequest request,
                                                   HttpServletResponse response) throws IOException {
        // 判断当前请求类型
        boolean isAjax = CrowdUtil.judgeRequstType(request);

        if(isAjax) {
            // 创建返回对象是否为ajax请求
            CommonResult<Object> failed = CommonResult.failed(exception.getMessage());
            // 创建Gson
            Gson gson = new Gson();
            // 转换为json字符串
            String json = gson.toJson(failed);
            // 将json字符串作为响应体返回浏览器
            response.getWriter().write(json);
            return null;
        }

        // 不是ajax请求
        ModelAndView modelAndView = new ModelAndView();
        // 将异常类型存入模型
        modelAndView.addObject(CrowdConstant.LOGIN_EXCEPTION,exception);
        // 设置对应视图名称
        modelAndView.setViewName("admin-login");
        return modelAndView;
    }

    /**
     * 空指针异常
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolverNullPointException(NullPointerException exception,
                                                   HttpServletRequest request,
                                                   HttpServletResponse response) throws IOException {
        // 判断当前请求类型
        boolean isAjax = CrowdUtil.judgeRequstType(request);

        if(isAjax) {
            // 创建返回对象是否为ajax请求
            CommonResult<Object> failed = CommonResult.failed(exception.getMessage());
            // 创建Gson
            Gson gson = new Gson();
            // 转换为json字符串
            String json = gson.toJson(failed);
            // 将json字符串作为响应体返回浏览器
            response.getWriter().write(json);
            return null;
        }

        // 不是ajax请求
        ModelAndView modelAndView = new ModelAndView();
        // 将异常类型存入模型
        modelAndView.addObject(CrowdConstant.LOGIN_EXCEPTION,exception);
        // 设置对应视图名称
        modelAndView.setViewName("system-error");
        return modelAndView;
    }

    @ExceptionHandler(value = LoginAdminAlreadyException.class)
    public ModelAndView resolverLoginAdminAlreadyException(LoginFailedException exception,
                                                     HttpServletRequest request,
                                                     HttpServletResponse response) throws IOException {
        // 判断当前请求类型
        boolean isAjax = CrowdUtil.judgeRequstType(request);

        if(isAjax) {
            // 创建返回对象是否为ajax请求
            CommonResult<Object> failed = CommonResult.failed(exception.getMessage());
            // 创建Gson
            Gson gson = new Gson();
            // 转换为json字符串
            String json = gson.toJson(failed);
            // 将json字符串作为响应体返回浏览器
            response.getWriter().write(json);
            return null;
        }

        // 不是ajax请求
        ModelAndView modelAndView = new ModelAndView();
        // 将异常类型存入模型
        modelAndView.addObject(CrowdConstant.USER_ALIVED_EXCEPTION,exception);
        // 设置对应视图名称
        modelAndView.setViewName("admin-add");
        return modelAndView;
    }

    @ExceptionHandler(value = UpdateAdminAlreadyException.class)
    public ModelAndView resolverUpdateAdminAlreadyException(LoginFailedException exception,
                                                           HttpServletRequest request,
                                                           HttpServletResponse response) throws IOException {
        // 判断当前请求类型
        boolean isAjax = CrowdUtil.judgeRequstType(request);

        if(isAjax) {
            // 创建返回对象是否为ajax请求
            CommonResult<Object> failed = CommonResult.failed(exception.getMessage());
            // 创建Gson
            Gson gson = new Gson();
            // 转换为json字符串
            String json = gson.toJson(failed);
            // 将json字符串作为响应体返回浏览器
            response.getWriter().write(json);
            return null;
        }

        // 不是ajax请求
        ModelAndView modelAndView = new ModelAndView();
        // 将异常类型存入模型
        modelAndView.addObject(CrowdConstant.USER_ALIVED_EXCEPTION,exception);
        // 设置对应视图名称
        modelAndView.setViewName("system-error");
        return modelAndView;
    }

}
