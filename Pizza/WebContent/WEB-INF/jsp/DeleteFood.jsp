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
		<form:form method="POST" action="ConformDeleteFood.htm" commandName="food">
			<div style="color: #0000FF">${msg}</div>

			<table align="center" width=150px height=120px>
				<tr>
					<td colspan="2"><h1>
							<center><span class="label label-warning">Search For a Food</span></center>
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
	<div >
<h1>${MSG}</h1>
					<form:form method="POST" action="DeleteFood.htm" commandName="food">
						<div style="color: #0000FF">${msg}</div>
		
						<table align="center" width=150px height=120px>
							<tr>
								<td colspan="2"><h1>
										<center><span class="label label-warning">Food Details</span></center>
									</h1></td>
							</tr>

							<tr>
					<td class="danger"><b><span class="label label-default">Food ID:</span></b></td>
					<td>${food.foodID}</td>
					<td><form:input path="foodID"  value="${food.foodID}" type="hidden" /></td>
					<td><font color="black"><form:errors path="foodID"
								cssclass="error" /></font></td>
				</tr>
			<tr>
				<td class="danger"><b><span class="label label-default">name:</span></b></td>
				<td class="danger"><b>${food.name}</b></td>
			</tr>
			<tr>
				<td class="danger"><b><span class="label label-default">street:</span></b></td>
				<td class="danger"><b>${food.type}</b></td>
			</tr>
			<tr>
				<td class="danger"><b><span class="label label-default">foodSize:</span></b></td>
				<td class="danger"><b>${food.foodSize}</b></td>
			</tr>
			<tr>
				<td class="danger"><b><span class="label label-default">quantity:</span></b></td>
				<td class="danger"><b>${food.quantity}</b></td>
			</tr>
			<tr>
				<td class="danger"><b><span class="label label-default">price:</span></b></td>
				<td class="danger"><b>${food.price}</b></td>
			</tr>
			
			
							<tr>
								<td colspan="2"><center>
										<input type="submit" value="Conform Delete food" class="btn btn-danger">
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
	</c:if>
</body>
</html>