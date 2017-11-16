package co.com.caqs.dal.dao;

import co.com.caqs.dto.ColadeLlamadaDTO;
import co.com.caqs.dto.ListaDTO;
import co.com.caqs.dto.LlamadaDTO;
import co.com.caqs.dto.PrioridadDTO;
import co.com.caqs.dto.TransferenciaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaDAO {

    private Connection connect;

    public ListaDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(ListaDTO ls) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO lista(id_lista,nombre_lista,id_transferencia) values(?,?,?)");

            st.setInt(1, ls.getIdLista());
            st.setString(2, ls.getNombreLista());
            st.setInt(3, ls.getIdTransferenciaFk().getIdTransferencia());

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }

    public void modificar(ListaDTO ls) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE lista SET nombre_lista = ? WHERE id_lista = ? ");
            st.setString(1, ls.getNombreLista());
            st.setInt(2, ls.getIdLista());
            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(ListaDTO ls) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM lista WHERE id_lista = ?");
            st.setInt(1, ls.getIdLista());
            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<ListaDTO> consultar() throws Exception {
        List<ListaDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM lista");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                ListaDTO ls = new ListaDTO();
                TransferenciaDTO tra = new TransferenciaDTO();
                //,id_transferencia
                ls.setIdLista(rs.getInt("id_lista"));
                ls.setNombreLista(rs.getString("nombre_lista"));

                tra.setIdTransferencia(rs.getInt("id_transferencia"));
                ls.setIdTransferenciaFk(tra);

                lista.add(ls);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<String> recorrer() {

        List<String> lista = null;

        lista = new ArrayList();

        ListaDAO dao = new ListaDAO();

        try {
            for (ListaDTO c : dao.consultar()) {
                lista.add(c.getNombreLista());
            }
        } catch (Exception ex) {
            Logger.getLogger(ColadeLlamadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public List<ListaDTO> consultarDatosLista(String NombreLista) throws Exception {
        List<ListaDTO> lista = null;

        try {
            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM lista WHERE nombre_lista = ?");

            st.setString(1, NombreLista);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                ListaDTO ls = new ListaDTO();
                TransferenciaDTO tra = new TransferenciaDTO();
                
                //lista
                ls.setIdLista(rs.getInt("id_lista"));
                
                ls.setNombreLista(rs.getString("nombre_lista"));
                
                tra.setIdTransferencia(rs.getInt("id_transferencia"));
                ls.setIdTransferenciaFk(tra);
                
                tra.setNombreCliente(rs.getString("nombre_cliente"));
                ls.setNombreClienteFK(tra);
                
                lista.add(ls);

            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }
    
    public List<String> recorrer2(String NombreLista){
        
        List<String> lista = null;

        lista = new ArrayList();
            
        ListaDAO dao = new ListaDAO();
        
        try {
            for (ListaDTO c : dao.consultarDatosLista(NombreLista)) {
                System.out.println(c.getNombreClienteFK().getNombreCliente());
            }
        } catch (Exception ex) {
            Logger.getLogger(ColadeLlamadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(lista);
        return lista;
    }
    
    public List<Integer> recorrerIdLista(){
        
        List<Integer> lista;

        lista = new ArrayList();
        
        
        ListaDAO dao = new ListaDAO();
        
        try {
            for (ListaDTO c : dao.consultar()) {
                lista.add(c.getIdLista());
            }
        } catch (Exception ex) {
            Logger.getLogger(ListaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public void registrarListaNueva(int idLista,String nombreLista,String idTransferencia) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO lista(id_lista,nombre_lista,id_transferencia) values(?,?,?)");
            
            st.setInt(1, idLista);
            st.setString(2, nombreLista);
            st.setString(3, idTransferencia);

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }
    

}
