package com.labbd.serviteca.business.reparacion;


public class MecanicoDAOHelper {
	
	public static String getMecanico() {
        String result = "SELECT cedula, nombre, apellido, tel_fijo, tel_movil, email, sueldo FROM tb_mecanico WHERE cedula=?";
        return result;
    }
	
	
    public static String getMecanicos() {
    	String result = "SELECT cedula, nombre, apellido, tel_fijo, tel_movil, email, sueldo FROM tb_mecanico ORDER BY nombre";
        return result;
    }

}
