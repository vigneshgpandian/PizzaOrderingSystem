<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="2; URL=<%=request.getContextPath()%>/login.htm">
<title>Pizza ordering system</title>
</head>
<BODY background="images/front1.jpg">
<h1>
<script language="JavaScript1.2">
var message="Welcome to pizza ordering system"
var neonbasecolor="gray"
var neontextcolor="yellow"
var flashspeed=100  //in milliseconds
var n=0
if (document.all||document.getElementById){
document.write('<font color="'+neonbasecolor+'">')
for (m=0;m<message.length;m++)
document.write('<span id="neonlight'+m+'">'+message.charAt(m)+'</span>')
document.write('</font>')
}
else
document.write(message)
function crossref(number){
var crossobj=document.all? eval("document.all.neonlight"+number) : document.getElementById("neonlight"+number)
return crossobj
}
function neon(){
if (n==0){
for (m=0;m<message.length;m++)
//eval("document.all.neonlight"+m).style.color=neonbasecolor
crossref(m).style.color=neonbasecolor
}
  //cycle through and change individual letters to neon color
 crossref(n).style.color=neontextcolor
   if (n<message.length-1)
 n++
 else{
 n=0
 clearInterval(flashing)
 setTimeout("beginneon()",1500)
 return
 }
 }
  function beginneon(){
 if (document.all||document.getElementById)
 flashing=setInterval("neon()",flashspeed)
 }
 beginneon()
 		</script>
</body>
</html>