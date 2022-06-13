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
<%--@elvariable id="user" type=""--%>
<form:form modelAttribute="user" action="/register" novalidate="" method="post">
    <c:if test="${internal==true}">
        <div class="alert alert-danger" role="alert">
            Bạn hãy thử lại sau vài phút nữa !
        </div>
    </c:if>
    <form:input path="email" placeholder="email"></form:input>
    <form:input path="pass" placeholder="password"></form:input>
    <form:input path="fistName" placeholder="fistName"></form:input>
    <form:input path="lastName" placeholder="lastName"></form:input>
    <form:input path="province" placeholder="province"></form:input>
    <form:input path="address" placeholder="address"></form:input>

    <form:select path="day">
        <form:option selected="selected" disabled="" value="">Ngày</form:option>
        <form:options items="${listDay}"></form:options>

    </form:select>
    <div>/</div>
    <form:select path="month">
        <form:option selected="selected" disabled="" value=" ">Tháng</form:option>
        <form:options items="${listMonth}"></form:options>

    </form:select>
    <div>/</div>
    <form:select path="year">
        <form:option selected="selected" disabled="" value=" ">Năm</form:option>
        <form:options items="${listYear}"></form:options>
    </form:select>
    <input type="submit" value="register">
</form:form>
</body>
</html>
