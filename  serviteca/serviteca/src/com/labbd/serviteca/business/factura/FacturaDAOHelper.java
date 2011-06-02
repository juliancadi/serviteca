package com.labbd.serviteca.business.factura;

public class FacturaDAOHelper {
	
	public static String getFactura() {
        String result = "SELECT codigo, reparacion, valor_neto, iva, valor_total FROM tb_factura WHERE codigo=?";
        return result;
    }
	
    public static String getFacturas() {
    	String result = "SELECT codigo, reparacion, valor_neto, iva, valor_total FROM tb_factura ORDER BY codigo";
        return result;
    }
    
    public static String generarFactura() {
    	String result = "{?=call generar_factura(?)}";
        return result;
    }

}
