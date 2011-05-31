package com.labbd.serviteca.services.session;

public class RolDAOHelper {
	
	public static String getRol() {
        String result = "SELECT codigo, nombre, descripcion FROM tb_rol WHERE codigo=?";
        return result;
    }

    public static String getRols() {
    	String result = "SELECT codigo, nombre, descripcion FROM tb_rol ORDER BY nombre";
        return result;
    }
    
    public static String getRolsPorUsuario() {
    	String result = "SELECT r.codigo, r.nombre, r.descripcion FROM tb_rol r, tb_rol_por_usuario pu WHERE r.codigo=pu.codigo_rol AND pu.nombre_usuario=? ORDER BY 2";
        return result;
    }

}
