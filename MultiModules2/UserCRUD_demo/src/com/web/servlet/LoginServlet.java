package com.web.servlet;

import com.domain.User;
import com.service.Impl.UserServiceImpl;
import com.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

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
        String checkcode = req.getParameter("checkcode");

        // 3、 验证码校验
        HttpSession session = req.getSession();
        String checkcode1 = (String) session.getAttribute("checkcode");
        session.removeAttribute("checkcode");
        if (checkcode != null && checkcode.equalsIgnoreCase(checkcode1)) {
            Map<String, String[]> parameterMap = req.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user, parameterMap);
                UserService userService = new UserServiceImpl();
                User loginuser = userService.login(user);
                if (loginuser != null) {
                    session.setAttribute("user", loginuser);
                    resp.sendRedirect(req.getContextPath() + "/index.jsp");
                } else {
                    //验证码错误
                    req.setAttribute("login_msg", "用户名或者密码错误");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }

            }catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            //验证码错误
            req.setAttribute("cc_error", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
