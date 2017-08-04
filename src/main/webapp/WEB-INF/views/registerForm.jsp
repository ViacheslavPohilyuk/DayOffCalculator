<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Register</h1>

<c:if test="${duplicateUsernameError != null}">
    <span style="color: red;">Sorry, but this username is already exist.</span>
</c:if>
<c:if test="${PasswordsNotEqualError != null}">
    <span style="color: red;">First and second passwords aren't equal. Try one more.</span>
</c:if>

<sf:form method="POST" commandName="registerForm">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <sf:label path="username"
              cssErrorClass="error">Username</sf:label>:
    <sf:input path="username" cssErrorClass="error"/><br/>

    <sf:label path="password"
              cssErrorClass="error">Password</sf:label>:
    <sf:password path="password" cssErrorClass="error"/><br/>

    <sf:label path="second_password"
              cssErrorClass="error">Second Password</sf:label>:
    <sf:password path="second_password" cssErrorClass="error"/><br/>
    <input type="submit" value="Register"/>
</sf:form>
</body>
</html>