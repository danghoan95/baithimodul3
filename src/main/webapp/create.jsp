<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/6/2023
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CREATE</title>
</head>
<body>
<form action="products?action=create" method="post">
    <p> NAME</p>
    <input type="text" name="name">
    <p> EMAIL</p>
    <input type="text" name="email">
    <p> DATE</p>
    <input type="date" name="date">
    <p> ADDRESS</p>
    <input type="text" name="address">
    <p> PHONE</p>
    <input type="text" name="phone">
    <p> CLASSROOM</p>
    <td>
        <select name="classroom" id="check ">
            <c:forEach items="${classroomList}" var="c">
                <option value="${c.class_id}">${c.name}</option>
            </c:forEach>
        </select>
    </td>
    <br>
    <p></p>
    <input type="submit"value="submit">
</form>
</body>
</html>
