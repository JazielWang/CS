package com.Jaziel.web;


import com.Jaziel.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王杰
 * @time 2020/10/6 19:52
 */
public class UserWebTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*spring web 监听器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");*/
//        ServletContext servletContext = req.getServletContext(); 和下方的方法相同

        ServletContext servletContext = this.getServletContext();

        // 使用方法获得 “app" ，是的用户不需要记住文件的名称
        // ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
        // 直接使用 spring-web 中的 ContextLoaderListener 监听器就可以实现
        // ApplicationContext app = WebApplicationContextUtils.getServletContext(servletContext);

        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService bean = app.getBean(UserService.class);
        bean.save();
    }
}
