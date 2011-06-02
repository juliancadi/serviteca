package com.labbd.serviteca.business.reparacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.services.connection.DBConnection;

public class EspecialidadDAO {

	private static EspecialidadDAO dao;

    private EspecialidadDAO(){}

    public static EspecialidadDAO getEspecialidadDAO(){
        if(dao == null){
            dao = new EspecialidadDAO();
        }
        return dao;
    }
    
    public EspecialidadDTO getEspecialidad(EspecialidadDTO e){
        EspecialidadDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(EspecialidadDAOHelper.getEspecialidad());

            p.setString(1, e.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                EspecialidadDTO especialidad = new EspecialidadDTO();
                especialidad.setCodigo(rs.getString(1));
                especialidad.setNombre(rs.getString(2));
                especialidad.setDescripcion(rs.getString(3));
                //especialidad.setTbMecanicos(tbMecanicos);
                result = especialidad;
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

    public List<EspecialidadDTO> getEspecialidades(){
            List<EspecialidadDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(EspecialidadDAOHelper.getEspecialidades());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<EspecialidadDTO>();
                while(rs.next()){
                	EspecialidadDTO especialidad = new EspecialidadDTO();
                    especialidad.setCodigo(rs.getString(1));
                    especialidad.setNombre(rs.getString(2));
                    especialidad.setDescripcion(rs.getString(3));
                    //especialidad.setTbMecanicos(tbMecanicos);
                    result.add(especialidad);
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
