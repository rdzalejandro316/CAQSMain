package co.com.caqs.dal.test;

import co.com.caqs.dto.NivelBloqueoDTO;
import co.com.caqs.dal.dao.NivelBloqueoDAO;

public class DemoNivelBloqueo {

    public static void main(String arg[]) {

        //NivelBloqueoDTO nb = new NivelBloqueoDTO();

        //insertar
        //nb.setIdNivel(3);
        //nb.setTipoDeBloqueo("3");
        //nb.setDescripcionBloqueo("medio");
        //actualisacion
        //nb.setTipoDeBloqueo("1");
        //nb.setIdNivel(1);
        //eliminacion
        //nb.setIdNivel(1);
        
        try {
            NivelBloqueoDAO dao = new NivelBloqueoDAO();
            //dao.registrar(nb);
            //dao.modificar(nb);
            //dao.eliminar(nb);
            for (NivelBloqueoDTO n : dao.consultar()) {
              System.out.println(n.getIdNivel()+","+n.getTipoDeBloqueo()+","+n.getDescripcionBloqueo());
            }
           
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }

    }

}
