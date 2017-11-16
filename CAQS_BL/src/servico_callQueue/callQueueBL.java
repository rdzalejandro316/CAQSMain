package servico_callQueue;

import co.com.caqs.dal.dao.ColadeLlamadaDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class callQueueBL {

    public List<String> obtenerNombreLista() throws Exception {

        ColadeLlamadaDAO dao = new ColadeLlamadaDAO();
        
        List<String> lista = new ArrayList();

        lista = dao.recorrer();

        HashSet hs = new HashSet();
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);
        
        return lista;
    }
    
    public List<String> obtenerListaSeleccionada(String nombreLista) {
        
        ColadeLlamadaDAO dao = new ColadeLlamadaDAO();
        return dao.recorrer2(nombreLista);
        
    }

}
