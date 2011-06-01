package com.labbd.serviteca.business.reparacion;

public class ClienteDAOHelper {
	
	public static String getCliente() {
        String result = "SELECT cedula, nombre, apellido, tel_fijo, tel_movil, email FROM tb_cliente WHERE cedula=?";
        return result;
    }
	
    public static String getClientes() {
    	String result = "SELECT cedula, nombre, apellido, tel_fijo, tel_movil, email FROM tb_cliente ORDER BY nombre";
        return result;
    }

}
