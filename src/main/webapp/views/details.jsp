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
<body>

<c:if test="${not empty msg}">
  <div class="msg">${msg}</div>
</c:if>

<form action="<c:url value='/create' />" method='POST'>

  <input type="text" placeholder="first name" name="first_name" >
  <input type="text" placeholder="last name" name="last_name" >
  <input type="date" placeholder="D.o.B" name="dob" >

  <button> Create</button>

</form>

<br/>
<p>List of Patients</p>
<c:if test="${!empty patientlist}">
  <table class="tg">
  <tr>
  <th width="80">Patient ID</th>
  <th width="150">Patient Name</th>
  <th width="150">Date of Birth</th>
  <th width="150">Allocate Drug</th>
  </tr>
  <c:forEach items="${patientlist}" var="patient">
    <tr>
      <td>${patient.pId}</td>
      <td>${patient.first_name} ${patient.last_name}</td>
      <td>${patient.date}</td>
      <td><a href="<c:url value='/allocate?id=${patient.pId}' />" >Allocate Drug</a></td>
    </tr>
  </c:forEach>
  </table>


</body>
</html>
