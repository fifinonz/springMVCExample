<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Muthoni
  Date: 08/05/15
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Drugs</title>
  </head>

<body>
<div class = "navbar navbar-default">Drugs List</div>
<table>
  <tr>
    <th>Drug ID</th>
    <th>Drug Name</th>
    <th>Patient ID</th>
  </tr>
  <c:forEach var="list"  items="${drugsList}">
    <tr>
      <td>${list.DId}</td>
      <td>${list.drug_name}</td>
      <td>${list.pId}</td>
    </tr>
  </c:forEach>
</table>

</body>
</body>
</html>
