package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1、强制转换
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        // 2、获取资源请求路径
        String uri = request.getRequestURI();

        // 3、判断是否包含登陆相关的资源路径
        if (uri.contains("/login.jsp") ||
                uri.contains("/loginServlet") ||
                uri.contains("/css/") ||
                uri.contains("/js/") ||
                uri.contains("/fonts/") ||
                uri.contains("/CheckCodeServlet")
        ) {
            filterChain.doFilter(request, servletResponse);
        } else {
            Object user = request.getSession().getAttribute("user");
            if (user!=null) {
                filterChain.doFilter(request, servletResponse);
            } else {
                request.setAttribute("login_msg", " 您尚未登陆，请登陆");
                request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
