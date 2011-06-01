package com.labbd.serviteca.business.reparacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.services.connection.DBConnection;

public class ClienteDAO {
	
	private static ClienteDAO dao;

    private ClienteDAO(){}

    public static ClienteDAO getClienteDAO(){
        if(dao == null){
            dao = new ClienteDAO();
        }
        return dao;
    }
    
    public ClienteDTO getCliente(ClienteDTO c){
        ClienteDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(ClienteDAOHelper.getCliente());

            p.setString(1, c.getCedula());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                ClienteDTO cliente = new ClienteDTO();
                cliente.setCedula(rs.getString(1));
                cliente.setApellido(rs.getString(2));
                cliente.setTelFijo(rs.getString(3));
                cliente.setTelMovil(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                /*AutomovilManager am = AutomovilManager.getAutomovilManager();
                cliente.setTbAutomoviles(am.getAutomovilesPorCliente())*/
                result = cliente;
            }
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            try{
            	DBConnection.returnConnection(con);
            }
            catch(Exception clo){}
        }
        return result;
    }

    public List<ClienteDTO> getClientes(){
            List<ClienteDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(ClienteDAOHelper.getClientes());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<ClienteDTO>();
                while(rs.next()){
                	ClienteDTO cliente = new ClienteDTO();
                    cliente.setCedula(rs.getString(1));
                    cliente.setApellido(rs.getString(2));
                    cliente.setTelFijo(rs.getString(3));
                    cliente.setTelMovil(rs.getString(4));
                    cliente.setEmail(rs.getString(5));
                    /*AutomovilManager am = AutomovilManager.getAutomovilManager();
                    cliente.setTbAutomoviles(am.getAutomovilesPorCliente())*/
                    result.add(cliente);
                }
            }
            catch(Exception ex){
                    ex.printStackTrace();
            }
            finally{
                try{
                	DBConnection.returnConnection(con);
                }
                catch(Exception clo){}
            }
            return result;
	}

}
