package com.labbd.serviteca.services.session;

import java.util.List;


public class UsuarioManager {
	
	private UsuarioDAO dao =  UsuarioDAO.getUsuarioDAO();
    private static UsuarioManager manager;

    private UsuarioManager(){}

    public static UsuarioManager getUsuarioManager(){
        if(manager == null){
           manager = new UsuarioManager();
        }
       return manager;
    }


   public UsuarioDTO getUsuario(UsuarioDTO en){
       UsuarioDTO usuario = dao.getUsuario(en);
       return usuario;
   }

   public List<UsuarioDTO> getUsuarios(){
       List<UsuarioDTO> usuarios = null;
       usuarios = dao.getUsuarios();
       return usuarios;
	}
   
   public boolean existUsuario(UsuarioDTO en){
       boolean result=dao.existUsuario(en);
       return result;
   }

}

