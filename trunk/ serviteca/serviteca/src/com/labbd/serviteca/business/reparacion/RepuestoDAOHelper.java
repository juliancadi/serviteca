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
    
    public static String getRepuestosPorReparacion() {
    	String result = "SELECT r.codigo, r.nombre, r.existencias, r.proveedor, r.costo_compra, r.marca, r.descripcion FROM tb_repuesto r, tb_repuesto_por_repa rp WHERE r.codigo=rp.codigo_repuesto AND rp.codigo_repa=? ORDER BY codigo";
        return result;
    }

}
