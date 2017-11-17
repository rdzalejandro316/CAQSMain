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
            //SELECT lista.id_lista, transferencia.nombre_cliente FROM lista INNER JOIN transferencia ON lista.id_lista = transferencia.id_transferencia WHERE lista.nombre_lista = "ventas" 
            //SELECT lista.id_lista, transferencia.nombre_cliente FROM lista INNER JOIN transferencia ON lista.nombre_lista = "ventas"
            PreparedStatement st = this.connect.prepareStatement("SELECT id_transferencia FROM lista WHERE nombre_lista = ?");
            st.setString(1, NombreLista);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                ListaDTO ls = new ListaDTO();
                TransferenciaDTO tra = new TransferenciaDTO();
                //,id_transferencia

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
    
    public List<TransferenciaDTO> datos(String NombreLista) throws Exception {
        List<TransferenciaDTO> lista = null;
        try {
            
            PreparedStatement st = this.connect.prepareStatement("SELECT transferencia.nombre_cliente, transferencia.apellido_cliente, transferencia.direccion_cliente, transferencia.correo_cliente, transferencia.causa_llamada FROM lista INNER JOIN transferencia ON lista.id_lista = transferencia.id_transferencia WHERE lista.nombre_lista = ? ");          
            st.setString(1, NombreLista);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                TransferenciaDTO tra = new TransferenciaDTO();
                tra.setNombreCliente(rs.getString("nombre_cliente"));
                tra.setApellidoCliente(rs.getString("apellido_cliente"));
                tra.setDireccionCliente(rs.getString("direccion_cliente"));
                tra.setCorreoCliente(rs.getString("correo_cliente"));
                tra.setCausallamada(rs.getString("causa_llamada"));
                lista.add(tra);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        
        return lista;
    }
    
    public List<String> recorrer2(String NombreLista) {

        List<String> lista = null;

        lista = new ArrayList();

        ListaDAO dao = new ListaDAO();

        try {
            for (TransferenciaDTO c : dao.datos(NombreLista)) {
                lista.add(c.getNombreCliente());
                lista.add(c.getApellidoCliente());
                lista.add(c.getDireccionCliente());
                lista.add(c.getCorreoCliente());
                lista.add(c.getCausallamada());
            }
        } catch (Exception ex) {
            Logger.getLogger(ListaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(lista.get(0)+"-------------"+lista.get(1));
        System.out.println(lista);
        return lista;
    }

    public List<Integer> recorrerIdLista() {

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

    public void registrarListaNueva(int idLista, String nombreLista, String idTransferencia) throws Exception {
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
