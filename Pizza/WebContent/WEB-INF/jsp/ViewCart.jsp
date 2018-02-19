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
		<h1><center><span class="label label-warning">Cart Details</span></center>
						</h1><
		<c:forEach var="cart" items="${list}">
		<form:form method="POST" action="ModifyCart.htm" commandName="cart" id="validate">
			<%-- <div style="color: #0000FF">${msg}</div> --%>

			<table align="center" width=150px height=120px>
			
				<tr>
					<td class="danger"><b><span class="label label-default">Food ID:</span></b></td>
					<td><span class="label label-default">${cart.foodID}</span></td>
					<td><form:input class="form-control" placeholder="name" path="userID"  value="${cart.userID}" type="hidden"/>
					<form:input class="form-control" placeholder="name" path="foodID"  value="${cart.foodID}" type="hidden"/>
					<form:input class="form-control" placeholder="name" path="cartID"  value="${cart.cartID}" type="hidden"/>
					<font color="black"><form:errors path="foodID"
								cssclass="error" /></font></td>
				</tr>
				
				<%-- <tr>
					<td class="danger"><b><span class="label label-default">Type:</span></b></td>
					<td><form:input class="form-control" placeholder="name" path="type" value="${cart.type}" /></td>
					<td><font color="black"><form:errors path="type"
								cssclass="error" /></font></td>
				</tr> --%>
				<tr>
					<td class="danger"><b><span class="label label-default">Type:</span></b></td>
					<td><select name="type">
								<option>"${cart.type}"</option>
								<option value="Large">Large</option>
								<option value="Medium">Medium</option>
								<option value="Regular">Regular</option>
								</select>
					<td><font color="black"><form:errors path="type"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b><span class="label label-default">quantity:</span></b></td>
					<td><form:input class="form-control" placeholder="name" path="quantity" value="${cart.quantity}" /></td>
					<td><font color="black"><form:errors path="quantity"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b><span class="label label-default">cost:</span></b></td>
					<td><form:input class="form-control" placeholder="name" path="cost" value="${cart.cost}" /></td>
					<td><font color="black"><form:errors path="cost"
								cssclass="error" /></font></td>
				</tr>
				

				<tr>
					<td colspan="2"><center>
							<input type="submit" value="Conform Modify cart Details"
								class="btn btn-danger">
						</center></td>
						<td colspan="2"><center>
							<a href="DeleteCart.htm?cartID=${cart.cartID }"><button type="button" name="cartID" value="${cart.cartID }" class="btn btn-danger" >Delete</buttom></a>
						</center></td>
				</tr>
				
			</table>
			

		</form:form>
		<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
		<script
			src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
		<script
			src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
		<script>
			// just for the demos, avoids form submit
			$("#validate").validate({
				rules : {
					quantity : {
						required:true,
						number: true
					},
					cost : {
						required : true,
						 pattern: /^(\d+|\d+.\d{1,2})$/
					}
					
				}
			});
		</script>
		</c:forEach>
	</div>
	<br />
	<center>
							<a href="MakeOrder.htm"><button type="button" name="" value="" class="btn btn-danger" >Make Order</buttom></a>
						</center></td>
	
</body>
</html>