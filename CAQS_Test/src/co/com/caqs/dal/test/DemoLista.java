package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.ListaDAO;
import co.com.caqs.dto.TransferenciaDTO;
import servicio_lista.ListBL;

public class DemoLista {

    public static void main(String arg[]) {

        //ListaDTO ls = new ListaDTO(); 
        TransferenciaDTO tf = new TransferenciaDTO();

        //insercion
        //ls.setIdLista(1);
        //ls.setNombreLista("ventas");
        //tf.setIdTransferencia(1);
        //ls.setIdTransferenciaFk(tf);
        //modificacion
        //ls.setNombreLista("servicios");
        //ls.setIdLista(1);
        //eliminacion
        //ls.setIdLista(1);
        try {
            ListaDAO dao = new ListaDAO();
            //dao.registrar(ls);
            //dao.modificar(ls);
            //dao.eliminar(ls);
            //consulta de toda la entidad
            /*for (ListaDTO ls : dao.consultar()) {
                System.out.println(ls.getIdTransferenciaFk().getNombreCliente());
            }*/
            //consulta de nombre de las listas
            //dao.recorrer();
            //ConsultlistBL con = new ConsultlistBL();
            //con.traerLista();
            //dao.recorrer2("cola2");

            /*for (ListaDTO ls : dao.consultarDatosLista("cola2")) {
              System.out.println(ls.getIdLista()+","+ls.getNombreLista()+","+ls.getIdTransferenciaFk().getIdTransferencia());
            }
            //TransferEspBL bl = new TransferEspBL();
            //bl.obtenerListas();
            //dao.recorrerIdLista();
            
            //CreateListBL bl = new CreateListBL();
            //bl.siguienteId();
            //dao.registrarListaNueva(7, "prueba", null);
            //bl.obtenerListas();
            
            
            //bl.verificarIngreso(10,"jm", null);
            */
            
            //dao.obtenerNombre("ventas");
            //dao.obtenerApellido("ventas");
            //dao.obtenerDireccion("ventas");
            //dao.obtenerCorreo("ventas");
            //dao.obtenerCausaLlamada("ventas");
            //dao.obtenerPrioridad("ventas");
            
            //ListBL a = new ListBL();
            
            
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }

    }
}
