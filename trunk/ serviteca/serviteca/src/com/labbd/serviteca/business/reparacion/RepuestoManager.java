package com.labbd.serviteca.business.reparacion;

import java.util.List;

public class RepuestoManager {
	
	private RepuestoDAO dao =  RepuestoDAO.getRepuestoDAO();
    private static RepuestoManager manager;

    private RepuestoManager(){}

    public static RepuestoManager getRepuestoManager(){
        if(manager == null){
           manager = new RepuestoManager();
        }
       return manager;
    }

   public RepuestoDTO getRepuesto(RepuestoDTO r){
       RepuestoDTO repuesto = dao.getRepuesto(r);
       return repuesto;
   }

   public List<RepuestoDTO> getRepuestoes(){
       List<RepuestoDTO> repuestos = null;
       repuestos = dao.getRepuestos();
       return repuestos;
	}

}
