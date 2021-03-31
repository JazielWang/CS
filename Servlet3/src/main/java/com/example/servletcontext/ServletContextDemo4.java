package com.example.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王杰
 * @date 2021/3/31 21:09
 */
@WebServlet("/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("/b.txt");
        System.out.println(realPath);
        String c = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);
        String a = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);
    }
}
