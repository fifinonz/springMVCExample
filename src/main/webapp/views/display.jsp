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
    <title>View Drugs Allocated</title>
</head>
<body>
<table>
  <c:forEach var="list"  items="${drugsList}">
    <tr>
        <%--<td>${List.id}</td>--%>
      <td>${list.drug_name}</td>
      <td>${list.pId}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
