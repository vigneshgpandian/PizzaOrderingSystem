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
<body background="images/home.jpg">


<div style="border: 1px solid; ">


					<form:form method="POST" action="login.htm" commandName="credentials">
						<div style="color: #0000FF"></div>
						
		
						<table align="center" width=400px height=150px >
							<tr>
							<td><h3><span class="label label-primary">${MSG }</span></h3></td>
							</tr>
							<tr>
								<td colspan="2"><h3>
										
									</h3></td>
							</tr>
							<tr>
								
								<td colspan="2"><form:input class="form-control" placeholder="UserName" path="userID" /></td>
								<td><font color="black"><form:errors path="userID"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								
								<td colspan="2"><form:password class="form-control" id="formGroupInputLarge" placeholder="Password" path="password" /></td>
								<td><font color="black"><form:errors path="password"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td><center>
										<input type="submit" value="Login" class="btn btn-danger btn-lg btn-block">
										<a href="Registration.htm"><input type="button" class="btn btn-warning btn-lg btn-block" value="SignUp"  ></a>
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
</body>
</html>