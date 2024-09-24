package com.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo2 implements Servlet {

    /**
     * 初始化方法
     * 在servlet被创建的时候调用，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet init 方法调用了");
    }

    /**
     * 获取servletConfig对象
     * ServletConfig：servlet配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每一次servlet被访问都会被执行，会执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HELLO Servlet");
    }

    /**
     * 获取servlet信息版本，作者信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务区关闭的时候执行，执行一次
     */
    @Override
    public void destroy() {
        System.out.println("servlet destroy 方法调用了");
    }
}
