package com.labbd.serviteca.business.reparacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.services.connection.DBConnection;

public class EstadoDAO {
	
	private static EstadoDAO dao;

    private EstadoDAO(){}

    public static EstadoDAO getEstadoDAO(){
        if(dao == null){
            dao = new EstadoDAO();
        }
        return dao;
    }
    
    public EstadoDTO getEstado(EstadoDTO e){
        EstadoDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(EstadoDAOHelper.getEstado());

            p.setString(1, e.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                EstadoDTO estado = new EstadoDTO();
                estado.setCodigo(rs.getString(1));
                estado.setNombre(rs.getString(2));
                estado.setDescripcion(rs.getString(3));
                //estado.setTbReparacions(tbReparacions);
                result = estado;
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

    public List<EstadoDTO> getEstados(){
            List<EstadoDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(EstadoDAOHelper.getEstados());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<EstadoDTO>();
                while(rs.next()){
                	EstadoDTO estado = new EstadoDTO();
                    estado.setCodigo(rs.getString(1));
                    estado.setNombre(rs.getString(2));
                    estado.setDescripcion(rs.getString(3));
                    //estado.setTbReparacions(tbReparacions);
                    result.add(estado);
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
