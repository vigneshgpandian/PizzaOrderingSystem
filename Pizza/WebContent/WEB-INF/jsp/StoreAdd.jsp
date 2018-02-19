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
<h1><span class="label label-danger">${MSG}</span></h1>
					<form:form method="POST" action="StoreAdd.htm" commandName="store" id="validdation" >
						<div style="color: #0000FF">${msg}</div>
		
						<table align="center" width=400px height=120px>
							<tr>
								<td colspan="2"><h3>
										<center>Add Store Details</center>
									</h3></td>
							</tr>

							
							<tr>
								
								<td colspan="2"><form:input class="form-control" placeholder="name" path="name" /></td>
								<td><font color="black"><form:errors path="name"
											cssclass="error" /></font></td>
											
							</tr>
							
							
							
							
							<tr>
								
								<td colspan="2"><form:input class="form-control" placeholder="street" path="street" /></td>
								<td><font color="black"><form:errors path="street"
											cssclass="error" /></font></td>
							</tr>
							
							<tr>
								
								<td colspan="2"><form:input class="form-control" placeholder="city" path="city" /></td>
								<td><font color="black"><form:errors path="city"
											cssclass="error" /></font></td>
							</tr>
							
							
							
							<tr>
								
								<td colspan="2"><form:input class="form-control" placeholder="state" path="state" /></td>
								<td><font color="black"><form:errors path="state"
											cssclass="error" /></font></td>
							</tr>
							
							<tr>
								
								<td colspan="2"><form:input class="form-control" placeholder="pincode" path="pincode" /></td>
								<td><font color="black"><form:errors path="pincode"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								
								<td colspan="2"><form:input class="form-control" placeholder="mobileNo" path="mobileNo" /></td>
								<td><font color="black"><form:errors path="mobileNo"
											cssclass="error" /></font></td>
							</tr>
							
							
							<tr>
								<td colspan="2"><center>
										<input type="submit" value="Create Store" class="btn btn-danger">
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
			$("#validdation").validate({
				rules : {
					name : "required",
					street : "required",
					city : "required",
					state : "required",
					pincode : {
						required:true,
						number: true,
						minlength:6,
						maxlength:6
					},
					mobileNo : {
						required:true,
						number: true,
						minlength:10,
						maxlength:10
					}
				}
			});
		</script>
				</div>
				<br />
</body>
</html>