package com.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@WebServlet("/context4")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取ServletContext的两种方式
         * req.getServletContext()
         * this.getServletContext
         */
        ServletContext servletContext = this.getServletContext();

        // 获取文件真实路径
        String realPath = servletContext.getRealPath("/b.txt");
        String realPath1 = servletContext.getRealPath("/WEB_INF/c.txt");
        String realPath2 = servletContext.getRealPath("/WEB_INF/classes/a.txt");
        System.out.println(realPath);
        System.out.println(realPath1);
        System.out.println(realPath2);
//        File file = new File(realPath);
//        System.out.println(file);

    }
}
