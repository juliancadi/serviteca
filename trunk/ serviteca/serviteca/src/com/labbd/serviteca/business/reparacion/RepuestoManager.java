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

   public List<RepuestoDTO> getRepuestos(){
       List<RepuestoDTO> repuestos = null;
       repuestos = dao.getRepuestos();
       return repuestos;
	}
   
   public List<RepuestoDTO> getRepuestosPorReparacion(ReparacionDTO r){
       List<RepuestoDTO> repuestos = null;
       repuestos = dao.getRepuestosPorReparacion(r);
       return repuestos;
	}

}
