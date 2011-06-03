package com.labbd.serviteca.business.reparacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ElegirReparacionCTRL
 */
@WebServlet("/ElegirReparacionCTRL")
public class ElegirReparacionCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MODREPARACION_PATH = "com/labbd/serviteca/view/modificarReparacion.jsp";
       
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigoRep = request.getParameter("selAuto");
		if(codigoRep!=null && codigoRep.equals("0")){
			ReparacionManager rm = ReparacionManager.getReparacionManager();
			ReparacionDTO reparacion = new ReparacionDTO();
			reparacion.setCodigo(codigoRep);
			reparacion = rm.getReparacion(reparacion);
			request.setAttribute("reparacion", reparacion);
			response.sendRedirect(MODREPARACION_PATH);
		}
		
	}

}
