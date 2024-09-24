package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet({"/demo3", "/de3"}) // 两个url都可以访问到这个servlet
public class ServletDeme3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        System.out.println("--------------");
        // 2、获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        System.out.println("--------------");
        // 3、获取Servlet路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        System.out.println("--------------");
        // 4、获取get方式的请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
        System.out.println("--------------");
        // 5、获取请求URI
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        System.out.println("--------------");
        // 6、获取协议及版本
        String protocol = req.getProtocol();
        System.out.println(protocol);
        System.out.println("--------------");
        // 7、获取客户机的IP地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
        System.out.println("doGet .....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求方式
        // 2、获取虚拟目录
        // 3、获取Servlet路径
        // 4、获取get方式的请求参数
        // 5、获取请求URI
        // 6、获取协议及版本
        // 7、获取客户机的IP地址
        Enumeration enumeration = req.getParameterNames();
        while (enumeration.hasMoreElements()) {
            System.out.println(req.getParameter((String)enumeration.nextElement()));
        }
    }
}
