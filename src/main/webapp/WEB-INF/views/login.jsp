<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 09.08.17
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style/main.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style/errors.css"/>">
</head>
<body>

<jsp:include page="header.jsp"/>

<form name="f" id="f" action="<c:url value="/auth/login_check"/>" method="POST">
    <h1>Log in</h1><br/>

    <span class="input"></span>
    <input type="text" name="username" placeholder="Username"/>

    <span id="passwordMeter"></span>
    <input type="password" name="password" id="password" placeholder="Password"/>

    <button type="submit" value="Sign Up" title="Submit form" class="icon-arrow-right"><span>Sign up</span></button>

    <div class="errors">
        <sf:errors path="*" element="div" cssClass="form-validation-errors"/>

        <div class="server-errors">
            <c:if test="${param.error != null}">
                <span>Your password or username is incorrect</span>
            </c:if>
        </div>
    </div>
</form>
</body>
</html>

