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
      <td class="danger"><b>Store ID:</b></td>
      <td class="danger"><b>${store.storeID}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>name:</b></td>
      <td class="danger"><b>${store.name}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>street:</b></td>
      <td class="danger"><b>${store.street}</b></td>
    </tr>
        <tr>
      <td class="danger"><b>city:</b></td>
      <td class="danger"><b>${store.city}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>state:</b></td>
      <td class="danger"><b>${store.state}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>pincode:</b></td>
      <td class="danger"><b>${store.pincode}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>mobileNo:</b></td>
      <td class="danger"><b>${store.mobileNo}</b></td>
    </tr>
  
  
</table> 

</body>
</html>