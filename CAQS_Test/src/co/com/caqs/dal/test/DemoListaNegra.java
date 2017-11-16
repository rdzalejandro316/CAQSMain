package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.ListaNegraDAO;
import co.com.caqs.dto.ListaNegraDTO;

import co.com.caqs.dto.ColadeLlamadaDTO;
import co.com.caqs.dto.NivelBloqueoDTO;

public class DemoListaNegra {
    
    public static void main(String arg[]) {
        
        
        //ListaNegraDTO ln = new ListaNegraDTO();
        
        ColadeLlamadaDTO cll = new ColadeLlamadaDTO();
        NivelBloqueoDTO nb = new NivelBloqueoDTO();
        
        //insercion
        //nb.setIdNivel(1);
        //cll.setIdColaLlamada(1);
        
        //ln.setIdListaNegra(1);
        //ln.setIdNivelFk(nb);
        //ln.setIdColaLlamadafk(cll);
        
        //modificar
        //nb.setIdNivel(2);
        //ln.setIdListaNegra(3);
        //ln.setIdNivelFk(nb);
        
        //eliminacion
        //ln.setIdListaNegra(3);
        
        try {
            ListaNegraDAO dao = new ListaNegraDAO();
            //dao.registrar(ln);
            //dao.modificar(ln);
            //dao.eliminar(ln);
            for (ListaNegraDTO ln : dao.consultar()) {
              System.out.println(ln.getIdListaNegra()+","+ln.getIdColaLlamadafk().getIdColaLlamada()+","+ln.getIdNivelFk().getIdNivel());
            }
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
        
    }
    
    
}
