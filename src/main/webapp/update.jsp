<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/6/2023
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="products?action=update&&id=${student.getId()}" method="post">
  <p>NAME</p>
  <input type="text" name="name"  value="${student.name}" required >
  <p>EMAIL</p>
  <input type="text" name="email"  value="${student.email}" required >
  <p>DATE</p>
  <input type="date" name="date"  value="${student.date}" required >
  <p>ADDRESS</p>
  <input type="text" name="address"  value="${student.address}" required >
  <p>PHONE</p>
  <input type="text" name="phone" value="${student.phone}" required>

  <td>
    <select name="classroom" id="check ">
      <c:forEach items="${classroomList}" var="c">
        <option value="${c.class_id}">${c.name}</option>
      </c:forEach>
    </select>
  </td>
  <p></p>
  <input type="submit" value="submit">
</form>
</body>
</html>
