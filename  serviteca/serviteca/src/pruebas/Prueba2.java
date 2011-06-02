package pruebas;

import com.labbd.serviteca.business.factura.FacturaDTO;
import com.labbd.serviteca.business.factura.FacturaManager;
import com.labbd.serviteca.business.reparacion.ReparacionDTO;


public class Prueba2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
        try{
        	FacturaManager fm = FacturaManager.getFacturaManager();
    		ReparacionDTO reparacion= new ReparacionDTO();
    		reparacion.setCodigo("3");
    		FacturaDTO ff = fm.generarFactura(reparacion);
    		System.out.println(ff.getCodigo());
    		System.out.println(ff.getTbReparacion().getCodigo());
    		System.out.println(ff.getValorNeto());
    		System.out.println(ff.getIva());
    		System.out.println(ff.getValorTotal());
        }
        catch(Exception ex){
                ex.printStackTrace();
        }

	}

}
