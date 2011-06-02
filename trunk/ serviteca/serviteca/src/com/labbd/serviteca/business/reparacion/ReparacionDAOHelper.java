package com.labbd.serviteca.business.reparacion;

public class ReparacionDAOHelper {
	
	public static String getReparacion() {
        String result = "SELECT codigo, automovil, fecha_ingreso, fecha_salida, encargado, estado, costo FROM tb_reparacion WHERE codigo=?";
        return result;
    }

    public static String getReparaciones() {
    	String result = "SELECT codigo, automovil, fecha_ingreso, fecha_salida, encargado, estado, costo FROM tb_reparacion ORDER BY codigo";
        return result;
    }

}
