<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 08.08.17
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style/main.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style/errors.css"/>">
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="sign-form">
    <sf:form name="f" id="f" method="POST" commandName="registerForm">

        <h1>Sign up</h1><br/>

        <span class="input"></span>
        <sf:input path="username" placeholder="Username" maxlength="35" size="3"
                  cssErrorClass="error"/><br/>

        <sf:password path="password" placeholder="Password" maxlength="25" size="3"
                     cssErrorClass="error"/><br/>

        <sf:password path="confirmPassword" placeholder="Confirm password" maxlength="25" size="3"
                     cssErrorClass="error"/><br/>

        <button type="submit" value="Sign Up" title="Submit form" class="icon-arrow-right" style="bottom: 90px;">
            <span>Sign up</span>
        </button>

        <div class="errors">
            <sf:errors path="*" element="div" cssClass="form-validation-errors"/>

            <div class="server-register-errors">
                <c:if test="${duplicateUsernameError != null}">
                    <span>Sorry, but this username is already exist.</span>
                </c:if>
                <c:if test="${PasswordsNotEqualError != null}">
                    <span>First and second passwords aren't equal. Try one more.</span>
                </c:if>
            </div>
        </div>
    </sf:form>
</div>
</body>
</html>
