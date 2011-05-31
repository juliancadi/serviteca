package com.labbd.serviteca.services.session;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.labbd.serviteca.services.connection.DBConnection;

public class RolDAO {
	
	private static RolDAO dao;

    private RolDAO(){}

    public static RolDAO getRolDAO(){
        if(dao == null){
            dao = new RolDAO();
        }
        return dao;
    }
    
    public RolDTO getRol(RolDTO r){
        RolDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(RolDAOHelper.getRol());

            p.setString(1, r.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                RolDTO rol = new RolDTO();
                rol.setCodigo(rs.getString(1));
                rol.setNombre(rs.getString(2));
                rol.setDescripcion(rs.getString(3));
                result = rol;
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

    public List<RolDTO> getRols(){
            List<RolDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(RolDAOHelper.getRols());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<RolDTO>();
                while(rs.next()){
                	RolDTO rol = new RolDTO();
                    rol.setCodigo(rs.getString(1));
                    rol.setNombre(rs.getString(2));
                    rol.setDescripcion(rs.getString(3));
                    result.add(rol);
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
    
    public List<RolDTO> getRolsPorUsuario(UsuarioDTO u){
        List<RolDTO> result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(RolDAOHelper.getRolsPorUsuario());
            p.setString(1, u.getNombre());
            ResultSet rs = p.executeQuery();
            result = new ArrayList<RolDTO>();
            while(rs.next()){
            	RolDTO rol = new RolDTO();
                rol.setCodigo(rs.getString(1));
                rol.setNombre(rs.getString(2));
                rol.setDescripcion(rs.getString(3));
                result.add(rol);
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

