package com.labbd.serviteca.business.reparacion;

import java.util.List;

public class EstadoManager {
	
	private EstadoDAO dao =  EstadoDAO.getEstadoDAO();
    private static EstadoManager manager;

    private EstadoManager(){}

    public static EstadoManager getEstadoManager(){
        if(manager == null){
           manager = new EstadoManager();
        }
       return manager;
    }

   public EstadoDTO getEstado(EstadoDTO e){
       EstadoDTO estado = dao.getEstado(e);
       return estado;
   }

   public List<EstadoDTO> getEstados(){
       List<EstadoDTO> estados = null;
       estados = dao.getEstados();
       return estados;
	}

}
