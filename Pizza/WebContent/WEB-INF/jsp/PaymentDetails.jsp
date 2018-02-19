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
  <script src="jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="stylesheet" href="css/datepicker.css">
<script src="js/bootstrap-datepicker.js"></script>
  
</head>
<body background="images/pic-1.jpg">

<div style="border: 1px solid; ">
<h1>${MSG}</h1>
					<form:form method="POST" action="Pay.htm" commandName="card" id="validate">
						<div style="color: #0000FF">${msg}</div>
		
						<table align="center" width=400px height=120px>
							<tr>
								<td colspan="2"><h3>
										<center>Enter the Cart Details</center>
									</h3></td>
							</tr>

							<tr>
								<td>Enter the Card Number :</td>
								<td><form:input class="form-control" placeholder="creditcardNo" path="creditcardNo" id="creditcardNo"/></td>
								<td><font color="black"><form:errors path="creditcardNo"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Enter the Valid from :</td>
								<%-- <td><form:input class="form-control" placeholder="validFrom" path="validFrom" id="datepicker" /></td>
								<td><font color="black"><form:errors path="validFrom"
											cssclass="error" /></font></td> --%>
											
											<td><form:input path="validFrom" data-provide="datepicker" id="validFrom"></form:input>
											<td><font color="black"><form:errors path="validFrom"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Enter the Valid To :</td>
								<%-- <td><form:input class="form-control" placeholder="Valid To" path="validTo" id="datepicker" /></td>
								<td><font color="black"><form:errors path="validTo"
											cssclass="error" /></font></td> --%>
											<td><form:input path="validTo" data-provide="datepicker" id="validTo"></form:input>
											<td><font color="black"><form:errors path="validTo"
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
			$("#validate").validate({
				rules : {
					
					creditcardNo : {
						required:true,
						minlength:16,
						maxlength:16
					},
					validFrom:"required",
					validTo:"required"
					
				}
			});
		</script>
				</div>
				<br />
</body>
</html>