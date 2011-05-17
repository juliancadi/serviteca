package pruebas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.labbd.serviteca.services.connection.DBConnection;

public class Prueba1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;

        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement("select * from tb_usuario");
            ResultSet rs = p.executeQuery();
            while(rs.next()){
            	System.out.println(rs.getString(1));
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
		
	}

}
