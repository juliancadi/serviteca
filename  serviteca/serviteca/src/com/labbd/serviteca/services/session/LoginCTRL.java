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
	private static final String INVALID_USER = "Por favor ingrese el nombre de usuario y/o contraseña correctamente";
	private static final String FALTAN_PARAMETROS = "El usuario y clave son requeridos";   
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("txtUser");
		String pass = request.getParameter("txtPass");

		/*if(exixte){
			
		}
		else{
			
		}*/
	}

}
