<%@ page import="org.apache.commons.lang3.ObjectUtils" %>
<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if(!ObjectUtils.isEmpty(request.getParameter("message"))){ %>
    <%=request.getParameter("message")%><br>
<%
}
%>
<fmt:message key="add_user_fail" bundle="${message}" /><br><a href="/"><fmt:message key="back_to_list" bundle="${message}" /></a>
</body>
</html>
