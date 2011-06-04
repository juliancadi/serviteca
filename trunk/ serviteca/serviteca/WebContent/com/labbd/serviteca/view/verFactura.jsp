<%@page import="com.labbd.serviteca.business.factura.FacturaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.labbd.serviteca.services.session.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%
	UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("usuarioactual");
	FacturaDTO facturaGenerada = (FacturaDTO)session.getAttribute("factura");
		if(usuario==null){
	%>
	<meta http-equiv="Refresh" content="0;url=../../../../index.jsp" />
	<%
	}else{
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%} %>
	<title>Serviteca JC | Factura</title>
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
			<div id="mostrarFactura">
				<table width="500" border="1">
				  <tr>
				    <td>C&oacute;digo</td>
				    <td>Reparaci&oacute;n</td>
				    <td>Valor neto</td>
				    <td>IVA</td>
				    <td>Valor total</td>
				  </tr>
				  <tr>
				    <td><%=facturaGenerada.getCodigo() %></td>
				    <td><%=facturaGenerada.getTbReparacion().getCodigo()+" - "+facturaGenerada.getTbReparacion().getTbAutomovil().getMarca()+" - "+facturaGenerada.getTbReparacion().getTbAutomovil().getPlaca() %></td>
				    <td><%=facturaGenerada.getValorNeto() %></td>
				    <td><%=facturaGenerada.getIva() %></td>
				    <td><%=facturaGenerada.getValorTotal() %></td>
				  </tr>
				</table>
			</div>
		</div>
	</div>
	<div id="piedepagina">
	 	<p id="textopiedepagina"><strong>Acerca de SERVITECA JC.</strong> © 2011 Derechos Reservados. <br>
	     Laboratorio de Bases de Datos, Ingenier&iacute;a de Sistemas, Universidad de Antioquia
	     </p>
	</div>
</body>
</html>