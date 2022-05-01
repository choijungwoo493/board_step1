<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add_user_info_check.do" method="post">
    <table>
        <tr>
            <td><fmt:message key="id" bundle="${message}"/><br /></td>
            <td><input type="text" name="userId"></td>
        </tr>
        <tr>
            <td><td><fmt:message key="pwd" bundle="${message}"/><br /></td></td>
            <td><input type="text" name="userPwd"></td>
        </tr>
        <tr>
            <td><td><fmt:message key="name" bundle="${message}"/><br /></td></td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="추가">
                <input type="reset" value="취소">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
