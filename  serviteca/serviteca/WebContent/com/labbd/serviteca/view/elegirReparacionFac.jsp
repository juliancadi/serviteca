<%@page import="com.labbd.serviteca.business.factura.FacturaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="com.labbd.serviteca.business.reparacion.*" %>
<%@ page import="com.labbd.serviteca.services.session.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%
	UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("usuarioactual");
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
</head>
<body>
	<div id="cabezote"></div>
	<div style="padding: 0.5%;"> </div>
	<div id="contenedorppal">
		<div id="menuv">
	        <ul>
	            <li><a href="elegirReparacionFac.jsp">Generar factura</a></li>
	            <li><a href="../../../../index.jsp?logout=1">Cerrar sesi&oacute;n</a></li>
	        </ul>
		</div>
		<div id="contenido">
		    <form name="elegirReparacionFac" id="elegirReparacionFac" method="post" action="../../../../ElegirReparacionFacCTRL">
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
					<br />
					<br />
					<input class="inputButton" type="submit" name="aceptar" id="aceptar" value="Aceptar" />
				</div>
		    </form>
		</div>
	</div>
	<div id="piedepagina">
	 	<p id="textopiedepagina"><strong>Acerca de SERVITECA JC.</strong> © 2011 Derechos Reservados. <br>
	     Laboratorio de Bases de Datos, Ingenier&iacute;a de Sistemas, Universidad de Antioquia
	     </p>
	</div>
</body>
</html>