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

 <display:table class="table table-striped" name="list" pagesize="5" requestURI="ViewAllFood.htm"
                           export="true" sort="list" id="foodID">
                <display:column class="info"  property="foodID" title="foodID"
                                sortable="true" headerClass="sortable" />
                <display:column class="info" property="name" title="name"
                                sortable="true" headerClass="sortable" />
                <display:column class="info"  property="type" title="type"
                                sortable="true" headerClass="sortable" />
                <display:column class="info" property="foodSize" title="foodSize"
                                sortable="true" headerClass="sortable" />
                <display:column class="info" property="quantity" title="quantity"
                                sortable="true" headerClass="sortable" />                
                <display:column class="info" property="price" title="price"
                                sortable="true" headerClass="sortable" />
                <display:column class="info" property="price" title="price"
                                sortable="true" headerClass="sortable" />  
                                <display:setProperty name="export.pdf" value="true" />
                          <display:setProperty name="export.pdf.filename" value="ActorDetails.pdf"/>
                          <display:setProperty name="export.excel.filename" value="ActorDetails.xls"/>
                                                                                  
            </display:table> 




</body>
</html>