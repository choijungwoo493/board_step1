<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method='post' action='/write.do'>
    <fmt:message key="title" bundle="${message}" />:
    <label>
        <input type='text' name='title' />
    </label>
    <br />
    <fmt:message key="content" bundle="${message}" />:
    <label>
    <textarea type='text' name='content'></textarea>
    </label><br />

    <input type='submit' value='<fmt:message key="register" bundle="${message}" />' />
</form>
</body>
</html>
