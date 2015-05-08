<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Muthoni
  Date: 07/05/15
  Time: 10:58

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:if test="${not empty error}">
  <div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
  <div class="msg">${msg}</div>
</c:if>

<form action="<c:url value='/create' />" method='POST'>

  <input type="text" placeholder="first name" name="first_name" >
  <input type="text" placeholder="last name" name="last_name" >
  <input type="date" placeholder="D.o.B" name="dob" >

  <button> Create</button>

</form>

</body>
</html>
