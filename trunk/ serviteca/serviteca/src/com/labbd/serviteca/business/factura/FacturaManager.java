package com.labbd.serviteca.business.factura;

import java.util.List;

import com.labbd.serviteca.business.reparacion.ReparacionDTO;


public class FacturaManager {
	
	private FacturaDAO dao =  FacturaDAO.getFacturaDAO();
    private static FacturaManager manager;

    private FacturaManager(){}

    public static FacturaManager getFacturaManager(){
        if(manager == null){
           manager = new FacturaManager();
        }
       return manager;
    }

   public FacturaDTO getFactura(FacturaDTO f){
       FacturaDTO factura = dao.getFactura(f);
       return factura;
   }

   public List<FacturaDTO> getFacturas(){
       List<FacturaDTO> facturas = null;
       facturas = dao.getFacturas();
       return facturas;
	}
   
   public FacturaDTO generarFactura(ReparacionDTO r){
	   return dao.generarFactura(r);
   }

}
