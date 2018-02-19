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
					<form:form method="POST" action="FoodAdd.htm" commandName="food" id="validate">
						<div style="color: #0000FF">${msg}</div>
		
						<table align="center" width=500px height=120px>
							<tr>
								<td colspan="2"><h3>
										<center><span class="label label-primary">Add Food Details</span></center>
									</h3></td>
							</tr>

							
							<tr>
								<td><span class="label label-danger">Enter the Foodname :</span></td>
								<td><form:input class="form-control" placeholder="name" path="name" /></td>
								<td><font color="black"><form:errors path="name"
											cssclass="error" /></font></td>
							</tr>
							
							
							
							<tr>
								<td><span class="label label-danger">Enter the Food type :</span></td>
								<td><form:input class="form-control" placeholder="name" path="type" /></td>
								<td><font color="black"><form:errors path="type"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-danger">Enter the foodSize :</span></td>
								<%-- <td><form:input class="form-control" placeholder="name" path="foodSize" /></td> --%>
								<td><select name="foodSize">
								<option>Food Size</option>
								<option value="Large">Large</option>
								<option value="Medium">Medium</option>
								<option value="Regular">Regular</option>
								</select>
								<td><font color="black"><form:errors path="foodSize"
											cssclass="error" /></font></td>
							</tr>
							
							<tr>
								<td><span class="label label-danger">Enter the quantity :</span></td>
								<td><form:input class="form-control" placeholder="name" path="quantity" /></td>
								
								<td><font color="black"><form:errors path="quantity"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-danger">Enter the price :</span></td>
								<td><form:input class="form-control" placeholder="name" path="price" /></td>
								<td><font color="black"><form:errors path="price"
											cssclass="error" /></font></td>
							</tr>
							
							
							
							<tr>
								<td colspan="3"><center>
										<input type="submit" value="Add food" class="btn btn-danger">
										</center>
									</td>
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
					name : "required",
					type : "required",
					foodSize : "required",
					quantity : {
						required:true,
						number: true
					},
					price : {
						required : true,
						 pattern: /^(\d+|\d+.\d{1,2})$/
					}
				}
			});
		</script>
				</div>
				<br />
</body>
</html>