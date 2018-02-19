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
<body>
<div class="tnav"   >
<div class="navbar navbar-fixed-top" role="banner" style="background-color:#FF7519; height:30px;">
    <div class="navbar-inner-sm">
  <div class="container">
  
    
    
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    
    <nav class="collapse navbar-collapse" role="navigation">
      <ul class="nav navbar-nav pull-right">
      
                <li>
          <a href="Password.htm"  style=" color:black;">change password</a>
        </li>
        <li class="active">
          <a href="Logout.htm" style=" color:black;">sign out</a>
        </li>
        </ul>
        <ul class="nav navbar-nav pull-left">
	<li><img src="images/t1.png" height="60px" width="80px" /></li>
	<li align="center"><h3><span class="label label-danger">Welcome ${nameheader}</span></h3>
	</ul>
    </nav>
  </div>
    </div>
</div>
</body>
<!-- <body>
<a href="Logout.htm">Logout</a>
<a href="Password.htm">Change Password</a>


</body> -->
</html>