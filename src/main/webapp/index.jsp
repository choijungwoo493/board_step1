<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
  <meta charset="UTF-8" />
  <title><fmt:message key = "boardName" bundle="${message}"/>  </title>
</head>
<body>
<a href="/manager_home.do"><fmt:message key="managerHome" bundle="${message}" /></a><br />
<a href="/member_home.do"><fmt:message key="memberHome" bundle="${message}" /></a><br />
<br />
<a href="/logout.do"><fmt:message key="logout" bundle="${message}" /></a><br />
<a href="/change-lang.do?lang=ko"><fmt:message key="ko" bundle="${message}" /></a> | <a href="/change-lang.do?lang=en"><fmt:message key="en" bundle="${message}" /></a><br />
</body>
</html>
