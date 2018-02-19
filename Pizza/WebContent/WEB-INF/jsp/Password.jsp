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
		<h1><span class="label label-primary">${MSG}</span></h1>
		<form:form method="POST" action="changePassword.htm" commandName="profile" id="validate">
			<div style="color: #0000FF">${msg}</div>

			<table align="center" width=150px height=120px>
				<tr>
					<td colspan="2"><h1>
							<center><span class="label label-warning">Change Password</span></center>
						</h1></td>
				</tr>
				<tr>
								<td>Enter the old password :</td>
								<td><form:password class="form-control" placeholder="old password" path="password" /></td>
								<td><font color="black"><form:errors path="password"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Enter the new password :</td>
								<td><form:password class="form-control" placeholder="newpassword" path="newpassword" /></td>
								<td><font color="black"><form:errors path="newpassword"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Enter the conform password :</td>
								<td><form:password class="form-control" placeholder="ConformPassword" path="ConformPassword" /></td>
								<td><font color="black"><form:errors path="ConformPassword"
											cssclass="error" /></font></td>
							</tr>

				<<!-- td><h5><span class="label label-danger">Enter the old password:</span></h5></td>
<td><input class="form-control" placeholder="old password" type="password" name="Password"/></td>
</tr>
<tr>
<td><h5><span class="label label-danger">Enter the new password:</span></h5></td>
<td><input class="form-control" placeholder="new password" type="password" name="newpassword"/></td>
</tr>
<tr>
<td><h5><span class="label label-danger">Retype the new password:</span></h5></td>
<td><input class="form-control" placeholder="Retype password" type="password" name="ConformPassword"/></td>
</tr> -->
				<tr>
					<td colspan="2"><center>
							<input type="submit" value="Change Password" class="btn btn-danger">
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
					password : "required",
					newpassword : {
						required:true,
						minlength:6	
					},
					ConformPassword : {
						required : true,
						equalTo : "#newpassword"
					}
				}
			});
		</script>
	</div>
	<br />
	
</body>
</html>