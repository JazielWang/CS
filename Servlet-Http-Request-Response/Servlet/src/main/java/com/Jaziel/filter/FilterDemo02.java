package com.Jaziel.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 王杰
 * @date 2021/4/9 13:50
 */
public class FilterDemo02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter02.....");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
