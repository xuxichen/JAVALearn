package com.web.servlet;

import com.dao.Impl.UserDaoImpl;
import com.domain.User;
import com.service.Impl.UserServiceImpl;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserService userService = new UserServiceImpl();
        Integer page = Integer.parseInt(req.getParameter("page"));
        Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");

        List<User> users = userService.getUers(page-1, pageSize,name, address, email);
        Integer userNumber = userService.getAllUerNumber(name, address, email);
        Integer totalPage = (userNumber % pageSize == 0) ? userNumber/pageSize : ((userNumber/pageSize)+1);
        req.setAttribute("users", users);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("userNumber", userNumber);
        req.setAttribute("name", name);
        req.setAttribute("address", address);
        req.setAttribute("currentPage", page);
        req.setAttribute("email", email);
        String path = req.getContextPath() + "/user.jsp";
        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }

    public int stringToInt(String string){
        String str = string.substring(0, string.indexOf(".")) + string.substring(string.indexOf(".") + 1);

        int intgeo = Integer.parseInt(str);

        return intgeo; }


}
