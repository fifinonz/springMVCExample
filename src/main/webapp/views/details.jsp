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
  <title>Enter A New Patient</title>
</head>
<h1 style="text-align: center">
  Patient Registration Form
</h1>
<h2>
  Add a Patient
</h2>

<body>

<c:if test="${not empty message}">
  <div class="msg">${message}</div>
</c:if>

<form style="border: groove"  action="<c:url value='/create' />" method='POST'>

  <input style="color: bisque" type="text" placeholder="first name" name="first_name" >
  <input style="color: bisque"type="text" placeholder="last name" name="last_name" >
  <input style="color: bisque" type="date" placeholder="D.o.B" name="dob" >

  <br>
  <br>
  <button> Create</button>

</form>

</body>
</html>
