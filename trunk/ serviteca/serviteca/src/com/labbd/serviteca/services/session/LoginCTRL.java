package com.labbd.serviteca.services.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCTRL
 */
@WebServlet("/LoginCTRL")
public class LoginCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INVALID_USER = "El usuario o la clave es incorrecto";
	private static final String SIN_ROLES = "El usuario no tiene ningún rol";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCTRL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rechazar(request,response,INVALID_USER);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("txtUser");
		String pass = request.getParameter("txtPass");
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNombre(user);
		usuario.setClave(pass);
		UsuarioManager um = UsuarioManager.getUsuarioManager();
		if(um.existUsuario(usuario)){
			usuario = um.getUsuario(usuario);
			if(usuario.getTbRols()==null || usuario.getTbRols().isEmpty()){
				rechazar(request, response, SIN_ROLES);
			}
			else{
				aprobar(request, response, usuario);
			}
		}
		else{
			rechazar(request, response,INVALID_USER);
		}
	}
	
	private void rechazar(HttpServletRequest req, HttpServletResponse resp, Object respuesta) throws ServletException, IOException{
		req.getSession().setAttribute("respuestaSolicitud", respuesta);
		resp.sendRedirect("index.jsp");
	}

	private void aprobar(HttpServletRequest req, HttpServletResponse resp, UsuarioDTO u) throws ServletException, IOException{

			/*HttpSession session = req.getSession(true);
			session.setMaxInactiveInterval(60*60*2);
			req.getSession().setAttribute("usuarioactual", usuario);
			resp.sendRedirect(getPath(cargo));*/
			resp.getWriter().println("PAGINA QUE NO HEMOS HECHO");
		
	}

	/*public static RespuestaDTO getMensaje(HttpServletRequest req){
        RespuestaDTO result = new RespuestaDTO();
        result.setMensaje(req.getSession().getAttribute("respuestaSolicitud"));
		return result;
	}*/

}
