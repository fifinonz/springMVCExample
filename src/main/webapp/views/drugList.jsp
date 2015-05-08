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
    <title>Prescribe A Drug</title>
</head>
<body>
<c:if test="${not empty error}">
  <div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
  <div class="msg">${msg}</div>
</c:if>

<form action="<c:url value='/prescribe' />" method='POST'>

  <%-- <select name = "pId" required>
    <c:forEach var="list" items="${patientList}">
        <option value="${list.pId}">${list.first_name}</option>
      </c:forEach>
      </select>
  <br>--%>

  <input type="" placeholder="Patient ID" name="pId" >

  <input type="text" placeholder="Drug name" name="drug_name" >


  <button>Prescribe</button>

</form>

</body>
</html>
