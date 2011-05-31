package com.labbd.serviteca.services.session;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.labbd.serviteca.services.connection.DBConnection;

public class UsuarioDAO {
	
	private static UsuarioDAO dao;

    private UsuarioDAO(){}

    public static UsuarioDAO getUsuarioDAO(){
        if(dao == null){
            dao = new UsuarioDAO();
        }
        return dao;
    }
    
    public UsuarioDTO getUsuario(UsuarioDTO u){
        UsuarioDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(UsuarioDAOHelper.getUsuario());

            p.setString(1, u.getNombre());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                UsuarioDTO us = new UsuarioDTO();
                us.setNombre(rs.getString(1));
                us.setClave(rs.getString(2));
                RolManager rm = RolManager.getRolManager();
                us.setTbRols(rm.getRolsPorUsuario(us));
                result = us;
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

    public List<UsuarioDTO> getUsuarios(){
            List<UsuarioDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(UsuarioDAOHelper.getUsuarios());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<UsuarioDTO>();
                while(rs.next()){
                    UsuarioDTO us = new UsuarioDTO();
                    us.setNombre(rs.getString(1));
                    us.setClave(rs.getString(2));
                    RolManager rm = RolManager.getRolManager();
                    us.setTbRols(rm.getRolsPorUsuario(us));
                    result.add(us);
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
    
    
    public boolean existUsuario(UsuarioDTO u){
        boolean result=false;
        Connection con=null;
        try{
            con = DBConnection.getConnection();
            String vidahp = UsuarioDAOHelper.existUsuario();
            PreparedStatement p = con.prepareStatement(vidahp);
            p.setString(1, u.getNombre());
            p.setString(2, u.getClave());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                result=true;
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

