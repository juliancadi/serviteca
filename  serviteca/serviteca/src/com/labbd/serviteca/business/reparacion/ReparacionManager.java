package com.labbd.serviteca.business.reparacion;

import java.util.List;

public class ReparacionManager {
	
	private ReparacionDAO dao =  ReparacionDAO.getReparacionDAO();
    private static ReparacionManager manager;

    private ReparacionManager(){}

    public static ReparacionManager getReparacionManager(){
        if(manager == null){
           manager = new ReparacionManager();
        }
       return manager;
    }

   public ReparacionDTO getReparacion(ReparacionDTO r){
       ReparacionDTO reparacion = dao.getReparacion(r);
       return reparacion;
   }

   public List<ReparacionDTO> getReparaciones(){
       List<ReparacionDTO> reparaciones = null;
       reparaciones = dao.getReparaciones();
       return reparaciones;
	}
   
   public String insertReparacion(ReparacionDTO r){
       String insert = "null";
       insert = dao.insertReparacion(r);
       return insert;
	}

}
