
package servicio_dataToUpdate;

import co.com.caqs.dal.dao.TransferenciaDAO;


public class DataToUpdateBL {

    public void actualizarDartos(String nombre,String apellido,String direccion,String correo,int idtransfer) throws Exception{
       
        TransferenciaDAO dao = new TransferenciaDAO();
        dao.ActualizarDatos(nombre, apellido, direccion, correo, idtransfer);
    
    }
    
}
