package com.labbd.serviteca.business.reparacion;

import java.util.List;


public class AutomovilManager {
	private AutomovilDAO dao =  AutomovilDAO.getAutomovilDAO();
    private static AutomovilManager manager;

    private AutomovilManager(){}

    public static AutomovilManager getAutomovilManager(){
        if(manager == null){
           manager = new AutomovilManager();
        }
       return manager;
    }

   public AutomovilDTO getAutomovil(AutomovilDTO en){
       AutomovilDTO automovil = dao.getAutomovil(en);
       return automovil;
   }

   public List<AutomovilDTO> getAutomoviles(){
       List<AutomovilDTO> automoviles = null;
       automoviles = dao.getAutomoviles();
       return automoviles;
	}

}
