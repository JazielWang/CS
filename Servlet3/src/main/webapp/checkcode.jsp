<%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2021/4/5
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>checkCode</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/Servlet3/sessionTest?time=" + new Date().getTime();
            }
        }
    </script>
    <style>
        div {
            color: red;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/checkCodeServlet" method="post">
    <table>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><img src="/Servlet3/sessionTest" id="img"></td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
    <div><%= request.getAttribute("ccCode") == null ? "" : request.getAttribute("ccCode")%>
    </div>
    <div><%= request.getAttribute("upCode") == null ? "" : request.getAttribute("upCode")%>
    </div>
</form>
</body>
</html>