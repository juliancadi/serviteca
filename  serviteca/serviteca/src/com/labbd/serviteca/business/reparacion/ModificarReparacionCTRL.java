package com.labbd.serviteca.business.reparacion;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labbd.serviteca.services.session.UsuarioDTO;

/**
 * Servlet implementation class ModificarReparacionCTRL
 */
@WebServlet("/ModificarReparacionCTRL")
public class ModificarReparacionCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MODREPARACION_PATH = "com/labbd/serviteca/view/modificarReparacion.jsp";
	private static final String NO_USER = "Debe ingresar con el nombre de usuario y contraseña";
	private static final String INDEX = "index.jsp";
	private DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarReparacionCTRL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("usuarioactual");
		if(usuario!=null){
			try{
				String codigoReparacion = request.getParameter("reparacion");
				String codigoAutomovil = request.getParameter("selAuto");
				String diaIn = request.getParameter("selFechaInDia");
				String mesIn = request.getParameter("selFechaInMes");
				String anioIn = request.getParameter("selFechaInAnio");			
				Date fechaIngreso = fechaFormat.parse(diaIn+"/"+mesIn+"/"+anioIn);
				String diaOut = request.getParameter("selFechaOutDia");
				String mesOut = request.getParameter("selFechaOutMes");
				String anioOut = request.getParameter("selFechaOutAnio");
				Date fechaSalida = fechaFormat.parse(diaOut+"/"+mesOut+"/"+anioOut);
				String cedulaMecanico = request.getParameter("selEncargado");
				String codigoEstado = request.getParameter("selEstado");
				int costo = Integer.parseInt(request.getParameter("txtCosto"));
				AutomovilDTO automovil = new AutomovilDTO();
				MecanicoDTO mecanico = new MecanicoDTO();
				EstadoDTO estado = new EstadoDTO();
				ReparacionDTO modReparacion = new ReparacionDTO();
				automovil.setCodigo(codigoAutomovil);
				mecanico.setCedula(cedulaMecanico);
				estado.setCodigo(codigoEstado);
				modReparacion.setCodigo(codigoReparacion);
				modReparacion.setTbAutomovil(automovil);
				modReparacion.setFechaIngreso(fechaIngreso);
				modReparacion.setFechaSalida(fechaSalida);
				modReparacion.setTbMecanico(mecanico);
				modReparacion.setTbEstado(estado);
				modReparacion.setCosto(new BigDecimal(costo));
				
				aprobar(request, response, modReparacion, MODREPARACION_PATH);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			rechazar(request, response,NO_USER, INDEX);
		}
	}
	
	private void aprobar(HttpServletRequest req, HttpServletResponse resp, ReparacionDTO repa, String dir) throws ServletException, IOException{
		ReparacionManager rm = ReparacionManager.getReparacionManager();
		String insercion = rm.modificarReparacion(repa);
		if(insercion.equals("success")){
			req.getSession().setAttribute("resultsql", "La reparacion se modifico correctamente");
			req.getSession().setAttribute("reparacion", repa);
			resp.sendRedirect(dir);
		}
		else{
			rechazar(req, resp,insercion,dir);
		}
		
	}
	
	private void rechazar(HttpServletRequest req, HttpServletResponse resp, Object respuesta, String path) throws ServletException, IOException{
		req.getSession().setAttribute("respuestaSolicitud", respuesta);
		resp.sendRedirect(path);
	}

}
