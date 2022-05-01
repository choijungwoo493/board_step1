<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.nhnacademy.post.PostRepository" %>
<%@ page import="com.nhnacademy.post.Repository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method='post' action='/change_post.do'>
<table>
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
            postRepository.getPosts().remove(i);
            request.getServletContext().setAttribute("repository",postRepository);
        }
    }
%>
<tr>
    <td style="width: 20%;"><fmt:message key="title" bundle="${message}" /></td>
    <td colspan="2"><input type="text" placeholder="<%=title%>" name="title"></td>
</tr>
<tr>
    <td><fmt:message key="content" bundle="${message}" /></td>
    <td colspan="2" style="min-height: 200px; text-align: left;"><input type="text" placeholder="<%=content%>"name="content"></td>
</tr>
</tbody>
</table>
    <input type='submit' value='<fmt:message key="register" bundle="${message}" />' />
</form>
</body>
</html>
