package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.UsuarioDAO;
import co.com.caqs.dto.ColadeLlamadaDTO;
import co.com.caqs.dto.UsuarioDTO;
import java.util.List;
import servicio_login.LoginBL;

public class DemoUsuario {

    public static void main(String arg[]) {

        UsuarioDTO us = new UsuarioDTO();
        ColadeLlamadaDTO cll = new ColadeLlamadaDTO();
        //insertar
        //us.setIdUsuario(2);
        //us.setTipoDeUsuario("agente");
        //us.setNombre("oscar");
        //us.setUsuario("omar1234");
        //us.setContraseña("1234");

        //cll.setIdColaLlamada(1);
        //us.setIdColaLlamadaFk(cll);
        //actualizar
        //us.setUsuario("oscar12");
        //us.setContraseña("1234");
        //us.setIdUsuario(2);
        //eliminar
        //us.setIdUsuario(2);
        try {

            UsuarioDAO dao = new UsuarioDAO();
            
            //dao.registrar(us);
            //dao.modificar(us);
            //dao.eliminar(us);
            /*for (UsuarioDTO us : dao.consultar()) {
                System.out.println(us.getIdUsuario() + "," + us.getTipoDeUsuario() + "," + us.getNombre()
                        + "," + us.getUsuario() + "," + us.getContraseña() + "," + us.getIdColaLlamadaFk().getIdColaLlamada());
            }*/
           

            //dao.consultarUsuario("alejo","alejo123","especialista");
             //dao.listaTpoUsuario();
             LoginBL BL = new LoginBL();
             BL.obtenerNombreLista();
             
                    
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }
}
