package com.example.filter;
/**
 * @author 王杰
 * @date 2021/4/9 13:47
 */
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebFilter(value = "/*")
public class FilterDemo01 implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter......");
        // 放行
        chain.doFilter(request, response);
    }
}
