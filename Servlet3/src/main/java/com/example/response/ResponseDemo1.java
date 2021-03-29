package com.example.response; /**
 * @author 王杰
 * @date 2021/3/29 20:24
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setStatus(302);
        response.setHeader("location", "/Servlet3/responseDemo2");*/

        response.sendRedirect("/Servlet3/responseDemo2");
        System.out.println("first...");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
