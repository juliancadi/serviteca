package com.labbd.serviteca.business.reparacion;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labbd.serviteca.services.session.UsuarioDTO;

/**
 * Servlet implementation class QuitarRepuestoCTRL
 */
@WebServlet("/QuitarRepuestoCTRL")
public class QuitarRepuestoCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String QUIREPUESTO_PATH = "com/labbd/serviteca/view/quitarRepuesto.jsp";
	private static final String NO_USER = "Debe ingresar con el nombre de usuario y contraseña";
	private static final String ERROR = "Ocurrio un error";
	private static final String INDEX = "index.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuitarRepuestoCTRL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rechazar(request,response,NO_USER,INDEX);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("usuarioactual");
		if(usuario!=null){
			String codigoReparacion = request.getParameter("reparacion");
			String codigoRepuesto = request.getParameter("selRepuesto");
			if(codigoReparacion!=null && codigoRepuesto!=null){
				RepuestoPorRepaDTO repuestoBorrar = new RepuestoPorRepaDTO();
				ReparacionDTO reparacion = new ReparacionDTO();
				reparacion.setCodigo(codigoReparacion);
				RepuestoDTO repuesto = new RepuestoDTO();
				repuesto.setCodigo(codigoRepuesto);
				
				repuestoBorrar.setTbReparacion(reparacion);
				repuestoBorrar.setTbRepuesto(repuesto);
				
				aprobar(request, response, repuestoBorrar, QUIREPUESTO_PATH);
			}
			else{
				rechazar(request, response,ERROR,QUIREPUESTO_PATH);
			}
		}
		else{
			rechazar(request, response,NO_USER, INDEX);
		}
	}
	
	private void rechazar(HttpServletRequest req, HttpServletResponse resp, Object respuesta, String path) throws ServletException, IOException{
		req.getSession().setAttribute("respuestaSolicitud", respuesta);
		resp.sendRedirect(path);
	}

	private void aprobar(HttpServletRequest req, HttpServletResponse resp, RepuestoPorRepaDTO repuesto, String dir) throws ServletException, IOException{
		RepuestoPorRepaManager rprm = RepuestoPorRepaManager.getRepuestoPorRepaManager();
		String eliminacion = rprm.deleteRepuestoPorRepa(repuesto);
		if(eliminacion.equals("success")){
			req.getSession().setAttribute("resultsql", "El repuesto se eliminó correctamente");
			resp.sendRedirect(QUIREPUESTO_PATH);
		}
		else{
			rechazar(req, resp,eliminacion,QUIREPUESTO_PATH);
		}
		
	}

}
