package servicio_TransferEsp;

import co.com.caqs.dal.dao.ListaDAO;
import co.com.caqs.dal.dao.PrioridadDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TransferEspBL {

    public List<Integer> obtenerListaPrioridad() {

        PrioridadDAO dao = new PrioridadDAO();
        List<Integer> lis = new ArrayList();
        lis = dao.recorrerNivelPrioridad();
        HashSet hs = new HashSet();
        hs.addAll(lis);
        lis.clear();
        lis.addAll(hs);

        return lis;
    }

    public List<String> obtenerListas() throws Exception{

        ListaDAO dao = new ListaDAO();
        List<String> lista = new ArrayList();

        lista = dao.recorrer();
        HashSet hs = new HashSet();
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);
        System.out.println(lista);
        return lista;
    }

}
