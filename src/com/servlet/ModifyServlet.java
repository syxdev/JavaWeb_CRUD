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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by syx on 2021/04/30 9:16
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
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
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String gender = req.getParameter("gender");

        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUsername(username);
        user.setPassword(password);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setGender(gender);

        IUserService userService = new UserServiceImpl();
        int i = userService.modifyUser(user);
        if (i <= 0) {
            req.getSession().setAttribute("msg", "修改失败");
            req.getRequestDispatcher("/JSP/error.jsp").forward(req, resp);
        } else {
            List<User> users = userService.userList();
            req.getSession().setAttribute("list", users);
            req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        }
    }
}
