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
 <link rel="stylesheet" href="css/bootstrap-responsive.css">
<!-- <link rel="stylesheet" href="css/datepicker.css"> -->
<script src="js/bootstrap-datepicker.js"></script>
</head>
<body background="images/pic-1.jpg">

</script>
<div style="border: 1px solid; ">
<h1>${MSG}</h1>
					<form:form method="POST" action="Registration.htm" commandName="profile" id="validate">
						<div style="color: #0000FF">${msg}</div>
		
						<table align="center" width=400px height=120px>
							<tr>
								<td colspan="2"><h3>
										<center>Registration</center>
									</h3></td>
							</tr>

							<tr>
								<td><span class="label label-primary">Enter the First Name :</span></td>
								<td><form:input class="form-control" placeholder="name" path="firstName" /></td>
								<td><font color="black"><form:errors path="firstName"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the Last Name :</span></td>
								<td><form:input class="form-control" placeholder="name" path="lastName" /></td>
								<td><font color="black"><form:errors path="lastName"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Gender Type :</span></td>
								<td><form:radiobutton path="gender" value="Male" />male</td>
								<td><form:radiobutton path="gender" value="Female" />female</td>
								<td><font color="black"><form:errors path="gender"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the Date of Birth :</span></td>
								<%-- <td><form:input class="form-control" placeholder="name" path="dateOfBirth" id="datepicker" /></td>
								<td><font color="black"><form:errors path="dateOfBirth"
											cssclass="error" /></font></td> --%>
											<td><form:input path="dateOfBirth" data-provide="datepicker"></form:input>
											<td><font color="black"><form:errors path="dateOfBirth"
											cssclass="error" /></font></td>
							</tr>
							
							<tr>
								<td><span class="label label-primary">Enter the Street :</span></td>
								<td><form:input class="form-control" placeholder="name" path="street" /></td>
								<td><font color="black"><form:errors path="street"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the city :</span></td>
								<td><form:input class="form-control" placeholder="name" path="city" /></td>
								<td><font color="black"><form:errors path="city"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the state :</span></td>
								<td><form:input class="form-control" placeholder="name" path="state" /></td>
								<td><font color="black"><form:errors path="state"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the pincode :</span></td>
								<td><form:input class="form-control" placeholder="name" path="pincode" /></td>
								<td><font color="black"><form:errors path="pincode"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the location :</span></td>
								<td><form:input class="form-control" placeholder="name" path="location" /></td>
								<td><font color="black"><form:errors path="location"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the mobileNo :</span></td>
								<td><form:input class="form-control" placeholder="name" path="mobileNo" /></td>
								<td><font color="black"><form:errors path="mobileNo"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the emailID :</span></td>
								<td><form:input class="form-control" placeholder="name" path="emailID" /></td>
								<td><font color="black"><form:errors path="emailID"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the Password :</span></td>
								<td><form:password class="form-control" placeholder="name" path="Password" /></td>
								<td><font color="black"><form:errors path="Password"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><span class="label label-primary">Enter the ConformPassword :</span></td>
								<td><form:password class="form-control" placeholder="name" path="ConformPassword" /></td>
								<td><font color="black"><form:errors 
											cssclass="error" /></font></td>
							</tr>
							
							
							<tr>
								<td colspan="2"><center>
										<input type="submit" value="Create Profile" class="btn btn-danger">
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
					},
					
					Password : {
						required:true,
						minlength:6	
					},
					ConformPassword : {
						required : true,
						equalTo : "#Password"
					},
					emailID :{
						required : true,
						email:true
					},
					firstName :{
						required : true,
						minlength:2,
					},
					
					lastName:"required",
					gender:"required",
					dateOfBirth:"required",
					street:"required",
					city:"required",
					state:"required",
					location:"required"
					
				}
			});
		</script>
				</div>
				<br />
</body>
</html>