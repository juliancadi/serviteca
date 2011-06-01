package com.labbd.serviteca.business.reparacion;

public class AutomovilDAOHelper {
	
	public static String getAutomovil() {
        String result = "SELECT codigo, placa, matricula, marca, linea, modelo, motor, color, chasis, cliente, observaciones FROM tb_automovil WHERE codigo=?";
        return result;
    }

    public static String getAutomoviles() {
    	String result = "SELECT codigo, placa, matricula, marca, linea, modelo, motor, color, chasis, cliente, observaciones FROM tb_automovil ORDER BY codigo";
        return result;
    }

}
