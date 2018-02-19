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

	<div>
		<h1>${MSG}</h1>
		<form:form method="POST" action="ViewFoodDetails.htm"
			commandName="food" id="validate">
			<div style="color: #0000FF">${msg}</div>

			<table align="center" width=150px height=150px>
				<tr>
					<td colspan="2"><h1>
							<center>
								<span class="label label-warning">Available Food Items</span>
							</center>
						</h1></td>
				</tr>

				<tr>
					<td><span class="label label-default">Select Food ID</span></td>
					<td><select name="foodID">
							<option>foodID</option>
							<c:forEach var="listfood" items="${listfood}">
								<option value="${listfood.foodID}">${listfood.foodID}</option>
							</c:forEach>
					</select>
				</tr>
				<tr>
					<td colspan="2"><center>
							<input type="submit" value="Find food" class="btn btn-danger">
						</center></td>
				</tr>
			</table>
			<br>
			<br>
			<br>
			<br>

		</form:form>
	</div>
	<br />
	<c:if test="${status != 0}">
		<div>

			<form:form method="POST" action="AddToCart.htm" commandName="cart"
				id="validate">
				<div style="color: #0000FF">${msg}</div>

				<table align="center" width=150px height=150px>
					<tr>
						<td colspan="2"><h1>
								<center>
									<span class="label label-warning">Food Details</span>
								</center>
							</h1></td>
					</tr>

					<tr>
						<td class="danger"><b><span class="label label-default">Food
									ID:</span></b></td>
						<td class="danger"><b><span class="label label-primary">${food.foodID}</span></b></td>
						<td><form:input path="foodID" value="${food.foodID}"
								type="hidden" /></td>
						<td><font color="black"><form:errors path="foodID"
									cssclass="error" /></font></td>
					</tr>

					<tr>
						<td class="danger"><b><span class="label label-default">Food
									Type:</span></b></td>

						<td><center>
								<span class="label label-primary">${food.type}s</span>
							</center></td>
						<td><br></td>
						<td><br></td>
						<td><form:input path="type" value="${food.type}"
								type="hidden" /></td>
						<td><font color="black"><form:errors path="foodID"
									cssclass="error" /></font></td>
					</tr>

					<tr>

						<td colspan="2"><form:input class="form-control"
								placeholder="quantity" path="quantity" /></td>
						<td><font color="black"><form:errors path="quantity"
									cssclass="error" /></font></td>
					</tr>



					<tr>
						<td colspan="2"><center>
								<input type="submit" value="Add to Cart" class="btn btn-danger">
							</center></td>
					</tr>
				</table>
				<br>
				<br>
				<br>
				<br>

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
							required : true,
							number : true,
							min : 1
						}
					}
				});
			</script>
		</div>
		<br />
	</c:if>
</body>
</html>