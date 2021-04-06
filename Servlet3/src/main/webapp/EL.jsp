<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2021/4/5
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>

<%
    List<Object> list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    request.setAttribute("list", list);
%>
${list[0]}
${pageContext.request.contextPath}
</body>
</html>
