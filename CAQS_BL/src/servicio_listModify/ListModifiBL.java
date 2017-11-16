package servicio_listModify;

import co.com.caqs.dal.dao.ListaDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListModifiBL {

    public List<String> obternerLista() {

        ListaDAO dao = new ListaDAO();

        List<String> lista = new ArrayList();

        lista = dao.recorrer();

        HashSet hs = new HashSet();
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);

        System.out.println("la lista-----" + lista);
        return lista;

    }
    
    public List<String> obtenerDatoslista(String nombreLista) {
        
        ListaDAO dao = new ListaDAO();
        return dao.recorrer2(nombreLista);
        
    }

}
