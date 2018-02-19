<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizza ordering system</title>
</head>
<body bgcolor="Green">
<h2>${MSG }</h2>
<table class="table table-striped">
  
    <tr>
      
      <td class="danger"><b>storeID</b></td>
      <td class="danger"><b>name</b></td>
      <td class="danger"><b>street</b></td>
      <td class="danger"><b>city</b></td>
      <td class="danger"><b>state</b></td>
      <td class="danger"><b>pincode</b></td>
      <td class="danger"><b>mobileNo</b></td>
    </tr>
  
  
</table> 
<table class="table table-striped">
  <c:forEach items="${list}" var="list">
    <tr>
      <td><c:out value="${list.storeID}" /></td>
      <td><c:out value="${list.name}" /></td>
      <td><c:out value="${list.street}" /></td>
      
      <td><c:out value="${list.city}" /></td>
      <td><c:out value="${list.state}" /></td>
      <td><c:out value="${list.pincode}" /></td>
      <td><c:out value="${list.mobileNo}" /></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>