package com.labbd.serviteca.business.reparacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labbd.serviteca.services.session.UsuarioDTO;

/**
 * Servlet implementation class ElegirReparacionCTRL
 */
@WebServlet("/ElegirReparacionCTRL")
public class ElegirReparacionCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MODREPARACION_PATH = "com/labbd/serviteca/view/modificarReparacion.jsp";
	private static final String AGRREPUESTO_PATH = "com/labbd/serviteca/view/agregarRepuesto.jsp";
	private static final String QUIREPUESTO_PATH = "com/labbd/serviteca/view/quitarRepuesto.jsp";
	private static final String NO_USER = "Debe ingresar con el nombre de usuario y contraseña";
	private static final String NO_REPA = "Debe elegir una reparacion";
	private static final String ELG_REPA = "com/labbd/serviteca/view/elegirReparacion.jsp";
	private static final String INDEX = "index.jsp";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElegirReparacionCTRL() {
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
			String codigoRep = request.getParameter("selAuto");
			String dir = request.getParameter("dir");
			if(codigoRep!=null && !codigoRep.equals("0")){
				aprobar(request, response, codigoRep, dir);
			}
			else{
				rechazar(request, response,NO_REPA,ELG_REPA+"?dir="+dir);
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

	private void aprobar(HttpServletRequest req, HttpServletResponse resp, String codigoRep, String dir) throws ServletException, IOException{
		ReparacionManager rm = ReparacionManager.getReparacionManager();
		ReparacionDTO reparacion = new ReparacionDTO();
		reparacion.setCodigo(codigoRep);
		reparacion = rm.getReparacion(reparacion);
		req.setAttribute("reparacion", reparacion);
		if(dir.equals("mod")){
			resp.sendRedirect(MODREPARACION_PATH);	
		}
		else{
			if(dir.equals("agr")){
				resp.sendRedirect(AGRREPUESTO_PATH);	
			}
			else{
				if(dir.equals("qui")){
					resp.sendRedirect(QUIREPUESTO_PATH);	
				}
			}
		}
		
	}

}
