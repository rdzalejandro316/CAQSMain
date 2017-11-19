package servicio_Consultlist;

import co.com.caqs.dal.dao.ListaDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConsultlistBL {

    public List<String> traerLista() throws Exception {

        ListaDAO dao = new ListaDAO();

        List<String> lista = new ArrayList();

        lista = dao.recorrer();

        HashSet hs = new HashSet();
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);

        
        return lista;

    }
    
    public List<String> obtenerNombreBL(String nombreLista) throws Exception {
        ListaDAO dao = new ListaDAO();
        return dao.obtenerNombre(nombreLista);
    }
    
    public List<String> obtenerApellidoBL(String nombreLista) throws Exception {
        ListaDAO dao = new ListaDAO();
        return dao.obtenerApellido(nombreLista);
    }
    
    public List<String> obtenerDirreccionBL(String nombreLista) throws Exception {
        ListaDAO dao = new ListaDAO();
        return dao.obtenerDireccion(nombreLista);
    }

    public List<String> obtenerCorreoBL(String nombreLista) throws Exception {
        ListaDAO dao = new ListaDAO();
        return dao.obtenerCorreo(nombreLista);
    }
    
    public List<String> obtenerCausaBL(String nombreLista) throws Exception {
        ListaDAO dao = new ListaDAO();
        return dao.obtenerCausaLlamada(nombreLista);
    }
    
    public List<Integer> obtenerPrioridadBL(String nombreLista) throws Exception {
        ListaDAO dao = new ListaDAO();
        return dao.obtenerPrioridad(nombreLista);
    }
    

}
