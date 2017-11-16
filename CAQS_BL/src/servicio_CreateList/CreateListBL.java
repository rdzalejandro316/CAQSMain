package servicio_CreateList;

import co.com.caqs.dal.dao.ListaDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CreateListBL {

    public boolean rep = false;

    public boolean verificarIngreso(int idLista, String nombreLista, String idTransferencia) throws Exception {

        boolean bandera;
        ListaDAO dao = new ListaDAO();

        List<String> lista = new ArrayList();
        lista = obtenerListas();

        
        //coprobar si exista la lista 
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(nombreLista)) {
                System.out.printf("existe");
                rep = true;
            }
        }
        
            if (rep) {
                bandera = false;
            } else {
                dao.registrarListaNueva(idLista, nombreLista, idTransferencia);
                bandera = true;
            }
        
        return bandera;
    }   

    public int siguienteId() {
        ListaDAO dao = new ListaDAO();
        List<Integer> ids = new ArrayList();

        ids = dao.recorrerIdLista();
        int a = ids.get(ids.size() - 1) + 1;

        return a;
    }

    public List<String> obtenerListas() throws Exception {

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
