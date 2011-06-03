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
		if(usuario==null){
	%>
	<meta http-equiv="Refresh" content="0;url=../../../../index.jsp" />
	<%
	}else{
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%} %>
	<title>Serviteca JC | Modificar Reparaci&oacute;n</title>
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
	            <li><a href="modificarReparacion.jsp">Modificar reparaci&oacute;n</a></li>
	            <li><a href="agregarRepuesto">Agregar repuesto a reparaci&oacute;n</a></li>
	            <li><a href="quitarRepuesto">Quitar repuesto de reparaci&oacute;n</a></li>
	            <li><a href="../../../../index.jsp?logout=1">Cerrar sesi&oacute;n</a></li>
	        </ul>
		</div>
		<div id="contenido">
			<form name="agregarReparacion" id="agregarReparacion" method="post" action="LoginCTRL">
	          <p>
	            <label class="leftText">Autom&oacute;vil:</label>
	            <select class="itemForm" id="selAuto" name="selAuto">
	            	<option value="0">- -</option>
	            	<%
	            	AutomovilManager am = AutomovilManager.getAutomovilManager();
	            	List<AutomovilDTO> automoviles = am.getAutomoviles();
	            	if(automoviles!=null && !automoviles.isEmpty())
	            	for(int i=0; i<automoviles.size();i++){ %>
	            		<option value="<%=automoviles.get(i).getCodigo()%>"><%= automoviles.get(i).getPlaca()+" - "+automoviles.get(i).getMarca()%></option>	
           			<%} %>            	
	            </select> 
	            <br />
	            <br />                   
	            <label class="leftText">Fecha ingreso:</label>             
	            <select class="itemForm" id="selFechaInDia" name="selFechaInDia">
	            	<option value="0">D&iacute;a</option>
	            	<%for(int i=1; i<=31;i++){ %>
	            		<option value="<%=i%>"><%= i %></option>	
           			<%} %>            	
	            </select>
	            <select class="itemForm" id="selFechaInMes" name="selFechaInMes">
	            	<option value="0">M&eacute;s</option>
	            	<%for(int i=1; i<=12;i++){ %>
	            		<option value="<%=i%>"><%= i %></option>	
           			<%} %>
	            </select>
	            <select class="itemForm" id="selFechaInAnio" name="selFechaInAnio">
	            	<option value="0">A&ntilde;o</option>
	            	<%for(int i=2011; i>=2000;i--){ %>
	            		<option value="<%=i%>"><%= i %></option>	
           			<%} %> 
	            </select>
	            <br />
	            <br />                   
	            <label class="leftText">Fecha salida:</label>             
	            <select class="itemForm" id="selFechaOutDia" name="selFechaOutDia">
	            	<option value="0">D&iacute;a</option>
	            	<%for(int i=1; i<=31;i++){ %>
	            		<option value="<%=i%>"><%= i %></option>	
           			<%} %>            	
	            </select>
	            <select class="itemForm" id="selFechaOutMes" name="selFechaOutMes">
	            	<option value="0">M&eacute;s</option>
	            	<%for(int i=1; i<=12;i++){ %>
	            		<option value="<%=i%>"><%= i %></option>	
           			<%} %>
	            </select>
	            <select class="itemForm" id="selFechaOutAnio" name="selFechaOutAnio">
	            	<option value="0">A&ntilde;o</option>
	            	<%for(int i=2011; i>=2000;i--){ %>
	            		<option value="<%=i%>"><%= i %></option>	
           			<%} %> 
	            </select>
	            <br />
	            <br />                   
	            <label class="leftText">Encargado:</label>             
	            <select class="itemForm" id="selEncargado" name="selEncargado">
	            	<option value="0">- -</option>
	            	<%
	            	MecanicoManager mm = MecanicoManager.getMecanicoManager();
	            	List <MecanicoDTO> mecanicos = mm.getMecanicos();
	            	if(mecanicos!=null && !mecanicos.isEmpty())
	            	for(int i=0; i<mecanicos.size();i++){ %>
	            		<option value="<%=mecanicos.get(i).getCedula()%>"><%= mecanicos.get(i).getNombre()+" "+mecanicos.get(i).getApellido() %></option>	
           			<%} %>            	
	            </select>
	            <br />
	            <br />                   
	            <label class="leftText">Estado:</label>             
	            <select class="itemForm" id="selEstado" name="selEstado">
	            	<option value="0">- -</option>
	            	<%
	            	EstadoManager em = EstadoManager.getEstadoManager();
	            	List<EstadoDTO> estados = em.getEstados();
	            	if(estados!=null && !estados.isEmpty())
	            	for(int i=0; i<estados.size();i++){ %>
	            		<option value="<%=estados.get(i).getCodigo()%>"><%= estados.get(i).getNombre()%></option>	
           			<%} %>            	
	            </select>
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
	            <input class="inputButton" type="submit" name="ingresar" id="ingresar" value="Ingresar" />
	          </p>   
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