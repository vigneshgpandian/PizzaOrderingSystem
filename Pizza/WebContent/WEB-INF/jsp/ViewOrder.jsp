<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
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
<title>Pizza ordering system</title>
</head>
<body background="images/pic-1.jpg">
<h2>${MSG }</h2>


 <display:table class="table table-striped" name="list" pagesize="7" requestURI="ViewOrder.htm"
                         export="true" sort="list" id="storeID">
                         
                <display:column class="info"  property="storeID" title="storeID"
                                sortable="true" headerClass="sortable" />
                <display:column class="info" property="orderID" title="orderID"
                                sortable="true" headerClass="sortable" />
                <display:column class="info"  property="cartID" title="cartID"
                                sortable="true" headerClass="sortable" />
                <display:column class="info" property="orderStatus" title="orderStatus"
                                sortable="true" headerClass="sortable" />
                 
                                 <display:setProperty name="export.pdf" value="true" />
                          <display:setProperty name="export.pdf.filename" value="ActorDetails.pdf"/>
                         
                                                            
            </display:table> 


<a href="CancelOrder.htm"><center><input type="button" value="Cancel order" class="btn btn-danger "></center></a>

</body>
</html>