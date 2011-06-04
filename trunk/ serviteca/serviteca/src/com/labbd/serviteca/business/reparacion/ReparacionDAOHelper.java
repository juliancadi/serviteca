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
    
    public static String insertReparacion() {
        String result = "INSERT INTO tb_reparacion VALUES(?,?,?,?,?,?,?)";
        return result;
    }
    
    public static String modificarReparacion() {
        String result = "UPDATE tb_reparacion SET automovil=?,fecha_ingreso=?,fecha_salida=?,encargado=?,estado=?,costo=? WHERE codigo=?";
        return result;
    }

}
