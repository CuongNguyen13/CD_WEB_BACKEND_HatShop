<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 5/16/2022
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<form action="/login1" method="post">--%>
<%--    <input name="email" required>--%>
<%--    <input name="password" required>--%>
<%--    <c:if test="${register==true}">--%>
<%--        <div class="alert alert-success" role="alert">--%>
<%--            Bạn đã đăng kí tài khoản thành công--%>
<%--        </div>--%>
<%--    </c:if>--%>
<%--    <c:if test="${login==false}">--%>
<%--        <div class="alert alert-danger" role="alert">--%>
<%--            Thông tin đăng nhập không đúng !--%>
<%--        </div>--%>
<%--    </c:if>--%>
<%--    <input type="submit" value="Login">--%>
<%--</form>--%>

<%--<form:form action="/login1" method="post" modelAttribute="user">--%>
<%--    <form:input path="email" />--%>
<%--    <form:input path="pass" />--%>
<%--    <a href="/register"><input type="submit" value="register"></a>--%>
<%--    <a href="/forgetpass"><input type="submit" value="Forgotpass"></a>--%>
<%--</form:form>--%>
<%--<a href="/register"><input type="submit" value="register"></a>--%>
<%--<a href="/forgetpass"><input type="submit" value="Forgotpass"></a>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form action="/login" method="post">
    <input name="email">
    <input name="password">
    <input type="submit">
</form>
</body>
</html>

</body>
</html>
