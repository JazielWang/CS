<%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2020/10/29
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户信息递交页面</h1>
<form name="accountFoum" action="${pageContext.request.contextPath}/account/save" method="post">
    <%--此处 name 应该和 account 的属性名称相同，否则无法将数据保存在数据库中--%>
    账户名称：<input type="text" name="name">
    账户金额：<input type="text" name="money">
    <input type="submit" value="保存">
</form>
</body>
</html>
