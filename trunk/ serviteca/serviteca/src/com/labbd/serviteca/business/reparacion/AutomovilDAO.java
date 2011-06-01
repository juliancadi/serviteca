package com.labbd.serviteca.business.reparacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.services.connection.DBConnection;


public class AutomovilDAO {
	
	private static AutomovilDAO dao;

    private AutomovilDAO(){}

    public static AutomovilDAO getAutomovilDAO(){
        if(dao == null){
            dao = new AutomovilDAO();
        }
        return dao;
    }
    
    public AutomovilDTO getAutomovil(AutomovilDTO a){
        AutomovilDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(AutomovilDAOHelper.getAutomovil());

            p.setString(1, a.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                AutomovilDTO automovil = new AutomovilDTO();
                automovil.setCodigo(rs.getString(1));
                automovil.setPlaca(rs.getString(2));
                automovil.setMatricula(rs.getString(3));
                automovil.setMarca(rs.getString(4));
                automovil.setLinea(rs.getString(5));
                automovil.setModelo(rs.getString(6));
                automovil.setMotor(rs.getString(7));
                automovil.setColor(rs.getString(8));
                automovil.setChasis(rs.getString(9));
                ClienteManager cm = ClienteManager.getClienteManager();
                ClienteDTO cliente = new ClienteDTO();
                cliente.setCedula(rs.getString(10));
                automovil.setTbCliente(cm.getCliente(cliente));
                automovil.setObservaciones(rs.getString(11));
                //automovil.setTbReparaciones(tbReparacions)
                result = automovil;
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

    public List<AutomovilDTO> getAutomoviles(){
            List<AutomovilDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(AutomovilDAOHelper.getAutomoviles());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<AutomovilDTO>();
                while(rs.next()){
                	AutomovilDTO automovil = new AutomovilDTO();
                    automovil.setCodigo(rs.getString(1));
                    automovil.setPlaca(rs.getString(2));
                    automovil.setMatricula(rs.getString(3));
                    automovil.setMarca(rs.getString(4));
                    automovil.setLinea(rs.getString(5));
                    automovil.setModelo(rs.getString(6));
                    automovil.setMotor(rs.getString(7));
                    automovil.setColor(rs.getString(8));
                    automovil.setChasis(rs.getString(9));
                    ClienteDTO cliente = new ClienteDTO();
                    cliente.setCedula(rs.getString(10));
                    automovil.setTbCliente(cliente);
                    automovil.setObservaciones(rs.getString(11));
                    //automovil.setTbReparaciones(tbReparacions)
                    result.add(automovil);
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
