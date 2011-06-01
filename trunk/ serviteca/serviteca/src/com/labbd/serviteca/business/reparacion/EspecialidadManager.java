package com.labbd.serviteca.business.reparacion;

import java.util.List;

public class EspecialidadManager {

	private EspecialidadDAO dao =  EspecialidadDAO.getEspecialidadDAO();
    private static EspecialidadManager manager;

    private EspecialidadManager(){}

    public static EspecialidadManager getEspecialidadManager(){
        if(manager == null){
           manager = new EspecialidadManager();
        }
       return manager;
    }

   public EspecialidadDTO getEspecialidad(EspecialidadDTO e){
       EspecialidadDTO especialidad = dao.getEspecialidad(e);
       return especialidad;
   }

   public List<EspecialidadDTO> getEspecialidades(){
       List<EspecialidadDTO> especialidades = null;
       especialidades = dao.getEspecialidades();
       return especialidades;
	}
}
