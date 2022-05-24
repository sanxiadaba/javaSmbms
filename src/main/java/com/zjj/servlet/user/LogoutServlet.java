package com.zjj.servlet.user;

import com.zjj.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //清除session
        req.getSession().removeAttribute(Constants.USER_SESSION);

        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        if(o==null){
            System.out.println("xiaochule");
        }

        resp.sendRedirect(req.getContextPath()+"/login.jsp");//返回登录页面
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
