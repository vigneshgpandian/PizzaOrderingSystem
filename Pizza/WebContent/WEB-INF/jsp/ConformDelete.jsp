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
<body>

<div style="border: 1px solid; background-color: #B7B3B3;">
<h1>${MSG}</h1>
					<form:form method="POST" action="DeleteStore.htm" commandName="store">
						<div style="color: #0000FF">${msg}</div>
		
						<table align="center" width=150px height=120px>
							<tr>
								<td colspan="2"><h3>
										<center>Search For a Store</center>
									</h3></td>
							</tr>

							<tr>
					<td class="danger"><b>Store ID:</b></td>
					<td>${store.storeID}</td>
					<td><form:input path="storeID"  value="${store.storeID}" type="hidden" /></td>
					<td><font color="black"><form:errors path="name"
								cssclass="error" /></font></td>
				</tr>
			<tr>
				<td class="danger"><b>name:</b></td>
				<td class="danger"><b>${store.name}</b></td>
			</tr>
			<tr>
				<td class="danger"><b>street:</b></td>
				<td class="danger"><b>${store.street}</b></td>
			</tr>
			<tr>
				<td class="danger"><b>city:</b></td>
				<td class="danger"><b>${store.city}</b></td>
			</tr>
			<tr>
				<td class="danger"><b>state:</b></td>
				<td class="danger"><b>${store.state}</b></td>
			</tr>
			<tr>
				<td class="danger"><b>pincode:</b></td>
				<td class="danger"><b>${store.pincode}</b></td>
			</tr>
			<tr>
				<td class="danger"><b>mobileNo:</b></td>
				<td class="danger"><b>${store.mobileNo}</b></td>
			</tr>
			
							<tr>
								<td colspan="2"><center>
										<input type="submit" value="Conform Delete Store" class="btn btn-danger">
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