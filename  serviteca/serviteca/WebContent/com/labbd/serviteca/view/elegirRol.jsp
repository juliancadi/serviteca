<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.labbd.serviteca.services.session.*" %> 
<html>
<%

UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("usuarioactual");

%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Serviteca JC | Login</title>
	<link href="styles/estilosserviteca.css" rel="stylesheet" type="text/css" />
<title>Elegir Rol</title>
</head>
<body> 
	<div id="cabezote"></div>
	<div id="inicioSesion">
	    <form name="elegirRol" id="elegirRol" method="post" action="../../../../ElegirRolCTRL">
	    	<%if(usuario!=null){ %>
	    	<div id="roles"><br>
	    	<%
	    	String checked = "checked=\"checked\"";
	    	for(int i=0; i<usuario.getTbRols().size();i++){ %>
		<input type="radio" name="roles" value="<%=usuario.getTbRols().get(i).getCodigo()%>" <%=checked %>><%=usuario.getTbRols().get(i).getNombre()%><br>
		<%
		checked="";
	    	} %>
		<br>
		<input class="inputButton" type="submit" name="ingresar" id="ingresar" value="Ingresar" />
		</div>
		<%}else{ %>
			<center><div id="respuesta">Debe ingresar con el nombre de usuario y contraseña</div>
			<br>
			<a href="../../../../index.jsp">Ingresar</a></center>
		<%} %>
	    </form>
	</div>
	<div id="piedepagina">
	 	<p id="textopiedepagina"><strong>Acerca de SERVITEKA JC.</strong> © 2011 Derechos Reservados. <br>
	     Laboratorio de Bases de Datos, Ingenier&iacute;a de Sistemas, Universidad de Antioquia
	     </p>
	 </div>  
	</body>
</html>