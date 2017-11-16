
package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.TransferenciaDAO;
import co.com.caqs.dto.ColadeLlamadaDTO;
import co.com.caqs.dto.ListaDTO;
import co.com.caqs.dto.TransferenciaDTO;
import co.com.caqs.dto.PrioridadDTO;

public class DemoTransferencia {
    
    public static void main(String arg[]) {
        
        //TransferenciaDTO tr = new TransferenciaDTO();
        PrioridadDTO pr = new PrioridadDTO();
        ColadeLlamadaDTO cll = new ColadeLlamadaDTO();
        
        //insertar
        //tr.setIdTransferencia(2);
        //tr.setNombreCliente("david");
        //tr.setApellidoCliente("hurtado");
        //tr.setDireccionCliente("crr 7 cll 9");
        //tr.setCorreoCliente("jorge@gmail.com");
        //tr.setCausallamada("ventas");
        //pr.setIdPrioridad(1);
        //cll.setIdColaLlamada(1);
        //tr.setIdPrioridadFk(pr);
        //tr.setIdColaLlamadaFk(cll);
        //actualizacion
        //tr.setDireccionCliente("cll 26");
        //tr.setCorreoCliente("jorgepalmas@gmail.com");
        //tr.setIdTransferencia(1);
        //eliminar
        //tr.setIdTransferencia(1);
        
        
        try {
            TransferenciaDAO dao = new TransferenciaDAO();
            //dao.registrar(tr);
            //dao.modificar(tr);
            //dao.eliminar(tr);
                //consultar toda la tabla
            //for (TransferenciaDTO tr : dao.consultar()) {
              //System.out.println(tr.getIdTransferencia()+","+tr.getNombreCliente()+","+tr.getApellidoCliente()
                      //+","+tr.getDireccionCliente()+","+tr.getCorreoCliente()+","+tr.getCausallamada()
                      //+","+tr.getIdPrioridadFk().getIdPrioridad()+","+tr.getIdColaLlamadaFk().getIdColaLlamada());
            //}
                //consulatar numeroFk
            //for (TransferenciaDTO tr : dao.consultarNumeroFk()) {
                //System.out.println(tr.getIdColaLlamadaFk().getIdColaLlamada());
            //}
                //consulatar prioridad
            //for (PrioridadDTO p : dao.consultarNivelPrioridadFk()) {
                //System.out.println(p.getNivelPrioridad());
            //}
            //for (ListaDTO ls : dao.consultarNombreListaFk()) {
              //System.out.println(ls.getNombreLista());
            //}
            //dao.ActualizarDatos("cambio", "cambio", "cambio", "cambio",1);
            
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
        

    }
    
}
