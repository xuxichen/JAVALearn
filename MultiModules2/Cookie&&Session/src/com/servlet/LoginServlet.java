package com.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、设置编码
        req.setCharacterEncoding("utf-8");
        // 2、获取参数map
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkcode = req.getParameter("checkcode");

        HttpSession session = req.getSession();
        Object checkcode1 = session.getAttribute("checkcode");
        session.removeAttribute("checkcode");
        if (checkcode != null && checkcode.equals(checkcode1)) {
            // 登陆成功
            System.out.println("登陆成功");
        } else {
            //验证码错误
            req.setAttribute("cc_error", "验证码错误");
            req.getRequestDispatcher("/login.html").forward(req, resp);
        }
    }
}
