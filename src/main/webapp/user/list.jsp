<%@ page import="com.nhnacademy.user.User" %>
<%@ page import="java.util.ArrayList" %>
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
    <button type="button" onclick="location.href='/add_user.do'"><fmt:message key="add_user" bundle="${message}" /></button><br><br>
    <%
        // MemberList 탐색 넘긴 회원정보를 추출한다.
        ArrayList<User> memberList = (ArrayList<User>)application.getAttribute("memberList");
        if(!ObjectUtils.isEmpty(memberList)){
    %>
    <%
        for( User user : memberList){
    %>

    <div style="display: inline-block">
        <%= user.getId()%>
    </div>
    <div style="display: inline-block">
        <input type='button' value="<fmt:message key="view_info" bundle="${message}" />"  onclick="location.href='/view_user_info.do?name=<%=user.getId()%>&pwd=<%=user.getPassword()%>'"><br />
    </div>
    <div style="display: inline-block">
        <input type='button' value="<fmt:message key="modify_info" bundle="${message}" />" onclick="location.href='/modify_user_info.do?name=<%=user.getId()%>&pwd=<%=user.getPassword()%>'"><br />
    </div>
    <div style="display: inline-block">
        <input type='button' value="<fmt:message key="delete" bundle="${message}" />" onclick="location.href='/delete_user_info.do?name=<%=user.getId()%>&pwd=<%=user.getPassword()%>'"><br />
    </div>
    <br>
    <%
            }
        }
    %>

    <br><br><a href="/"><fmt:message key="back_to_main" bundle="${message}" /></a>
</body>
</html>
