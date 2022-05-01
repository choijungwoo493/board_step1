<%@ page import="com.nhnacademy.post.PostRepository" %>
<%@ page import="com.nhnacademy.post.Repository" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th><fmt:message key="view_post" bundle="${message}" /></th>
    </tr>
    </thead>


    <tbody>
    <%
        String title = null;
        String userId = null;
        LocalDateTime date = null;
        String content = null;
        PostRepository postRepository = (Repository) request.getServletContext().getAttribute("repository");
        for (int i = 0; i < postRepository.getPosts().size(); i++) {
            if( (int) postRepository.getPosts().get(i).getId() == Integer.parseInt(request.getParameter("id"))){
                title = postRepository.getPosts().get(i).getTitle();
                userId = postRepository.getPosts().get(i).getWriterUserId();
                date = postRepository.getPosts().get(i).getWriteTime();
                content = postRepository.getPosts().get(i).getContent();
            }
        }
    %>
    <tr>
        <td style="width: 20%;"><fmt:message key="title" bundle="${message}" /></td>
        <td colspan="2"><%=title%></td>
    </tr>
    <tr>
        <td><fmt:message key="writer" bundle="${message}" /></td>
        <td colspan="2"><%=userId%></td>
    </tr>
    <tr>
        <td><fmt:message key="writeDay" bundle="${message}" /></td>
        <td colspan="2"><%=date%></td>
    </tr>
    <tr>
        <td><fmt:message key="content" bundle="${message}" /></td>
        <td colspan="2" style="min-height: 200px; text-align: left;"><%=content%></td>
    </tr>
    </tbody>
</table>
<a href="/member_home.do"><fmt:message key="list" bundle="${message}" /></a>
<%

    if (request.getSession().getAttribute("id") != null && request.getSession().getAttribute("id").equals(postRepository.getPost(Integer.parseInt(request.getParameter("id"))).getWriterUserId())) {
%>
<a href="/update_post.do?id=<%=request.getParameter("id")%>"><fmt:message key="modify" bundle="${message}" /></a>
<a href="/delete_post.do?id=<%=request.getParameter("id")%>"><fmt:message key="delete" bundle="${message}" /></a>
<%
    }
%>
</body>
</html>
