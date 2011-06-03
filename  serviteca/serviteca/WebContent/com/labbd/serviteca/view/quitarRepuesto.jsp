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
	session.setAttribute("resultsql",null);
	if(usuario==null){
	%>
	<meta http-equiv="Refresh" content="0;url=../../../../index.jsp" />
	<%
	}else{
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%} %>
	<title>Serviteca JC | Quitar Repuesto</title>
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
			<form name="quitarRepuesto" id="quitarRepuesto" method="post" action="../../../../QuitarRepuestoCTRL">
	          <p>
	            <label class="leftText">Reparaci&oacute;n: </label>&nbsp;<%=reparacion.getCodigo() %>
	            <input type="hidden" name="reparacion" id="reparacion" value="<%= reparacion.getCodigo() %>" />             
	            <br />
	            <br />
	            <label class="leftText">Autom&oacute;vil:</label>&nbsp;<%=reparacion.getTbAutomovil().getPlaca()+" - " +reparacion.getTbAutomovil().getMarca() %> 
	            <br />
	            <br />
	            <hr />
	            <br />
	            <br />                   
	            <%
	            RepuestoManager rm = RepuestoManager.getRepuestoManager();
	            RepuestoPorRepaManager rprm = RepuestoPorRepaManager.getRepuestoPorRepaManager();
	            List <RepuestoDTO> repuestos = rm.getRepuestosPorReparacion(reparacion);
	            if(repuestos!=null && !repuestos.isEmpty()){
	            	%>
	            <label class="leftText">Repuesto:</label>             
	            <select class="dropList" id="selRepuesto" name="selRepuesto">
	            	<option value="0">- -</option>
	            	<%
	            	for(int i=0; i<repuestos.size();i++){
	            		RepuestoPorRepaDTO repPorRepa = new RepuestoPorRepaDTO();
	            		repPorRepa.setTbReparacion(reparacion);
	            		repPorRepa.setTbRepuesto(repuestos.get(i));
	            		repPorRepa =rprm.getRepuestoPorRepa(repPorRepa);
	            		%>
	            		<option value="<%=repuestos.get(i).getCodigo()%>"><%=repPorRepa.getCantidad()+" x " +repuestos.get(i).getNombre() +" $"+repuestos.get(i).getCostoCompra() %></option>	
           			<%} %>            	
	            </select>
	            <br />
	          <p>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <input class="inputButton" type="submit" name="quitar" id="quitar" value="Quitar" />
	          </p> 
				<%}else{ %>
				<div class="error">Esta reparaci&oacute;n no tiene ningun repuesto para eliminar</div>
				<%} %>
	          </p>
	          <%if(resultsql!=null){ %>
	          	<%= resultsql %>
	          <%} %>    
	        </form>
		</div>
	</div>
	<div id="piedepagina">
	 	<p id="textopiedepagina"><strong>Acerca de SERVITEKA JC.</strong> © 2011 Derechos Reservados. <br>
	     Laboratorio de Bases de Datos, Ingenier&iacute;a de Sistemas, Universidad de Antioquia
	     </p>
	</div>  
</body>
</html>