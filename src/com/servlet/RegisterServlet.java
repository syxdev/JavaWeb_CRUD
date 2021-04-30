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
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Created by syx on 2021/04/28 14:12
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        PrintWriter writer = resp.getWriter();
        if (username == null || username.equals("")) {
            writer.println(username + "不能为空");
        } else if (password == null || password.equals("")) {
            writer.println(password + "不能为空");
        } else if (gender == null && gender.equals("")) {
            writer.println(gender + "不能为空");
        } else if (birthday == null && birthday.equals("")) {
            writer.println(birthday + "不能为空");
        } else if (phone == null && phone.equals("")) {
            writer.println(phone + "不能为空");
        } else if (address == null && address.equals("")) {
            writer.println(address + "不能为空");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        user.setPhone(phone);
        user.setBirthday(Date.valueOf(birthday));
        user.setAddress(address);

        IUserService userService = new UserServiceImpl();
        int register = userService.register(user);
        if (register <= 0) {
            req.getRequestDispatcher("JSP/error");
        } else {
            req.getSession().setAttribute("register", register);
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
