package com.labbd.serviteca.business.reparacion;

import java.util.List;

public class MecanicoManager {
	
	private MecanicoDAO dao =  MecanicoDAO.getMecanicoDAO();
    private static MecanicoManager manager;

    private MecanicoManager(){}

    public static MecanicoManager getMecanicoManager(){
        if(manager == null){
           manager = new MecanicoManager();
        }
       return manager;
    }

   public MecanicoDTO getMecanico(MecanicoDTO e){
       MecanicoDTO mecanico = dao.getMecanico(e);
       return mecanico;
   }

   public List<MecanicoDTO> getMecanicoes(){
       List<MecanicoDTO> mecanicos = null;
       mecanicos = dao.getMecanicos();
       return mecanicos;
	}

}
