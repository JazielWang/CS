<%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2020/10/11
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>spring MVC</title>
    <style type="text/css">
        .errorMessage{
            width: 300px;
        }
        input.error{
            border: 1px solid red;
        }
    </style>
</head>
<body>
<h1>
    <sf:form action="POST" modelAttribute="user">
        <sf:errors element="div" path="*" cssStyle="color: red; background-color: #ffcccc; border: 1px solid red" />
        <table>
            <tr>
                <td>username:</td>
                <td><sf:input path="username" cssClass="error"/></td>
                <td class="errorMessage"><sf:errors path="username" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><sf:password path="password" cssClass="error"/></td>
                <td class="errorMessage"><sf:errors path="password" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>telephone:</td>
                <td><sf:input path="telephone" cssClass="error"/></td>
                <td class="errorMessage"><sf:errors path="telephone" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>gender:</td>
                <td><sf:input path="gender" cssClass="error"/></td>
                <td class="errorMessage"><sf:errors path="gender" cssStyle="color: red"/></td>
            </tr>
        </table>

        <input type="submit" value="提交">
    </sf:form>
</h1>
</body>
</html>
