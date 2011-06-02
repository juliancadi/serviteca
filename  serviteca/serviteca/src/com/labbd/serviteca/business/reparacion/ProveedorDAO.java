package com.labbd.serviteca.business.reparacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.services.connection.DBConnection;

public class ProveedorDAO {
	
	private static ProveedorDAO dao;

    private ProveedorDAO(){}

    public static ProveedorDAO getProveedorDAO(){
        if(dao == null){
            dao = new ProveedorDAO();
        }
        return dao;
    }
    
    public ProveedorDTO getProveedor(ProveedorDTO pr){
        ProveedorDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(ProveedorDAOHelper.getProveedor());

            p.setString(1, pr.getNit());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                ProveedorDTO proveedor = new ProveedorDTO();
                proveedor.setNit(rs.getString(1));
                proveedor.setNombreEmpresa(rs.getString(2));
                proveedor.setNombreEncargado(rs.getString(3));
                proveedor.setApellidoEncargado(rs.getString(4));
                proveedor.setTelFijo(rs.getString(5));
                proveedor.setTelMovil(rs.getString(6));
                proveedor.setEmail(rs.getString(7));
                proveedor.setDireccion(rs.getString(8));
                //proveedor.setTbRepuestos(tbRepuestos);
                result = proveedor;
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

    public List<ProveedorDTO> getProveedores(){
            List<ProveedorDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(ProveedorDAOHelper.getProveedores());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<ProveedorDTO>();
                while(rs.next()){
                	ProveedorDTO proveedor = new ProveedorDTO();
                    proveedor.setNit(rs.getString(1));
                    proveedor.setNombreEmpresa(rs.getString(2));
                    proveedor.setNombreEncargado(rs.getString(3));
                    proveedor.setApellidoEncargado(rs.getString(4));
                    proveedor.setTelFijo(rs.getString(5));
                    proveedor.setTelMovil(rs.getString(6));
                    proveedor.setEmail(rs.getString(7));
                    proveedor.setDireccion(rs.getString(8));
                    //proveedor.setTbRepuestos(tbRepuestos);
                    result.add(proveedor);
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
