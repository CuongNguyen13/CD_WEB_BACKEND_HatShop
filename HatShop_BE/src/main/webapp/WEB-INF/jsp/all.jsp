<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 5/16/2022
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="list" items="${all}">
    <h3>${list.name}</h3>
    <h3>${list.date}</h3>
</c:forEach>
</body>
</html>
