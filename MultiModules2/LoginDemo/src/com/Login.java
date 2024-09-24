package com;

import com.dao.UserDao;
import com.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        User loginuser = new User();
//        loginuser.setUsername(username);
//        loginuser.setPassword(password);
        Map<String, String[]> parameterMap = req.getParameterMap();
        User loginuser = new User();

        try {
            BeanUtils.populate(loginuser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        User user = new UserDao().login(loginuser);
        if (user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/SuccessServlet").forward(req, resp);
        } else {
            req.getRequestDispatcher("/FailServelet").forward(req, resp);
        }
    }
}
