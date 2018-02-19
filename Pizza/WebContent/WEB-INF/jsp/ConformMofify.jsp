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

	<div >
		<h1>${MSG}</h1>
		<form:form method="POST" action="ModifyStore.htm" commandName="store">
			<div style="color: #0000FF">${msg}</div>

			<table align="center" width=400px height=120px>
				<tr>
					<td colspan="2"><h3>
							<center>Search For a Store</center>
						</h3></td>
				</tr>
				<tr>
					<td class="danger"><b>Store ID:</b></td>
					<td>${store.storeID}</td>
					<td><form:input class="form-control" placeholder="name" path="storeID"  value="${store.storeID}" type="hidden" /></td>
					<td><font color="black"><form:errors path="name"
								cssclass="error" /></font></td>
				</tr>
				
				<tr>
					<td class="danger"><b>name:</b></td>
					<td><form:input class="form-control" placeholder="name" path="name" value="${store.name}" /></td>
					<td><font color="black"><form:errors path="name"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b>street:</b></td>
					<td><form:input class="form-control" placeholder="name" path="street" value="${store.street}" /></td>
					<td><font color="black"><form:errors path="street"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b>city:</b></td>
					<td><form:input class="form-control" placeholder="name" path="city" value="${store.city}" /></td>
					<td><font color="black"><form:errors path="city"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b>state:</b></td>
					<td><form:input class="form-control" placeholder="name" path="state" value="${store.state}" /></td>
					<td><font color="black"><form:errors path="state"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b>pincode:</b></td>
					<td><form:input class="form-control" placeholder="name" path="pincode" value="${store.pincode}" /></td>
					<td><font color="black"><form:errors path="pincode"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b>mobileNo:</b></td>
					<td><form:input class="form-control" placeholder="name" path="mobileNo" value="${store.mobileNo}" /></td>
					<td><font color="black"><form:errors path="mobileNo"
								cssclass="error" /></font></td>
				</tr>




				<tr>
					<td colspan="2"><center>
							<input type="submit" value="Conform Modify Store Details"
								class="btn btn-danger">
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