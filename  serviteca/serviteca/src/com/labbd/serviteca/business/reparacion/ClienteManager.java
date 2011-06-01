package com.labbd.serviteca.business.reparacion;

import java.util.List;

public class ClienteManager {

	private ClienteDAO dao =  ClienteDAO.getClienteDAO();
    private static ClienteManager manager;

    private ClienteManager(){}

    public static ClienteManager getClienteManager(){
        if(manager == null){
           manager = new ClienteManager();
        }
       return manager;
    }

   public ClienteDTO getCliente(ClienteDTO c){
       ClienteDTO cliente = dao.getCliente(c);
       return cliente;
   }

   public List<ClienteDTO> getClientees(){
       List<ClienteDTO> clientes = null;
       clientes = dao.getClientes();
       return clientes;
	}
}
