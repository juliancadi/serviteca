package com.labbd.serviteca.business.reparacion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.services.connection.DBConnection;

public class RepuestoPorRepaDAO {
	
	private static RepuestoPorRepaDAO dao;

    private RepuestoPorRepaDAO(){}

    public static RepuestoPorRepaDAO getRepuestoPorRepaDAO(){
        if(dao == null){
            dao = new RepuestoPorRepaDAO();
        }
        return dao;
    }
    
    public RepuestoPorRepaDTO getRepuestoPorRepa(RepuestoPorRepaDTO r){
        RepuestoPorRepaDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(RepuestoPorRepaDAOHelper.getRepuestoPorRepa());

            p.setString(1, r.getTbRepuesto().getCodigo());
            p.setString(2, r.getTbReparacion().getCodigo());
            
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                RepuestoPorRepaDTO repuestoPorRepa = new RepuestoPorRepaDTO();
                
                RepuestoManager rm = RepuestoManager.getRepuestoManager();
                RepuestoDTO repuesto = new RepuestoDTO();
                repuestoPorRepa.setTbRepuesto(rm.getRepuesto(repuesto));
                
                ReparacionManager rpm = ReparacionManager.getReparacionManager();
                ReparacionDTO reparacion = new ReparacionDTO();
                repuestoPorRepa.setTbReparacion(rpm.getReparacion(reparacion));
                
                repuestoPorRepa.setCantidad(new BigDecimal(rs.getInt(3)));
                repuestoPorRepa.setCostoVenta(new BigDecimal(rs.getInt(4)));
                result = repuestoPorRepa;
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

    public List<RepuestoPorRepaDTO> getRepuestosPorRepa(){
            List<RepuestoPorRepaDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(RepuestoPorRepaDAOHelper.getRepuestosPorRepa());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<RepuestoPorRepaDTO>();
                while(rs.next()){
                	RepuestoPorRepaDTO repuestoPorRepa = new RepuestoPorRepaDTO();
                    
                    RepuestoManager rm = RepuestoManager.getRepuestoManager();
                    RepuestoDTO repuesto = new RepuestoDTO();
                    repuestoPorRepa.setTbRepuesto(rm.getRepuesto(repuesto));
                    
                    ReparacionManager rpm = ReparacionManager.getReparacionManager();
                    ReparacionDTO reparacion = new ReparacionDTO();
                    repuestoPorRepa.setTbReparacion(rpm.getReparacion(reparacion));
                    
                    repuestoPorRepa.setCantidad(new BigDecimal(rs.getInt(3)));
                    repuestoPorRepa.setCostoVenta(new BigDecimal(rs.getInt(4)));
                    result.add(repuestoPorRepa);
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
