package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 拦截器路径配置：
 * 1、 具体资源路径： /index.jsp
 * 2、拦截目录： /user/
 * 3、拦截后缀名 *.jsp
 * 4、拦截所有资源 /*
 *
 * 拦截方式：DispatcherType
 *     FORWARD, 转发
 *     INCLUDE, 包含访问资源
 *     REQUEST, 浏览器直接请求
 *     ASYNC, 异步访问
 *     ERROR; 错误跳转资源
 *
 */

@WebFilter(value = "/*", dispatcherTypes = DispatcherType.ASYNC)
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo 1 doFilter。。。");

        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }
}
