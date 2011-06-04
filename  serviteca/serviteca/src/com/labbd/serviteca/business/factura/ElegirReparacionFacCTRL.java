package com.labbd.serviteca.business.factura;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labbd.serviteca.business.reparacion.ReparacionDTO;
import com.labbd.serviteca.services.session.UsuarioDTO;

/**
 * Servlet implementation class ElegirReparacionFacCTRL
 */
@WebServlet("/ElegirReparacionFacCTRL")
public class ElegirReparacionFacCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NO_REPA = "Debe elegir una reparacion";
	private static final String ELG_REPA = "com/labbd/serviteca/view/elegirReparacionFac.jsp";
	private static final String VERFACTURA_PATH = "com/labbd/serviteca/view/verFactura.jsp";
	private static final String NO_USER = "Debe ingresar con el nombre de usuario y contraseña";
	private static final String INDEX = "index.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElegirReparacionFacCTRL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("usuarioactual");
		if(usuario!=null){
			String codigoRep = request.getParameter("selReparacion");
			if(codigoRep!=null){
				aprobar(request, response, codigoRep);
			}
			else{
				rechazar(request, response,NO_REPA,ELG_REPA);
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

	private void aprobar(HttpServletRequest req, HttpServletResponse resp, String codigoRep) throws ServletException, IOException{
		FacturaManager fm = FacturaManager.getFacturaManager();		
		ReparacionDTO reparacion = new ReparacionDTO();
		reparacion.setCodigo(codigoRep);
		FacturaDTO ff = fm.generarFactura(reparacion);
		req.getSession().setAttribute("factura", ff);		
		resp.sendRedirect(VERFACTURA_PATH);
	}

}


