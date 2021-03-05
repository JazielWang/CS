<%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2020/10/29
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>展示账户信息</h1>
<table border="1">
    <tr>
        <td>账户id</td>
        <td>账户名称</td>
        <td>账户金额</td>
    </tr>

    <c:forEach items="${accountList}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.name}</td>
            <td>${account.money}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
