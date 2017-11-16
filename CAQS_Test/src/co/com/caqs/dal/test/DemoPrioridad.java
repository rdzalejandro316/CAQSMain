
package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.PrioridadDAO;
import co.com.caqs.dto.PrioridadDTO;

public class DemoPrioridad {
    
    public static void main(String arg[]) {
        
        PrioridadDTO p = new PrioridadDTO();
        
        //insertar
        //p.setIdPrioridad(44);
        //p.setNivelPrioridad(2);
        //p.setDescripcionPrioridad("nnnnn");
        //actualisacion
        //p.setDescripcionPrioridad("p");
        //p.setIdPrioridad(44);
        //eliminacion
        //p.setIdPrioridad(44);
        
        try {
            PrioridadDAO dao = new PrioridadDAO();
            //dao.registrar(p);
            //dao.modificar(p);
            //dao.eliminar(p);
            /*for (PrioridadDTO pr : dao.consultar()) {
              System.out.println(pr.getIdPrioridad()+","+pr.getNivelPrioridad()+","+pr.getDescripcionPrioridad());
            }*/
            
            
            
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }
    
}
