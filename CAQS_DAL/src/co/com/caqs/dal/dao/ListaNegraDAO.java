package co.com.caqs.dal.dao;

import co.com.caqs.dto.ColadeLlamadaDTO;
import co.com.caqs.dto.ListaDTO;
import co.com.caqs.dto.ListaNegraDTO;
import co.com.caqs.dto.LlamadaDTO;
import co.com.caqs.dto.NivelBloqueoDTO;
import co.com.caqs.dto.TransferenciaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaNegraDAO {

    private Connection connect;

    public ListaNegraDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(ListaNegraDTO ln) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO lista_negra(id_listaNegra,id_nivel,id_colaLLamada) values(?,?,?)");

            st.setInt(1, ln.getIdListaNegra());
            st.setInt(2, ln.getIdNivelFk().getIdNivel());
            st.setInt(3, ln.getIdColaLlamadafk().getIdColaLlamada());

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }

    public void modificar(ListaNegraDTO ln) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE lista_negra SET id_nivel = ?  WHERE id_listaNegra = ? ");

            st.setInt(1, ln.getIdNivelFk().getIdNivel());
            st.setInt(2, ln.getIdListaNegra());

            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(ListaNegraDTO ln) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM lista_negra  WHERE id_listaNegra = ?");

            st.setInt(1, ln.getIdListaNegra());

            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<ListaNegraDTO> consultar() throws Exception {
        List<ListaNegraDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM lista_negra");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ListaNegraDTO ln = new ListaNegraDTO();
                ColadeLlamadaDTO cll = new ColadeLlamadaDTO();
                NivelBloqueoDTO nb = new NivelBloqueoDTO();

                //id_listaNegra,id_nivel,id_colaLLamada
                ln.setIdListaNegra(rs.getInt("id_listaNegra"));

                cll.setIdColaLlamada(rs.getInt("id_colaLLamada"));
                nb.setIdNivel(rs.getInt("id_nivel"));
                
                ln.setIdColaLlamadafk(cll);
                ln.setIdNivelFk(nb);

                lista.add(ln);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public List<ListaNegraDTO> datos() throws Exception {
        List<ListaNegraDTO> lista = null;
        try {
            
            PreparedStatement st = this.connect.prepareStatement("SELECT cola_llamada.numero, lista_negra.id_nivel FROM cola_llamada INNER JOIN lista_negra ON lista_negra.id_listaNegra = cola_llamada.id_colaLLamada");          
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                
                ListaNegraDTO ln = new ListaNegraDTO();
                ColadeLlamadaDTO cll = new ColadeLlamadaDTO();
                NivelBloqueoDTO nb = new NivelBloqueoDTO();
                LlamadaDTO lla = new LlamadaDTO();
                
                cll.setIdColaLlamada(rs.getInt("id_colaLLamada"));   
                //ln.setIdListaNegra("")
                //id_listaNegra,id_nivel,id_colaLLamada
                ln.setIdListaNegra(rs.getInt("id_listaNegra"));

                cll.setIdColaLlamada(rs.getInt("id_colaLLamada"));
                nb.setIdNivel(rs.getInt("id_nivel"));
                
                ln.setIdColaLlamadafk(cll);
                ln.setIdNivelFk(nb);
                lista.add(ln);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        
        return lista;
    }
    
    public List<String> obtenerNumero() {
        List<String> lista = null;
        lista = new ArrayList();
        ListaNegraDAO dao = new ListaNegraDAO();
        try {
            for (ListaNegraDTO c : dao.datos()) {
                lista.add(c.getIdColaLlamadafk().getNumeroFk().getNumero());               
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ListaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("-----------"+lista);
        return lista;
    }

}
