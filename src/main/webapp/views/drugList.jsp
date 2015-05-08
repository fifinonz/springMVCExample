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
    <title>Prescribe Drugs</title>
</head>
<body>

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

  <input type="hidden" placeholder="Patient ID" name="pId" value="${patient.pId}">

  <input type="text" placeholder="Drug name" name="drug_name" required >


  <button>Prescribe</button>

</form>

<br/>
<c:if test="${!empty druglist}">
  <p>List of Drugs</p>
  <table class="tg">
    <tr>
      <th width="80">Drug ID</th>
      <th width="150">Drug Name</th>
      <th width="80">Patient ID</th>
      <th width="250">View Patients Taking this Drug</th>
    </tr>
    <c:forEach items="${druglist}" var="drug">
      <tr>
        <td>${drug.DId}</td>
        <td>${drug.drug_name} </td>
        <td>${drug.pId}</td>
        <td><a href="<c:url value='/list' />" >View Patients</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>
