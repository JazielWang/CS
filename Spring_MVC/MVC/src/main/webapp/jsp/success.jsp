<%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2020/10/11
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <sf:form method="post" commandName="user">
        姓名：<sf:input path="username"/>
        生日：<sf:input path="birthday" type="date"/>
        密码：<sf:password path="password"/>
        电话：<sf:input path="telephone"/>
        <input type="submit" value="提交">
    </sf:form>
    <%--Success! ${username} ${username}--%>
</h1>
</body>
</html>
