package com.labbd.serviteca.business.reparacion;

public class EstadoDAOHelper {
	
	public static String getEstado() {
        String result = "SELECT codigo, nombre, descripcion FROM tb_estado WHERE codigo=?";
        return result;
    }
	
    public static String getEstados() {
    	String result = "SELECT codigo, nombre, descripcion FROM tb_estado ORDER BY nombre";
        return result;
    }


}
