<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/guest_list.do"><fmt:message key="guest_list" bundle="${message}"/></a>
    <a href="/"><fmt:message key="go_main" bundle="${message}"/></a>
</body>
</html>