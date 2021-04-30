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
import java.util.List;

/**
 * Created by syx on 2021/04/29 17:11
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
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
        IUserService userService = new UserServiceImpl();
        String id = req.getParameter("id");
        User user = new User();
        user.setId(Integer.valueOf(id));
        int i = userService.deleteUserById(user.getId());
        if (i <= 0) {
            req.setAttribute("msg", "删除失败");
            req.getRequestDispatcher("/JSP/error.jsp").forward(req, resp);
        } else {
            List<User> users = userService.userList();
            req.getSession().setAttribute("list", users);
            req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        }
    }
}
