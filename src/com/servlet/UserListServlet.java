package com.servlet;

import com.alibaba.fastjson.JSONArray;
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
import java.util.List;

/**
 * Created by syx on 2021/04/29 15:07
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
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
        List<User> users = userService.userList();
        req.setAttribute("list", users);
        req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(users));
        writer.flush();
        writer.close();
    }
}
