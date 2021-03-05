package com.Jaziel.interceptor;

import com.Jaziel.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 王杰
 * @time 2020/10/19 13:58
 */
public class AccessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录，即判断 session 中是否有 user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null){
            // 表示没有登录
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        // 否则就放行
        return true;
    }
}
