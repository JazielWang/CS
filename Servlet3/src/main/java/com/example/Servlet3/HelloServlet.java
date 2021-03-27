package com.example.Servlet3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

/**
 * @author 王杰
 */
@WebServlet(name = "helloServlet", value = "/demo2")
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet3.0......");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}