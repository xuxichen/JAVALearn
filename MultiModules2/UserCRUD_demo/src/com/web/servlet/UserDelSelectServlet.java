package com.web.servlet;

import com.service.Impl.UserServiceImpl;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userdelselect")
public class UserDelSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String[] uids = req.getParameterValues("uid");
        UserService userService = new UserServiceImpl();

        String deletefailId = userService.delSelectUser(uids);

        if (deletefailId.length()<=0) {
            resp.sendRedirect(req.getContextPath() + "/userList?page=1&pageSize=6");
        } else {
            req.setAttribute("deletefailId", deletefailId);
            req.getRequestDispatcher("/userList?page=1&pageSize=6").forward(req, resp);
        }
    }
}
