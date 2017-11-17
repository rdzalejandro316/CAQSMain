package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.ListaDAO;
import co.com.caqs.dto.ListaDTO;
import co.com.caqs.dto.TransferenciaDTO;
import servicio_CreateList.CreateListBL;

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
            //PreparedStatement st = this.connect.prepareStatement("SELECT transferencia.nombre_cliente, transferencia.apellido_cliente, transferencia.direccion_cliente, transferencia.correo_cliente, transferencia.causa_llamada FROM lista INNER JOIN transferencia ON lista.id_lista = transferencia.id_transferencia WHERE lista.nombre_lista = ? ");          
            //dao.recorrer2("ventas");
            //dao.recorrer2("ventas");
            
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }

    }
}
