<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Insert title here</title>
</head>
<body background="images/pic-1.jpg">

	<div >
		<h1>${MSG}</h1>
		<form:form method="POST" action="CancelOrder.htm" commandName="order">
			<div style="color: #0000FF">${msg}</div>

		
	
	<table class="table table-striped">
  <c:forEach var="order" items="${list}" >
								
					
    <tr>
      <td class="danger"><b>storeID ID:</b></td>
      <td class="danger"><b>${order.storeID}</b></td>
    </tr> -
    <tr>
      <td class="danger"><b>orderID:</b></td>
      <td class="danger"><b>${order.orderID}</b></td>
    </tr>
    <tr>
      <td class="danger"><b>cartID:</b></td>
      <td class="danger"><b>${order.cartID}</b></td>
    </tr>
        <tr>
      <td class="danger"><b>orderStatus:</b></td>
      <td class="danger"><b>${order.orderStatus}</b></td>
    </tr>
    
   </c:forEach>
   <tr>
  
  
</table> 
 <center><input type="submit" value="Cancel order" class="btn btn-danger "></center>
</form:form>
	
	
</body>
</html>