
package co.com.caqs.dal.test;


import co.com.caqs.dto.InformeDTO;
import co.com.caqs.dal.dao.InformeDAO;

import co.com.caqs.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import servicio_report.ReportBL;


public class DemoInforme {

    public static void main(String arg[]) {
    
        //InformeDTO in = new InformeDTO();
        UsuarioDTO us = new UsuarioDTO();
        Date date = new Date();
        
        //insercion
        //in.setIdInforme(1);
        //in.setFecha(date);
        //in.setHora(date);
        //in.setDescInforme("fuera de lo comun");
        
        //us.setIdUsuario(1);
        //in.setIdUsuarioFk(us);
        
        //modificacion
        //in.setDescInforme("se cambio");
        //in.setIdInforme(1);
        
        //elimiancion
        //in.setIdInforme(1);
        
        try {
            InformeDAO dao = new InformeDAO();
            //dao.registrar(in);
            //dao.modificar(in);
            //dao.eliminar(in);
            /*for (InformeDTO in : dao.consultar()) {
              //
              System.out.println(in.getIdInforme()+","+in.getFecha()+","+in.getHora()+","+in.getDescInforme()+","+in.getIdUsuarioFk().getIdUsuario());
            }*/
            
            
            
            //lista.get(lista.size() -1);
            
            ReportBL rep = new ReportBL();
            rep.SiguienteId();
            
            //dao.registrarInforme(rep.ultimoValor(lista),"ninguna","2014/04/22","08:12", "nada",1);
            
            
            //rep.verificarIngreso(sentencia, sentencia2);
            

        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
        
    
        
    }
    
}
