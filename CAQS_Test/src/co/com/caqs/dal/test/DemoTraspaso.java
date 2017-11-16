
package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.TraspasoDAO;
import co.com.caqs.dto.TraspasoDTO;

import co.com.caqs.dto.UsuarioDTO;
import java.util.Date;

public class DemoTraspaso {
    
    public static void main(String arg[]) {
        
        Date date = new Date();
        //TraspasoDTO tp = new TraspasoDTO();
        UsuarioDTO us = new UsuarioDTO();
        
        //insertar
        //us.setIdUsuario(1);
        //tp.setIdTraspaso(2);
        //tp.setFecha(date);
        //tp.setDescripción("informe de prueba");
        //tp.setIdUsuarioFk(us);
        //modificar
        //tp.setDescripción("modificado");
        //tp.setIdTraspaso(1);
        //eliminar
        //tp.setIdTraspaso(2);
        
        try {
            TraspasoDAO dao = new TraspasoDAO();
            //dao.registrar(tp);
            //dao.modificar(tp);
            //dao.eliminar(tp);
            for (TraspasoDTO tp : dao.consultar()) {
              System.out.println(tp.getIdTraspaso()+","+tp.getFecha()+","+tp.getDescripción()+","+tp.getIdUsuarioFk().getIdUsuario());
            }
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }
}
