<%@page import="java.util.List"%>
<%@ page import="com.labbd.serviteca.business.reparacion.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.labbd.serviteca.services.session.*" %> 
<html>
<%

UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("usuarioactual");
String dir = request.getParameter("dir");

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
	<title>Serviteca JC | Elegir Reparaci&oacute;n</title>
	<link href="styles/estilosserviteca.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../services/javascript/jquery.js"></script>
		<script type="text/javascript" src="../services/javascript/jquery.validate.js"></script>
		<script type="text/javascript" src="../services/javascript/validaciones.js"></script>

</head>
<body> 
	<div id="cabezote"></div>
	<div style="padding: 0.5%;"> </div>
	<div id="contenedorppal">
		<div id="menuv">
	        <ul>
	            <li><a href="agregarReparacion.jsp">Agregar reparaci&oacute;n</a></li>
	            <li><a href="elegirReparacion.jsp?dir=mod">Modificar reparaci&oacute;n</a></li>
	            <li><a href="elegirReparacion.jsp?dir=agr">Agregar repuesto a reparaci&oacute;n</a></li>
	            <li><a href="elegirReparacion.jsp?dir=qui">Quitar repuesto de reparaci&oacute;n</a></li>
	            <li><a href="../../../../index.jsp?logout=1">Cerrar sesi&oacute;n</a></li>
	        </ul>
		</div>
		<div id="contenido">
		    <form name="elegirReparacion" id="elegirReparacion" method="post" action="../../../../ElegirReparacionCTRL">
		    	<div id="reparaciones">
		    		<select class="dropList" id="selReparacion" name="selReparacion">
		            	<option value="0">- -</option>
		            	<%
		            	ReparacionManager rm = ReparacionManager.getReparacionManager();
		            	List<ReparacionDTO> reparaciones = rm.getReparaciones();
		            	if(reparaciones!=null && !reparaciones.isEmpty()){
		            	for(int i=0; i<reparaciones.size();i++){ %>
		            		<option value="<%=reparaciones.get(i).getCodigo()%>"><%= reparaciones.get(i).getCodigo()+" - "+reparaciones.get(i).getTbAutomovil().getMarca()+" - "+reparaciones.get(i).getTbAutomovil().getPlaca()%></option>
	           			<%}
		            	}
		            	%>            	
		            </select>
		            <input type="hidden" name="dir" id="dir" value="<%= dir %>" />	
					<br />
					<br />
					<input class="inputButton" type="submit" name="aceptar" id="aceptar" value="Aceptar" />
				</div>
		    </form>
		</div>
	</div>
	<div id="piedepagina">
	 	<p id="textopiedepagina"><strong>Acerca de SERVITECA JC.</strong> � 2011 Derechos Reservados. <br>
	     Laboratorio de Bases de Datos, Ingenier&iacute;a de Sistemas, Universidad de Antioquia
	     </p>
	 </div>  
	</body>
</html>