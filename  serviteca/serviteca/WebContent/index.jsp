<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Serviteca</title>

<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery.validate.js"></script>


<!-- <link type='text/css' href='style/stylesheet.css' rel='stylesheet' media='screen' />
<link type='text/css' href='style/basic.css' rel='stylesheet' media='screen' /> -->
<script src="registroCliente.js" type="text/javascript"></script>

</head>

<body>

<h1><img src="images/key.png" align="left">LOGIN</h1> 
<br />

<form id="login" action="SERVLET">
	<label>E-Mail</label><input type="text" id="email" name="email" style="float: left;"><br />  
	<label>Password</label><input type="password" id="password" name="password" style="float: left;"><br />  
	<label>&nbsp;</label><input value="Login" name="Login" id="submit" class="big" type="submit" />
</form>


</body>
</html>