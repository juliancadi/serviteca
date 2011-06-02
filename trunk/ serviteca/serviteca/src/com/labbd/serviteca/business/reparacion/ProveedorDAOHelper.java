package com.labbd.serviteca.business.reparacion;

public class ProveedorDAOHelper {
	
	public static String getProveedor() {
        String result = "SELECT nit, nombre_empresa, nombre_encargado, apellido_encargado, tel_fijo, tel_movil, email, direccion FROM tb_proveedor WHERE nit=?";
        return result;
    }


    public static String getProveedores() {
    	String result = "SELECT nit, nombre_empresa, nombre_encargado, apellido_encargado, tel_fijo, tel_movil, email, direccion FROM tb_proveedor ORDER BY nombre_empresa";
        return result;
    }

}
