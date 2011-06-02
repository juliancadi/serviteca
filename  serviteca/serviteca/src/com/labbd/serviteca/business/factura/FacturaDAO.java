package com.labbd.serviteca.business.factura;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.business.reparacion.ReparacionDTO;
import com.labbd.serviteca.business.reparacion.ReparacionManager;
import com.labbd.serviteca.services.connection.DBConnection;

public class FacturaDAO {
	
	private static FacturaDAO dao;

    private FacturaDAO(){}

    public static FacturaDAO getFacturaDAO(){
        if(dao == null){
            dao = new FacturaDAO();
        }
        return dao;
    }
    
    public FacturaDTO getFactura(FacturaDTO f){
        FacturaDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(FacturaDAOHelper.getFactura());

            p.setString(1, f.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                FacturaDTO factura = new FacturaDTO();
                factura.setCodigo(rs.getString(1));
                ReparacionManager rm = ReparacionManager.getReparacionManager();
                ReparacionDTO reparacion = new ReparacionDTO();
                reparacion.setCodigo(rs.getString(2));
                factura.setTbReparacion(rm.getReparacion(reparacion));
                factura.setValorNeto(new BigDecimal(rs.getInt(3)));
                factura.setIva(new BigDecimal(rs.getInt(4)));
                factura.setValorTotal(new BigDecimal(rs.getInt(5)));
                result = factura;
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

    public List<FacturaDTO> getFacturas(){
            List<FacturaDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(FacturaDAOHelper.getFacturas());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<FacturaDTO>();
                while(rs.next()){
                	FacturaDTO factura = new FacturaDTO();
                    factura.setCodigo(rs.getString(1));
                    ReparacionManager rm = ReparacionManager.getReparacionManager();
                    ReparacionDTO reparacion = new ReparacionDTO();
                    reparacion.setCodigo(rs.getString(2));
                    factura.setTbReparacion(rm.getReparacion(reparacion));
                    factura.setValorNeto(new BigDecimal(rs.getInt(3)));
                    factura.setIva(new BigDecimal(rs.getInt(4)));
                    factura.setValorTotal(new BigDecimal(rs.getInt(5)));
                    result.add(factura);
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
    
    public FacturaDTO generarFactura(ReparacionDTO r){
        FacturaDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            CallableStatement sentence=con.prepareCall(FacturaDAOHelper.generarFactura());
            sentence.registerOutParameter(1, Types.VARCHAR);                            
            sentence.setString(2,r.getCodigo());                                        
            sentence.executeQuery(); 
            FacturaDTO factura = new FacturaDTO();
            factura.setCodigo(Integer.toString(sentence.getInt(1)));
            result = getFactura(factura);
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
