<%@page import="java.util.List"%>
<%@ page import="com.labbd.serviteca.business.reparacion.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.labbd.serviteca.services.session.*" %> 
<html>
<%

UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("usuarioactual");

%>
<head>
	<%

		if(usuario==null){
	%>
	<meta http-equiv="Refresh" content="0;url=../../../../index.jsp" />
	<%
	}else{
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%} %>
	<title>Serviteca JC | Login</title>
	<link href="styles/estilosserviteca.css" rel="stylesheet" type="text/css" />
<title>Elegir Reparaci&oacute;n</title>
</head>
<body> 
	<div id="cabezote"></div>
	<div id="elegirRep">
	    <form name="elegirReparacion" id="elegirReparacion" method="post" action="../../../../ElegirReparacionCTRL">
	    	<div id="reparaciones">
	    		<select class="itemForm" id="selAuto" name="selAuto">
	            	<option value="0">- -</option>
	            	<%
	            	ReparacionManager rm = ReparacionManager.getReparacionManager();
	            	List<ReparacionDTO> reparaciones = rm.getReparaciones();
	            	if(reparaciones!=null && !reparaciones.isEmpty())
	            	for(int i=0; i<reparaciones.size();i++){ %>
	            		<option value="<%=reparaciones.get(i).getCodigo()%>"><%= reparaciones.get(i).getCodigo()+" - "+reparaciones.get(i).getTbAutomovil().getMarca()+" - "+reparaciones.get(i).getTbAutomovil().getPlaca()%></option>	
           			<%} %>            	
	            </select>
				<br />
				<br />
				<input class="inputButton" type="submit" name="modificar" id="modificar" value="Modificar" />
			</div>
	    </form>
	</div>
	<div id="piedepagina">
	 	<p id="textopiedepagina"><strong>Acerca de SERVITEKA JC.</strong> © 2011 Derechos Reservados. <br>
	     Laboratorio de Bases de Datos, Ingenier&iacute;a de Sistemas, Universidad de Antioquia
	     </p>
	 </div>  
	</body>
</html>