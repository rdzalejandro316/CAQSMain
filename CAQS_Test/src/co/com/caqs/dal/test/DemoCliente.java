package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.ClienteDAO;
import co.com.caqs.dto.ClienteDTO;

public class DemoCliente {

    public static void main(String arg[]) {
        ClienteDTO cli = new ClienteDTO();

        //insertar
        //cli.setIdCliente(10);
        //cli.setNombre("homero");
        //modificar
        //cli.setIdCliente(10);
        //cli.setNombre("raul");
        //eliminar
        cli.setIdCliente(10);

        try {
            ClienteDAO dao = new ClienteDAO();
            //dao.registrar(cli);
            //dao.modificar(cli);
            dao.eliminar(cli);
           for (ClienteDTO c : dao.consultar()) {
              System.out.println(c.getIdCliente()+","+c.getNombre());
            }
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }

    }
}
