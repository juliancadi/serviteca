package com.labbd.serviteca.services.session;

import java.util.List;

public class RolManager {
	
	private RolDAO dao =  RolDAO.getRolDAO();
    private static RolManager manager;

    private RolManager(){}

    public static RolManager getRolManager(){
        if(manager == null){
           manager = new RolManager();
        }
       return manager;
    }

   public RolDTO getRol(RolDTO en){
       RolDTO rol = dao.getRol(en);
       return rol;
   }

   public List<RolDTO> getRols(){
       List<RolDTO> rols = null;
       rols = dao.getRols();
       return rols;
	}
   
    public List<RolDTO> getRolsPorUsuario(UsuarioDTO u){
       List<RolDTO> rols = null;
       rols = dao.getRolsPorUsuario(u);
       return rols;
	}

}
