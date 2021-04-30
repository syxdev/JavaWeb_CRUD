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

/**
 * Created by syx on 2021/04/27 17:03
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        IUserService iUserService = new UserServiceImpl();

        User userLogin = iUserService.login(user);
        if (username.equals(userLogin.getUsername()) && password.equals(userLogin.getPassword())) {
            System.out.println(username + "=" + userLogin.getUsername());
            System.out.println(password + "=" + userLogin.getPassword());
            req.getSession().setAttribute("username", user);
            resp.sendRedirect("/JSP/success.jsp");
        } else {
            System.out.println(username + "=" + userLogin.getUsername());
            System.out.println(password + "=" + userLogin.getPassword());
            req.getRequestDispatcher("/JSP/error.jsp").forward(req, resp);
        }
    }
}
