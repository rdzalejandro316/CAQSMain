package co.com.caqs.dal.test;

import co.com.caqs.dal.dao.ColadeLlamadaDAO;
import co.com.caqs.dto.ColadeLlamadaDTO;
import co.com.caqs.dto.LlamadaDTO;
import servico_callQueue.callQueueBL;

public class DemoColadeLlamada {

    public static void main(String arg[]) {

        ColadeLlamadaDTO cll = new ColadeLlamadaDTO();
        LlamadaDTO lla = new LlamadaDTO();

        //insercion
        //lla.setNumero("3153121497");
        //cll.setIdColaLlamada(3);
        //cll.setNombreColaLlamada("cola1");
        //cll.setNumeroFk(lla);
        //modificacion
        //cll.setNombreColaLlamada("cola111111");
        //cll.setIdColaLlamada(1);
        //elimiancion
        //cll.setIdColaLlamada(1);
        try {
            ColadeLlamadaDAO dao = new ColadeLlamadaDAO();
            //dao.registrar(cll);
            //dao.modificar(cll);
            //dao.eliminar(cll);
            //consultar toda la tabla
            //for (ColadeLlamadaDTO c : dao.consultar()) {
            //System.out.println(c.getIdColaLlamada() + ","+c.getNombreColaLlamada()+ "," + c.getNumeroFk().getNumero());
            //}
            //consultar todas las listas de colas de llamadas
            //for (ColadeLlamadaDTO c : dao.consultarNombreColaLlamada()) {
            //System.out.println(c.getNombreColaLlamada());
            //}

            //dao.recorrer();
            //dao.recorrer2("cola1");
            //callQueueBL c = new callQueueBL();
            //c.obtenerNombreLista();}
            dao.recorrer2("cola2");

        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }

    }

}
