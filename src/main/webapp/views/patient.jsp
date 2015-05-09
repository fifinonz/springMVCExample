<%--
  Created by IntelliJ IDEA.
  User: Muthoni
  Date: 07/05/15
  Time: 10:58

--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Patient Page</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>
<h1>
  Add a Patient
</h1>

<c:url var="addAction" value="/add" ></c:url>

<form:form action="${addAction}" commandName="patient">
  <table>
    <c:if test="${!empty patient.first_name}">
      <tr>
        <td>
          <form:label path="pId">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="pId" readonly="true" size="8"  disabled="true" />
          <form:hidden path="pId" />
        </td>
      </tr>
    </c:if>
    <tr>
      <td>
        <form:label path="first_name">
          <spring:message text="First Name"/>
        </form:label>
      </td>
      <td>
        <form:input path="first_name" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="last_name">
          <spring:message text="Last Name"/>
        </form:label>
      </td>
      <td>
        <form:input path="last_name" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="dob">
          <spring:message text="D.O.B."/>
        </form:label>
      </td>
      <td>
        <form:input path="dob" />
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <c:if test="${!empty patient.first_name}">
          <input type="submit"
                 value="<spring:message text="Edit Patient Details"/>" />
        </c:if>
        <%--@elvariable id="patient" type="com.springapp.model.Patient"--%>
        <c:if test="${empty patient.first_name}">
          <input type="submit"
                 value="<spring:message text="Add New Patient"/>" />
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
<br>

<h3>Patients List</h3>
<c:if test="${!empty listPatients}">
  <table class="tg">
    <tr>
      <th width="80">Patient ID</th>
      <th width="120">Patient First Name</th>
      <th width="120">Patient Last Name</th>
      <th width="120">Patient D.O.B.</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listPatients}" var="patient">
      <tr>
        <td>${patient.pId}</td>
        <td>${patient.first_name}</td>
        <td>${patient.last_name}</td>
        <td>${patient.dob}</td>
        <td><a href="<c:url value='/edit/${patient.pId}' />" >Edit</a></td>
        <td><a href="<c:url value='/remove/${patient.pId}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>