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
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  
</head>
<body background="images/pic-1.jpg">

<div style="border: 1px solid; ">
<h1>${MSG}</h1>
					<form:form method="POST" action="pleasewait.htm" commandName="order" id="orderform">
						<div style="color: #0000FF">${msg}</div>
		
						<table align="center" width=400px height=130px>
							<tr>
								<td colspan="2"><h3>
										<center>Enter the delivery Details</center>
									</h3></td>
							</tr>

							<tr>
								<td>Enter the street :</td>
								<td><form:input class="form-control" placeholder="street" path="street" id="street"/></td>
								<td><font color="black"><form:errors path="street"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Enter the city :</td>
								<td><form:input class="form-control" placeholder="city" path="city" id="city"/></td>
								<td><font color="black"><form:errors path="city"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Enter the state :</td>
								<td><form:input class="form-control" placeholder="state" path="state" id="state"/></td>
								<td><font color="black"><form:errors path="state"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Enter the pincode :</td>
								<td><form:input class="form-control" placeholder="pincode" path="pincode" id="pincode"/></td>
								<td><font color="black"><form:errors path="pincode"
											cssclass="error" /></font></td>
							</tr>
							
							<tr>
								<td>Enter the mobileNo :</td>
								<td><form:input class="form-control" placeholder="mobileNo" path="mobileNo" id="mobilenumber"/></td>
								<td><font color="black"><form:errors path="mobileNo"
											cssclass="error" /></font></td>
							</tr>
							
							<tr>
								<td colspan="2"><center>
										<input type="submit" value="MakePayment" class="btn btn-danger">
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
			$("#orderform").validate({
				rules : {
					
					pincode : {
						required:true,
						matches:"[0-9\-\(\)\s]+",
						minlength:6,
						maxlength:6
					},
					mobileNo : {required:true, matches:"([0-9]{10})|(\([0-9]{3}\)\s+[0-9]{3}\-[0-9]{4})",minlength:10, maxlength:10},
					street:"required",
					city:"required",
					state:"required"
					
				}
			});
		</script>
				</div>
				<br />
</body>
</html>