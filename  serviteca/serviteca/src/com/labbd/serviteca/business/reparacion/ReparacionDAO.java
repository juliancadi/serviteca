package com.labbd.serviteca.business.reparacion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.labbd.serviteca.services.connection.DBConnection;

public class ReparacionDAO {
	
	private static ReparacionDAO dao;

    private ReparacionDAO(){}

    public static ReparacionDAO getReparacionDAO(){
        if(dao == null){
            dao = new ReparacionDAO();
        }
        return dao;
    }
    
    public ReparacionDTO getReparacion(ReparacionDTO r){
        ReparacionDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(ReparacionDAOHelper.getReparacion());

            p.setString(1, r.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                ReparacionDTO reparacion = new ReparacionDTO();
                reparacion.setCodigo(rs.getString(1));
                
                AutomovilManager am = AutomovilManager.getAutomovilManager();
                AutomovilDTO automovil = new AutomovilDTO();
                automovil.setCodigo(rs.getString(2));
                
                reparacion.setTbAutomovil(am.getAutomovil(automovil));
                reparacion.setFechaIngreso(new Date(rs.getDate(3).getTime()));
                reparacion.setFechaSalida(new Date(rs.getDate(4).getTime()));
                
                MecanicoManager mm = MecanicoManager.getMecanicoManager();
                MecanicoDTO mecanico = new MecanicoDTO();
                mecanico.setCedula(rs.getString(5));
                reparacion.setTbMecanico(mm.getMecanico(mecanico));
                
                EstadoManager em = EstadoManager.getEstadoManager();
                EstadoDTO estado = new EstadoDTO();
                estado.setCodigo(rs.getString(6));
                reparacion.setTbEstado(em.getEstado(estado));
                
                reparacion.setCosto(new BigDecimal(rs.getInt(7)));
                //reparacion.setTbFacturas(tbFacturas);
                //reparacion.setTbRepuestoPorRepas(respuestosporrepa);
                result = reparacion;
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

    public List<ReparacionDTO> getReparaciones(){
            List<ReparacionDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(ReparacionDAOHelper.getReparaciones());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<ReparacionDTO>();
                while(rs.next()){
                	ReparacionDTO reparacion = new ReparacionDTO();
                    reparacion.setCodigo(rs.getString(1));
                    
                    AutomovilManager am = AutomovilManager.getAutomovilManager();
                    AutomovilDTO automovil = new AutomovilDTO();
                    automovil.setCodigo(rs.getString(2));
                    
                    reparacion.setTbAutomovil(am.getAutomovil(automovil));
                    reparacion.setFechaIngreso(new Date(rs.getDate(3).getTime()));
                    reparacion.setFechaSalida(new Date(rs.getDate(4).getTime()));
                    
                    MecanicoManager mm = MecanicoManager.getMecanicoManager();
                    MecanicoDTO mecanico = new MecanicoDTO();
                    mecanico.setCedula(rs.getString(5));
                    reparacion.setTbMecanico(mm.getMecanico(mecanico));
                    
                    EstadoManager em = EstadoManager.getEstadoManager();
                    EstadoDTO estado = new EstadoDTO();
                    estado.setCodigo(rs.getString(6));
                    reparacion.setTbEstado(em.getEstado(estado));
                    
                    reparacion.setCosto(new BigDecimal(rs.getInt(7)));
                    //reparacion.setTbFacturas(tbFacturas);
                    //reparacion.setTbRepuestoPorRepas(respuestosporrepa);
                    result.add(reparacion);
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
