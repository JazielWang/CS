<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP</title>
</head>
<body>
<%
  Cookie[] cookies = request.getCookies();
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
        response.getWriter().write(strDate);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        cookie.setMaxAge(60 * 60 * 24);
        format = URLEncoder.encode(format, "utf-8");
        cookie.setValue(format);
        response.addCookie(cookie);
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
    response.addCookie(cookie);
    String s = "欢迎第一次登陆";
    response.getWriter().write(s);
  }%>
</body>
</html>