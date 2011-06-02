package com.labbd.serviteca.business.reparacion;

public class RepuestoDAOHelper {
	
	public static String getRepuesto() {
        String result = "SELECT codigo, nombre, existencias, proveedor, costo_compra, marca, descripcion FROM tb_repuesto WHERE codigo=?";
        return result;
    }
	
    public static String getRepuestos() {
    	String result = "SELECT codigo, nombre, existencias, proveedor, costo_compra, marca, descripcion FROM tb_repuesto ORDER BY codigo";
        return result;
    }

}
