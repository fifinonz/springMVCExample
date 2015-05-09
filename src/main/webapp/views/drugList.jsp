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
    <title>Allocate Drug</title>
</head>

<h1 style="text-align: center">
    Prescribe A Drug
</h1>
<h2>
    Add a Drug
</h2>
<body>

<form style="border: groove" action="<c:url value='/drug'/>" method='POST'>

  <input style="color: bisque" type="text" placeholder="Patient ID" name="pId" >
  <input style="color: bisque" type="text" placeholder="Drug name" name="drug_name" >

    <br>
    <br>
  <button>Submit</button>

</form>

</body>
</html>
