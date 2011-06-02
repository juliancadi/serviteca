package com.labbd.serviteca.business.reparacion;

public class EspecialidadDAOHelper {
	
	public static String getEspecialidad() {
        String result = "SELECT codigo, nombre, descripcion FROM tb_especialidad WHERE codigo=?";
        return result;
    }

    public static String getEspecialidades() {
    	String result = "SELECT codigo, nombre, descripcion FROM tb_especialidad ORDER BY nombre";
        return result;
    }

}
