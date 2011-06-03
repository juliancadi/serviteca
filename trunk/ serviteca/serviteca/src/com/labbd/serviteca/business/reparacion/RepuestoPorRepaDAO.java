package com.labbd.serviteca.business.reparacion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public String insertRepuestoPorRepa(RepuestoPorRepaDTO r){
        String result = "null";
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(RepuestoPorRepaDAOHelper.insertRepuestoPorRepa());

            p.setString(1, r.getTbRepuesto().getCodigo());
            p.setString(2, r.getTbReparacion().getCodigo());
            p.setBigDecimal(3, r.getCantidad());
            p.setBigDecimal(4, r.getCostoVenta());
            
            p.execute();
            result = "success";
        }
        catch(SQLException ex){
        	int error = ex.getErrorCode();
        	switch(error){
        	case 1:
        		result="Esta reparacion ya tiene este tipo de respuestos";
        		break;
        	case 20506:
        		result="No hay cantidad suficiente en inventario";
        		break;
        	default:
        		result = ex.getMessage();
        		break;
        	}
        }
        finally{
            try{
            	DBConnection.returnConnection(con);
            }
            catch(Exception clo){
            	result = clo.getMessage();
            }
        }
        return result;
    }
    
    public String deleteRepuestoPorRepa(RepuestoPorRepaDTO r){
        String result = "null";
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(RepuestoPorRepaDAOHelper.deleteRepuestoPorRepa());

            p.setString(1, r.getTbRepuesto().getCodigo());
            p.setString(2, r.getTbReparacion().getCodigo());
            
            p.execute();
            result = "success";
        }
        catch(Exception ex){
        	result = ex.getMessage();
        }
        finally{
            try{
            	DBConnection.returnConnection(con);
            }
            catch(Exception clo){
            	result = clo.getMessage();
            }
        }
        return result;
    }

}
