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
<div style="background-image: url(images/home.jpg); height: 600px; width: 100px; border: 1px solid black; "/>
<div class="btn-group">
  <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false"style="margin-top:80px;width:100px;">
    Store Details <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li><a href="StoreAdd.htm">Add new Store Details</a></li>
    <li><a href="ViewStore.htm">View Store Details</a></li>
    <li><a href="ViewAllStore.htm">View All Store Details</a></li>
    <li><a href="DeleteStore.htm">Delete Store</a></li>
    <li><a href="ModifyStore.htm">Modify Store</a></li>
  </ul>
</div>
<div>
<br>
</div>
<div class="btn-group">
  <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="width:100px;">
    Food Details <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li><a href="FoodAdd.htm">Add New Food Item</a></li>
    <li><a href="ViewFood.htm">View Food Details</a></li>
    <li><a href="ViewAllFood.htm">view All Food Details</a></li>
    <li><a href="ModifyFood.htm">Modify Food</a></li>
    <li><a href="DeleteFood.htm">Delete Food</a></li>
  </ul>
</div>
</body>
</html>