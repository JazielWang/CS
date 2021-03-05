<%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2020/10/15
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/quick22" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="name">
    文件1：<input type="file" name="update">
    文件2：<input type="file" name="update">
    <input type="submit" name="提交">
</form>

<form action="${pageContext.request.contextPath}/quick21" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="name">
    文件1：<input type="file" name="update">
    文件2：<input type="file" name="update2">
    <input type="submit" name="提交">
</form>
</body>
</html>
