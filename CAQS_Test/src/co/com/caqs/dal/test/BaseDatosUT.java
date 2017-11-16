
package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.BaseDatos;
import java.sql.Connection;


public class BaseDatosUT {
    
     public static void main(String arg[]){
       Connection connect;
       
       connect = BaseDatos.getConexion();
       
       
    }
}
