package com.example.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 王杰
 * @date 2021/4/5 16:03
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            if ("zhangsan".equals(username) && "123".equals(password)) {
                session.setAttribute("user", username);
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            } else {
                req.setAttribute("upCode", "用户名或者密码错误");
                req.getRequestDispatcher("/checkcode.jsp").forward(req, resp);
            }
        } else {
            // 验证码错误
            req.setAttribute("ccCode", "验证码错误");
            req.getRequestDispatcher("/checkcode.jsp").forward(req, resp);
        }
    }
}
