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
					<form:form method="POST" action="ViewFood.htm" commandName="food">
						<div style="color: #0000FF">${msg}</div>
		
						<table align="center" width=150px height=120px>
							<tr>
								<td colspan="2"><h3>
										<center>Search For a Store</center>
									</h3></td>
							</tr>

							<tr>
								<td>Enter the foodID :</td>
								<td><form:input path="foodID" /></td>
								<td><font color="black"><form:errors path="foodID"
											cssclass="error" /></font></td>
							</tr>
												
							
							
							<tr>
								<td colspan="2"><center>
										<input type="submit" value="Find Food Item" class="btn btn-danger">
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