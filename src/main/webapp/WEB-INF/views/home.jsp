<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 03.08.17
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Hello!</h2>
<s:url value="/login" var="login_url"/>
<s:url value="/register" var="register_url"/>
<div>
    <a href="${login_url}">Sign in </a>|
    <a href="${register_url}">Sign up</a>
</div>
</body>
</html>
