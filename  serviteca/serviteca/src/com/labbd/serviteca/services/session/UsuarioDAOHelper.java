package com.labbd.serviteca.services.session;

public class UsuarioDAOHelper {
	
	public static String getUsuario() {
        String result = "SELECT nombre, clave FROM tb_usuario WHERE nombre=?";
        return result;
    }

    public static String getUsuarios() {
    	String result = "SELECT nombre, clave FROM tb_usuario ORDER BY nombre";
        return result;
    }
    
    public static String existUsuario() {
    	String result = "SELECT nombre, clave FROM tb_usuario WHERE nombre=? AND clave=?";
        return result;
    }
    
}
