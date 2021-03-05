<%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2020/10/14
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/quick14" method="post">
    <%--表名是第几个对象的 username age--%>
    <input type="text" name="userList[0].name">
    <input type="text" name="userList[0].age">
    <input type="text" name="userList[1].name">
    <input type="text" name="userList[1].age">
    <input type="submit" value="提交">
</form>
</body>
</html>
