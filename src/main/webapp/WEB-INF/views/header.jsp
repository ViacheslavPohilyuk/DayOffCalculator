<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 10.08.17
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style/header.css" />">
</head>
<body>
<header class="header-global-new" aria-label="Main" role="banner">
    <div class="logo-with-name">
        <div>
            <a href="<c:url value="/"/>">
                <img src="<c:url value="/resources/images/datecalc-100.png" />" width="80" height="80" itemprop="logo">
            </a>
        </div>
        <div>
            <h1 class="name">Date Calculator</h1>
        </div>
        <div class="refs">
            <div>
                <a href="<c:url value="/login" />">
                    <h3>Login</h3>
                </a>
            </div>
            <div>or</div>
            <div>
                <a href="<c:url value="/register" />">
                    <h3>Sign up</h3>
                </a>
            </div>
        </div>
    </div>
</header>
</body>
</html>
