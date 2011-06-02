package com.labbd.serviteca.business.reparacion;

import java.util.List;

public class ProveedorManager {
	
	private ProveedorDAO dao =  ProveedorDAO.getProveedorDAO();
    private static ProveedorManager manager;

    private ProveedorManager(){}

    public static ProveedorManager getProveedorManager(){
        if(manager == null){
           manager = new ProveedorManager();
        }
       return manager;
    }

   public ProveedorDTO getProveedor(ProveedorDTO p){
       ProveedorDTO proveedor = dao.getProveedor(p);
       return proveedor;
   }

   public List<ProveedorDTO> getProveedores(){
       List<ProveedorDTO> proveedores = null;
       proveedores = dao.getProveedores();
       return proveedores;
	}

}
