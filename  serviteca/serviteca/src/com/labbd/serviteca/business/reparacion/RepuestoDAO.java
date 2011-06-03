package com.labbd.serviteca.business.reparacion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.services.connection.DBConnection;

public class RepuestoDAO {
	
	private static RepuestoDAO dao;

    private RepuestoDAO(){}

    public static RepuestoDAO getRepuestoDAO(){
        if(dao == null){
            dao = new RepuestoDAO();
        }
        return dao;
    }
    
    public RepuestoDTO getRepuesto(RepuestoDTO r){
        RepuestoDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(RepuestoDAOHelper.getRepuesto());

            p.setString(1, r.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                RepuestoDTO repuesto = new RepuestoDTO();
                repuesto.setCodigo(rs.getString(1));
                repuesto.setNombre(rs.getString(2));
                repuesto.setExistencias(new BigDecimal(rs.getInt(3)));

                ProveedorManager pm = ProveedorManager.getProveedorManager();
                ProveedorDTO proveedor = new ProveedorDTO();
                proveedor.setNit(rs.getString(4));
                repuesto.setTbProveedor(pm.getProveedor(proveedor));
                
                repuesto.setCostoCompra(new BigDecimal(rs.getInt(5)));
                repuesto.setMarca(rs.getString(6));
                repuesto.setDescripcion(rs.getString(7));
                //repuesto.setTbRepuestoPorRepas(tbRepuestoPorRepas)
                result = repuesto;
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

    public List<RepuestoDTO> getRepuestos(){
            List<RepuestoDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(RepuestoDAOHelper.getRepuestos());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<RepuestoDTO>();
                while(rs.next()){
                	RepuestoDTO repuesto = new RepuestoDTO();
                    repuesto.setCodigo(rs.getString(1));
                    repuesto.setNombre(rs.getString(2));
                    repuesto.setExistencias(new BigDecimal(rs.getInt(3)));

                    ProveedorManager pm = ProveedorManager.getProveedorManager();
                    ProveedorDTO proveedor = new ProveedorDTO();
                    proveedor.setNit(rs.getString(4));
                    repuesto.setTbProveedor(pm.getProveedor(proveedor));
                    
                    repuesto.setCostoCompra(new BigDecimal(rs.getInt(5)));
                    repuesto.setMarca(rs.getString(6));
                    repuesto.setDescripcion(rs.getString(7));
                    //repuesto.setTbRepuestoPorRepas(tbRepuestoPorRepas)
                    result.add(repuesto);
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
    
    public List<RepuestoDTO> getRepuestosPorReparacion(ReparacionDTO r){
        List<RepuestoDTO> result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(RepuestoDAOHelper.getRepuestosPorReparacion());
            p.setString(1, r.getCodigo());
            ResultSet rs = p.executeQuery();
            result = new ArrayList<RepuestoDTO>();
            while(rs.next()){
            	RepuestoDTO repuesto = new RepuestoDTO();
                repuesto.setCodigo(rs.getString(1));
                repuesto.setNombre(rs.getString(2));
                repuesto.setExistencias(new BigDecimal(rs.getInt(3)));

                ProveedorManager pm = ProveedorManager.getProveedorManager();
                ProveedorDTO proveedor = new ProveedorDTO();
                proveedor.setNit(rs.getString(4));
                repuesto.setTbProveedor(pm.getProveedor(proveedor));
                
                repuesto.setCostoCompra(new BigDecimal(rs.getInt(5)));
                repuesto.setMarca(rs.getString(6));
                repuesto.setDescripcion(rs.getString(7));
                //repuesto.setTbRepuestoPorRepas(tbRepuestoPorRepas)
                result.add(repuesto);
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
