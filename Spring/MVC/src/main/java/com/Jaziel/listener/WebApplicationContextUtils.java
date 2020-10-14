package com.Jaziel.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author 王杰
 * @time 2020/10/10 16:06
 */
public class WebApplicationContextUtils {
    public static ApplicationContext getServletContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
