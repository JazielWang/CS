package com.example.filter;
/**
 * @author 王杰
 * @date 2021/4/9 13:47
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class FilterDemo02 implements Filter {
    List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        String realPath = servletContext.getRealPath("/pbc.txt");
        System.out.println(realPath);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                list.add(s);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ServletRequest proxyServlet = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("getParameter".equals(method.getName())) {
                    String value = (String) method.invoke(request, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(request, args);
            }
        });
        chain.doFilter(proxyServlet, response);
    }
}
