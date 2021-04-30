package com.servlet;

import com.entity.User;
import com.servier.IUserService;
import com.servier.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * Created by syx on 2021/04/29 16:33
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        user.setPhone(phone);
        user.setBirthday(Date.valueOf(birthday));
        user.setAddress(address);
        IUserService userService = new UserServiceImpl();
        int updateRow = userService.addUser(user);
        if (updateRow <= 0) {
            req.setAttribute("msg", "添加失败");
            req.getRequestDispatcher("/JSP/error.jsp").forward(req, resp);
        } else {
            List<User> users = userService.userList();
            req.getSession().setAttribute("list", users);
            req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
