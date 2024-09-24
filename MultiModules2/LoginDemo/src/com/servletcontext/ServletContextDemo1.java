package com.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context1")
public class ServletContextDemo1 extends HttpServlet {
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
        ServletContext servletContext = req.getServletContext();
        ServletContext servletContext1 = this.getServletContext();

        if(servletContext == servletContext1) {
            System.out.println("true");
        }
        String filename = "a.jpg";

        String mimeType = servletContext.getMimeType(filename);
        System.out.println(mimeType);
    }
}
