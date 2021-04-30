package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by syx on 2021/04/28 18:05
 */
public class LoginFilter implements Filter {
    @Override
    public void destroy() {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Object username = request.getSession().getAttribute("username");
        if (null == username) {
            request.getSession().setAttribute("code", "error");
            request.setAttribute("msg", "登录错误！");
            request.getRequestDispatcher("JSP/error.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
