package com.Jaziel.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 王杰
 * @time 2020/10/10 15:12
 */
public class ContextLoadListen implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        /*读取 web.xml 中的初始化变量*/
        String initParameter = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(initParameter);
        /*将spring上下文存储到 ServletContext 域中*/
        servletContext.setAttribute("app", app);
        System.out.println("spring容器构造完毕...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
