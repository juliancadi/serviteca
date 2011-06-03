package com.labbd.serviteca.business.reparacion;

public class RepuestoPorRepaDAOHelper {
	
	public static String getRepuestoPorRepa() {
        String result = "SELECT codigo_repuesto, codigo_repa, cantidad, costo_venta FROM tb_repuesto_por_repa WHERE codigo_repuesto=? AND codigo_repa=?";
        return result;
    }
	
    public static String getRepuestosPorRepa() {
    	String result = "SELECT codigo_repuesto, codigo_repa, cantidad, costo_venta FROM tb_repuesto_por_repa";
        return result;
    }
    
    public static String insertRepuestoPorRepa() {
        String result = "INSERT INTO tb_repuesto_por_repa VALUES(?,?,?,?)";
        return result;
    }

}
