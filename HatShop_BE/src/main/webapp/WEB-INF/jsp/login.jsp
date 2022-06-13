<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 5/16/2022
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <input name="email" required>
    <input name="password" required>
    <c:if test="${register==true}">
        <div class="alert alert-success" role="alert">
            Bạn đã đăng kí tài khoản thành công
        </div>
    </c:if>
    <c:if test="${login==false}">
        <div class="alert alert-danger" role="alert">
            Thông tin đăng nhập không đúng !
        </div>
    </c:if>
    <input type="submit" value="Login">
</form>
<a href="/register"><input type="submit" value="register"></a>
<a href="/forgetpass"><input type="submit" value="Forgotpass"></a>
</body>
</html>
