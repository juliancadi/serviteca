package com.labbd.serviteca.business.reparacion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.services.connection.DBConnection;

public class MecanicoDAO {
	
	private static MecanicoDAO dao;

    private MecanicoDAO(){}

    public static MecanicoDAO getMecanicoDAO(){
        if(dao == null){
            dao = new MecanicoDAO();
        }
        return dao;
    }
    
    public MecanicoDTO getMecanico(MecanicoDTO m){
        MecanicoDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(MecanicoDAOHelper.getMecanico());

            p.setString(1, m.getCedula());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                MecanicoDTO mecanico = new MecanicoDTO();
                mecanico.setCedula(rs.getString(1));
                mecanico.setNombre(rs.getString(2));
                mecanico.setApellido(rs.getString(3));
                mecanico.setTelFijo(rs.getString(4));
                mecanico.setTelMovil(rs.getString(5));
                mecanico.setEmail(rs.getString(6));
                mecanico.setSueldo(new BigDecimal(rs.getInt(7)));
                //mecanico.setTbEspecialidads(tbEspecialidads);
                //mecanico.setTbReparacions(tbReparacions);
                result = mecanico;
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

    public List<MecanicoDTO> getMecanicos(){
            List<MecanicoDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(MecanicoDAOHelper.getMecanicos());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<MecanicoDTO>();
                while(rs.next()){
                	MecanicoDTO mecanico = new MecanicoDTO();
                    mecanico.setCedula(rs.getString(1));
                    mecanico.setNombre(rs.getString(2));
                    mecanico.setApellido(rs.getString(3));
                    mecanico.setTelFijo(rs.getString(4));
                    mecanico.setTelMovil(rs.getString(5));
                    mecanico.setEmail(rs.getString(6));
                    mecanico.setSueldo(new BigDecimal(rs.getInt(7)));
                    //mecanico.setTbEspecialidads(tbEspecialidads);
                    //mecanico.setTbReparacions(tbReparacions);
                    result.add(mecanico);
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
