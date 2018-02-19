<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form action="changePassword.htm" method="post">
<table align="center">
<tr>
<td><h5><span class="label label-danger">Enter the old password:</span></h5></td>
<td><input class="form-control" placeholder="old password" type="password" name="Password"/></td>
</tr>
<tr>
<td><h5><span class="label label-danger">Enter the new password:</span></h5></td>
<td><input class="form-control" placeholder="new password" type="password" name="newpassword"/></td>
</tr>
<tr>
<td><h5><span class="label label-danger">Retype the new password:</span></h5></td>
<td><input class="form-control" placeholder="Retype password" type="password" name="ConformPassword"/></td>
</tr>
<tr>
<td colspan="3"><center><input type="submit" name="submit" class="btn btn-danger" value="Change Password"/></center></td>
</tr> 
</table>
</form>

</body>
</html>