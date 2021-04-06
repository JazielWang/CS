package com.example.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 王杰
 * @date 2021/4/2 19:58
 */
@WebServlet("/cookieTest")
public class CookieDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=utf-8");
        Boolean flag = true;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    flag = false;
                    // 不是第一次登陆
                    String time = cookie.getValue();
                    time = URLDecoder.decode(time, "utf-8");
                    String strDate = "欢迎回来，你上一次登陆时间为:" + time;
                    resp.getWriter().write(strDate);
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
                    String format = dateFormat.format(date);
                    cookie.setMaxAge(60 * 60 * 24);
                    format = URLEncoder.encode(format, "utf-8");
                    cookie.setValue(format);
                    resp.addCookie(cookie);
                    break;
                }
            }
        }
        if (flag) {
            // 第一次登陆
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            String format = dateFormat.format(date);
            format = URLEncoder.encode(format, "utf-8");
            Cookie cookie = new Cookie("lastTime", format);
            cookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(cookie);
            String s = "欢迎第一次登陆";
            resp.getWriter().write(s);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
