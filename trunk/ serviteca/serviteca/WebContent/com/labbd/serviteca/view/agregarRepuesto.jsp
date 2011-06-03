<%@page import="java.util.List"%>
<%@ page import="com.labbd.serviteca.services.session.*" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.labbd.serviteca.business.reparacion.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%
	UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("usuarioactual");
	ReparacionDTO reparacion = (ReparacionDTO)session.getAttribute("reparacion");
	Object resultsql = session.getAttribute("resultsql");
	Object respuesta = session.getAttribute("respuestaSolicitud");
	session.setAttribute("resultsql",null);
	session.setAttribute("respuestaSolicitud",null);
	if(usuario==null){
	%>
	<meta http-equiv="Refresh" content="0;url=../../../../index.jsp" />
	<%
	}else{
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%} %>
	<title>Serviteca JC | Agregar Repuesto</title>
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
			<form name="agregarRepuesto" id="agregarRepuesto" method="post" action="../../../../AgregarRepuestoCTRL">
	          <p>
	            <label class="leftText">Reparaci&oacute;n: </label>&nbsp;<%=reparacion.getCodigo() %>
	            <input type="hidden" name="reparacion" id="reparacion" value="<%= reparacion.getCodigo() %>" />             
	            <br />
	            <br />
	            <label class="leftText">Autom&oacute;vil:</label>&nbsp;<%=reparacion.getTbAutomovil().getPlaca()+" - " +reparacion.getTbAutomovil().getMarca() %> 
	            <br />
	            <br />                   
	            <label class="leftText">Repuesto:</label>             
	            <select class="dropList" id="selRepuesto" name="selRepuesto">
	            	<option value="0">- -</option>
	            	<%
	            	RepuestoManager rm = RepuestoManager.getRepuestoManager();
	            	List <RepuestoDTO> repuestos = rm.getRepuestos();
	            	if(repuestos!=null && !repuestos.isEmpty())
	            	for(int i=0; i<repuestos.size();i++){ %>
	            		<option value="<%=repuestos.get(i).getCodigo()%>"><%= repuestos.get(i).getNombre() +" $"+repuestos.get(i).getCostoCompra() %></option>	
           			<%} %>            	
	            </select>
	            <br />
	            <br />                   
	                        
	            <label class="leftText">Cantidad:</label>             
	            <input class="itemFormNum" type="text" id="txtCantidad" name="txtCantidad" maxlength="10" />
	            <br />
	            <br />                   
	                        
	            <label class="leftText">Costo:</label>             
	            <input class="itemFormNum" type="text" id="txtCosto" name="txtCosto" maxlength="10" />
	          </p>
	          <br />
	          <p>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <input class="inputButton" type="submit" name="agregar" id="agregar" value="Agregar" />
	          </p> 
	          <%if(resultsql!=null){ %>
	          	<%= resultsql %>
	          <%} %>  
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
	</div>
	<div id="piedepagina">
	 	<p id="textopiedepagina"><strong>Acerca de SERVITECA JC.</strong> © 2011 Derechos Reservados. <br>
	     Laboratorio de Bases de Datos, Ingenier&iacute;a de Sistemas, Universidad de Antioquia
	     </p>
	</div>  
</body>
</html>