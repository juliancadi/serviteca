package com.labbd.serviteca.business.reparacion;

import java.util.List;

public class RepuestoPorRepaManager {
	
	private RepuestoPorRepaDAO dao =  RepuestoPorRepaDAO.getRepuestoPorRepaDAO();
    private static RepuestoPorRepaManager manager;

    private RepuestoPorRepaManager(){}

    public static RepuestoPorRepaManager getRepuestoPorRepaManager(){
        if(manager == null){
           manager = new RepuestoPorRepaManager();
        }
       return manager;
    }

   public RepuestoPorRepaDTO getRepuestoPorRepa(RepuestoPorRepaDTO r){
       RepuestoPorRepaDTO repuestoPorRepa = dao.getRepuestoPorRepa(r);
       return repuestoPorRepa;
   }

   public List<RepuestoPorRepaDTO> getRepuestosPorRepa(){
       List<RepuestoPorRepaDTO> repuestosPorRepa = null;
       repuestosPorRepa = dao.getRepuestosPorRepa();
       return repuestosPorRepa;
	}

}
