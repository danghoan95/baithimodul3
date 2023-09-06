<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/6/2023
  Time: 9:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<form action="products?action=search" method="post">
    <input type="text" name="name" placeholder="Search name">
    <p></p>
    <input type="submit" value="submit">
    <p></p>
    <a href="products?action=create">Create</a>
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>DATE</th>
        <th>ADDRESS</th>
        <th>PHONE</th>
        <th>CLASS_ID</th>

    </tr>
    <c:forEach items="${students}" var="s">
        <tr>
            <td><c:out value="${s.id}"></c:out></td>
            <td><c:out value="${s.name}"></c:out></td>
            <td><c:out value="${s.email}"></c:out></td>
            <td><c:out value="${s.date}"></c:out></td>
            <td><c:out value="${s.address}"></c:out></td>
            <td><c:out value="${s.phone}"></c:out></td>
            <td><c:out value="${s.classroom.getName()}"></c:out></td>
            <td><a href="products?action=update&&id=${s.getId()}">Update</a></td>
            <td><a href="products?action=delete&&id=${s.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
