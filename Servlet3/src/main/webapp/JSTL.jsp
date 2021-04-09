<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2021/4/7
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL 标签库</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    list.add("hahah");
    list.add("aaa");
    list.add("bbb");
    request.setAttribute("list", list);
%>
<c:if test="${not empty list}">你好</c:if>
<c:choose>
    <c:when test="${list[0] == hahah}">hello</c:when>
    <c:when test="2">不好</c:when>
    <c:otherwise>others</c:otherwise>
</c:choose>
<c:forEach begin="0" end="10" var="i" varStatus="s">
    ${i} ${s.index} ${s.count} <br>
</c:forEach>

<c:forEach items="${list}" var="c" varStatus="s">
    ${c} ${s.index} ${s.count} <br>
</c:forEach>
</body>
</html>
