package com.Jaziel.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;


import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author 王杰
 * @date 2021/3/18 15:48
 */
public class MyServletConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        DispatcherServlet appServlet = new DispatcherServlet();
        ServletRegistration.Dynamic regis = servletContext.addServlet("appServlet", appServlet);
        regis.addMapping("/");
        regis.setMultipartConfig(new MultipartConfigElement(""));
    }
}
