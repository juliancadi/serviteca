<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Serviteca JC</title>
<link href="../../styles/estilosServiteca.css" rel="stylesheet" type="text/css" />
</head>
<body> 
    <div id="cabezote"></div>
    <div id="inicioSesion">
        <form id="login" action="SERVLET">
          <p>
            <label class="leftText">E-Mail</label>
            <input class="inputText" type="text" id="email" name="email" />   
            <br />
            <br />                   
            <label class="leftText">Password</label>             
            <input class="inputText" type="password" id="password" name="password" />
          </p>
          <br />
          <p>
            <input class="inputButton" type="submit" name="Login" id="Login" value="login" />
          </p>
        </form>
    </div>
  <div id="piedepagina">   	   	
    	<p id="textopiedepagina"><strong>Acerca de SERVITEKA JC.</strong> © 2011 Derechos Reservados. <br>
        Laboratorio de Bases de Datos  
        </p>
    </div>  
</body>
</html>