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
	private static final String NO_USER = "Debe ingresar con el nombre de usuario y contraseña";
	
       
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
		rechazar(request,response,NO_USER);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("usuarioactual");
		if(usuario!=null){
			String codigoRep = request.getParameter("selAuto");
			if(codigoRep!=null && codigoRep.equals("0")){
				aprobar(request, response, codigoRep);
			}
			else{
				rechazar(request, response,NO_USER);
			}
		}
		else{
			rechazar(request, response,NO_USER);
		}
		
	}
	
	private void rechazar(HttpServletRequest req, HttpServletResponse resp, Object respuesta) throws ServletException, IOException{
		req.getSession().setAttribute("respuestaSolicitud", respuesta);
		resp.sendRedirect("index.jsp");
	}

	private void aprobar(HttpServletRequest req, HttpServletResponse resp, String codigoRep) throws ServletException, IOException{
		ReparacionManager rm = ReparacionManager.getReparacionManager();
		ReparacionDTO reparacion = new ReparacionDTO();
		reparacion.setCodigo(codigoRep);
		reparacion = rm.getReparacion(reparacion);
		req.setAttribute("reparacion", reparacion);
		resp.sendRedirect(MODREPARACION_PATH);
	}

}
