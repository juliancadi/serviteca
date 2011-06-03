<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.labbd.serviteca.services.session.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

Object respuesta = session.getAttribute("respuestaSolicitud");
session.setAttribute("respuestaSolicitud",null);
String logout = request.getParameter("logout");
if(logout!=null){
	//session.invalidate();
	session.setAttribute("usuarioactual",null);
}

%>
<html>
	<head>
			<%
			UsuarioDTO usuario  = (UsuarioDTO)session.getAttribute("usuarioactual");


		String redireccionar = "<meta http-equiv=\"Refresh\" content=\"2;url=com/labbd/serviteca/view/elegirRol.jsp\" />"+
							   "<title>Serviteca JC | Login</title>"+
								"</head>"+
								"<body>"+
								"<p><a href=\"com/labbd/serviteca/view/elegirRol.jsp\">Redireccionando a Serviteca JS...</a></p>"+
								"</body>"+
								"</html>";
		if(usuario!=null){
		%>
		<%=redireccionar %>		
		<%
		}else{
		%>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Serviteca JC | Login</title>
		<link href="com/labbd/serviteca/view/styles/estilosserviteca.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="com/labbd/serviteca/services/javascript/jquery.js"></script>
		<script type="text/javascript" src="com/labbd/serviteca/services/javascript/jquery.validate.js"></script>
		<script type="text/javascript" src="com/labbd/serviteca/services/javascript/validaciones.js"></script>
	</head>
	<body> 
	    <div id="cabezote"></div>
	    <div id="inicioSesion">
	        <form name="login" id="login" method="post" action="LoginCTRL">
	          <p>
	            <label class="leftText">Usuario:</label>
	            <input class="itemFormAlfaNum" type="text" id="txtUser" name="txtUser" maxlength="20" />   
	            <br />
	            <br />                   
	            <label class="leftText">Contraseña:</label>             
	            <input class="itemFormAlfaNum" type="password" id="txtPass" name="txtPass" maxlength="15" />
	          </p>
	          <br />
	          <p>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <input class="inputButton" type="submit" name="ingresar" id="ingresar" value="Ingresar" />
	          </p>
	          <%
	          if(respuesta!=null){
	        	  %>
	        	  <div id="respuesta">
	        	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        	  <%=respuesta %></div>
	        	  <%
	          }
	          %>
	        </form>
	    </div>
	  	<div id="piedepagina">
	    	<p id="textopiedepagina"><strong>Acerca de SERVITECA JC.</strong> © 2011 Derechos Reservados. <br>
	        Laboratorio de Bases de Datos, Ingenier&iacute;a de Sistemas, Universidad de Antioquia
	        </p>
	    </div>  
	</body>
</html>
<%
}
%>