<%@ page import="com.nhnacademy.user.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String userId = request.getParameter("name");
        ArrayList<User> arrayList = (ArrayList<User>)request.getServletContext().getAttribute("memberList");

        String id = null;
        String pwd = null;
        String name= null;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId().equals(userId)){
                id = arrayList.get(i).getId();
                name = arrayList.get(i).getName();
            }
        }
    %>
    <fmt:message key="name" bundle="${message}" />:<%= name%><br>
    <fmt:message key="id" bundle="${message}" />:<%= id%><br>
    <a href="/"><fmt:message key="back_to_main" bundle="${message}" /></a>
    <a href="/member_home.do"><fmt:message key="back_to_board" bundle="${message}" /></a>
</body>
</html>
