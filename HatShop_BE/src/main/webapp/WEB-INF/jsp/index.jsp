<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 5/16/2022
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/search">
    <input name="field">
    <input type="submit" value="click">
</form>


<form:form action="/CC" method="post" modelAttribute="user" acceptCharset="UTF-8">
    <table>
        <tbody>
        <tr>
            <td>UserName</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Pass</td>
            <td><form:input path="pass"/></td>
        </tr>
        <tr>
            <td>fistName</td>
            <td><form:input path="fistName"/></td>
        </tr>
        <tr>
            <td>lastName</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>province</td>
            <td><form:input path="province"/></td>
        </tr>
        <tr>
            <td>address</td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td>day</td>
            <td><form:input path="day"/></td>
        </tr>
        <tr>
            <td>month</td>
            <td><form:input path="month"/></td>
        </tr>
        <tr>
            <td>year</td>
            <td><form:input path="year"/></td>
        </tr>

        <td>
            <button type="submit">Submit</button>
        </td>
        <td><a href="/">
            <button type="button">Cancel</button>
        </a></td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>
