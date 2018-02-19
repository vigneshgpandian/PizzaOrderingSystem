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
<body background="images/pic-1.jpg">

<table class="table table-striped">
  
    <tr>
      <td class="danger"><b>food ID:</b></td>
      <td class="danger"><b>${food.foodID}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>name:</b></td>
      <td class="danger"><b>${food.name}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>type:</b></td>
      <td class="danger"><b>${food.type}</b></td>
    </tr>
        <tr>
      <td class="danger"><b>foodSize:</b></td>
      <td class="danger"><b>${food.foodSize}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>quantity:</b></td>
      <td class="danger"><b>${food.quantity}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>price:</b></td>
      <td class="danger"><b>${food.price}</b></td>
    </tr>
   
  
</table> 

</body>
</html>