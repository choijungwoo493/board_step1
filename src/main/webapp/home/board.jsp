<%@ page import="com.nhnacademy.post.PostRepository" %>
<%@ page import="com.nhnacademy.post.Repository" %>
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
<%
    String user = null;
    if (session.getAttribute("id") != null) {
        user = (String) session.getAttribute("id");
    }
%>
<div class="container">
    <div class="row">
        <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
            <thead>
            <tr>
                <th style="background-color: #eeeeee; text-align: center;"><fmt:message key="number" bundle="${message}" /></th>
                <th style="background-color: #eeeeee; text-align: center;"><fmt:message key="title" bundle="${message}" /></th>
                <th style="background-color: #eeeeee; text-align: center;"><fmt:message key="writer" bundle="${message}" /></th>
                <th style="background-color: #eeeeee; text-align: center;"><fmt:message key="writeDay" bundle="${message}" /></th>
                <th style="background-color: #eeeeee; text-align: center;"><fmt:message key="viewCnt" bundle="${message}" /></th>
            </tr>
            </thead>
            <tbody>
            <% PostRepository postRepository = (Repository) request.getServletContext().getAttribute("repository");
            if(!ObjectUtils.isEmpty(postRepository)){
                for (int i = 0; i < postRepository.getPosts().size(); i++) {
            %>
            <tr>
                <td><%=i+1%></td>
                <td><a href="/view_post.do?id=<%=postRepository.getPosts().get(i).getId()%>"><%=postRepository.getPosts().get(i).getTitle()%></a></td>
                <td><a href="/view_user_post_list.do?name=<%=postRepository.getPosts().get(i).getWriterUserId()%>"><%=postRepository.getPosts().get(i).getWriterUserId()%></a></td>
                <td><%=postRepository.getPosts().get(i).getWriteTime()%></td>
                <td><%=postRepository.getPosts().get(i).getViewCount()%></td>
            </tr>
            <%
                    }
            }
            %>

            </tbody>
        </table>
        <a href="/write.do" class="btn btn-primary pull-right"><fmt:message key="register" bundle="${message}" /></a>
        <a href="/index.do" class="btn btn-primary pull-right"><fmt:message key="back_to_main" bundle="${message}" /></a><br>
        <a href="/change-lang.do?lang=ko&jsp=/home/board.jsp"><fmt:message key="ko" bundle="${message}" /></a> | <a href="/change-lang.do?lang=en&jsp=/home/board.jsp"><fmt:message key="en" bundle="${message}" /></a><br />
    </div>
</div>
</body>
</html>
