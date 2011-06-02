package com.labbd.serviteca.services.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ElegirRolCTRL
 */
@WebServlet("/ElegirRolCTRL")
public class ElegirRolCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NO_USER = "Debe ingresar con el nombre de usuario y contraseña";
	private static final String ADMINISTRADOR = "1";
	private static final String ADMINISTRADOR_PATH = "com/labbd/serviteca/view/administradorMain.jsp";
	private static final String CONTADOR = "2";
	private static final String CONTADOR_PATH = "com/labbd/serviteca/view/contadorMain.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElegirRolCTRL() {
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
		String rol = request.getParameter("roles");
		if(usuario!=null && rol!=null){
			aprobar(request, response, rol);
		}
		else{
			rechazar(request, response,NO_USER);
		}
	}
	
	private void rechazar(HttpServletRequest req, HttpServletResponse resp, Object respuesta) throws ServletException, IOException{
		req.getSession().setAttribute("respuestaSolicitud", respuesta);
		resp.sendRedirect("index.jsp");
	}

	private void aprobar(HttpServletRequest req, HttpServletResponse resp, String rol) throws ServletException, IOException{
		if(rol.equals(ADMINISTRADOR)){
			resp.sendRedirect(ADMINISTRADOR_PATH);
		}else{
			if(rol.equals(CONTADOR)){
				resp.sendRedirect(CONTADOR_PATH);
			}
			else{
				rechazar(req, resp,NO_USER);
			}
		}
	}

}
