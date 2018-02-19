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
		<form:form method="POST" action="ConformMofify.htm" commandName="store">
			<div style="color: #0000FF">${msg}</div>

			<table align="center" width=150px height=120px>
				<tr>
					<td colspan="2"><h1>
							<center><span class="label label-warning">Search For a Store</span></center>
						</h1></td>
				</tr>

				<tr>
					<td><span class="label label-default">Select Store ID</span></td>
					<td><select name="storeID">
							<option>storeID</option>
							<c:forEach var="list" items="${list}">
								<option value="${list.storeID}">${list.storeID}</option>
							</c:forEach>
					</select>
					
				</tr>
				<tr>
					<td colspan="2"><center>
							<input type="submit" value="Find Store" class="btn btn-danger">
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
		
		<form:form method="POST" action="ModifyStore1.htm" commandName="store" id="validate">
			<div style="color: #0000FF">${msg}</div>

			<table align="center" width=400px height=180px>
				<tr>
					<td colspan="2"><h1>
							<center><span class="label label-warning">Store Details</span></center>
						</h1></td>
				</tr>
				<tr>
					<td class="danger"><b><span class="label label-default">storeID</span></b></td>
					<td><span class="label label-default">${store.storeID}</span></td>
					<td><form:input class="form-control" placeholder="name" path="storeID"  value="${store.storeID}" type="hidden" /></td>
					<td><font color="black"><form:errors path="name"
								cssclass="error" /></font></td>
				</tr>
				
				<tr>
					<td class="danger"><b><span class="label label-default">name:</span></b></td>
					<td><form:input class="form-control" placeholder="name" path="name" value="${store.name}" /></td>
					<td><font color="black"><form:errors path="name"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b><span class="label label-default">street:</span></b></td>
					<td><form:input class="form-control" placeholder="name" path="street" value="${store.street}" /></td>
					<td><font color="black"><form:errors path="street"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b><span class="label label-default">city:</span></b></td>
					<td><form:input class="form-control" placeholder="name" path="city" value="${store.city}" /></td>
					<td><font color="black"><form:errors path="city"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b><span class="label label-default">state:</span></b></td>
					<td><form:input class="form-control" placeholder="name" path="state" value="${store.state}" /></td>
					<td><font color="black"><form:errors path="state"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b><span class="label label-default">pincode:</span></b></td>
					<td><form:input class="form-control" placeholder="name" path="pincode" value="${store.pincode}" /></td>
					<td><font color="black"><form:errors path="pincode"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td class="danger"><b><span class="label label-default">mobileNo:</span></b></td>
					<td><form:input class="form-control" placeholder="name" path="mobileNo" value="${store.mobileNo}" /></td>
					<td><font color="black"><form:errors path="mobileNo"
								cssclass="error" /></font></td>
				</tr>




				<tr>
					<td colspan="2"><center>
							<input type="submit" value="Conform Modify Store Details"
								class="btn btn-danger" >
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
    </c:if>
</body>
</html>