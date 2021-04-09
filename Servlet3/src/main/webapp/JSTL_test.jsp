<%@ page import="com.example.dao.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2021/4/9
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test</title>
    <style>
        table{
            align-content: center;
        }
        table tr th{
            border: red solid 2px;
        }
    </style>
</head>
<body>
<%
    List<User> list = new ArrayList<>();
    list.add(new User("zhangsan", 23, new Date()));
    list.add(new User("lisi", 25, new Date()));
    list.add(new User("wangwu", 26, new Date()));
    request.setAttribute("list", list);
%>

<table id="table">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>birthday</th>
    </tr>
    <c:forEach items="${list}" var="list" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${list.name}</td>
            <td>${list.age}</td>
            <td>${list.date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
