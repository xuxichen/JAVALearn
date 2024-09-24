package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "你好啊");
        // 设置持久化
        cookie.setMaxAge(3000);

        // 设置cookie的获取范围，默认情况设置当前的虚拟目录
        // 如果需要同一个tomcat下的多个项目共享，则设置为"/"
        cookie.setPath("/");

        // 不同的tomcat服务器之间的cookie共享问题
        //cookie.setDomain("");
        // 如果设置一句域名相同，那么多个服务器之间的cookie可以共享

        resp.addCookie(cookie);
    }
}
