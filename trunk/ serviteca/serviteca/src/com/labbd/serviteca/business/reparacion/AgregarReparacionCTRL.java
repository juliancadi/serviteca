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
 * Servlet implementation class AgregarReparacionCTRL
 */
@WebServlet("/AgregarReparacionCTRL")
public class AgregarReparacionCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AGRREPA_PATH = "com/labbd/serviteca/view/agregarReparacion.jsp";
	private DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarReparacionCTRL() {
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
				ReparacionDTO nuevaReparacion = new ReparacionDTO();
				automovil.setCodigo(codigoAutomovil);
				mecanico.setCedula(cedulaMecanico);
				estado.setCodigo(codigoEstado);
				nuevaReparacion.setCodigo("1");
				nuevaReparacion.setTbAutomovil(automovil);
				nuevaReparacion.setFechaIngreso(fechaIngreso);
				nuevaReparacion.setFechaSalida(fechaSalida);
				nuevaReparacion.setTbMecanico(mecanico);
				nuevaReparacion.setTbEstado(estado);
				nuevaReparacion.setCosto(new BigDecimal(costo));
				
				aprobar(request, response, nuevaReparacion, AGRREPA_PATH);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void aprobar(HttpServletRequest req, HttpServletResponse resp, RepuestoPorRepaDTO repuesto, String dir) throws ServletException, IOException{
		RepuestoPorRepaManager rprm = RepuestoPorRepaManager.getRepuestoPorRepaManager();
		String insercion = rprm.insertRepuestoPorRepa(repuesto);
		if(insercion.equals("success")){
			req.getSession().setAttribute("resultsql", "El repuesto se agrego correctamente");
			resp.sendRedirect(AGRREPUESTO_PATH);
		}
		else{
			rechazar(req, resp,insercion,AGRREPUESTO_PATH);
		}
		
	}

}
