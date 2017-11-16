
package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.LlamadaDAO;
import co.com.caqs.dto.LlamadaDTO;
import co.com.caqs.dto.ClienteDTO;

public class DemoLlamada {

    public static void main(String arg[]) {
        
        //LlamadaDTO lla = new LlamadaDTO();
        ClienteDTO cli = new ClienteDTO();
        
        
        //insertar
        //cli.setIdCliente(2);
        //lla.setNumero("321");
        //lla.setOperador("claro");
        //lla.setClienteFk(cli);
        //modificar
        //lla.setOperador("ETB");
        //lla.setNumero(1234);
        //eliminar
        //lla.setNumero(1234);
        try {
            LlamadaDAO dao = new LlamadaDAO();
            //dao.registrar(lla);
            //dao.modificar(lla);
            //dao.eliminar(lla);
            for (LlamadaDTO lla : dao.consultar()) {
             System.out.println(lla.getNumero()+","+lla.getOperador()+","+lla.getClienteFk().getIdCliente());
            }
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
        
    }
}
