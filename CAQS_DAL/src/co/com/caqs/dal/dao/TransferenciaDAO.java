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

public class TransferenciaDAO {

    private Connection connect;

    public TransferenciaDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(TransferenciaDTO tra) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO transferencia(id_transferencia,nombre_cliente,apellido_cliente,direccion_cliente,correo_cliente,causa_llamada,id_prioridad,id_colaLLamada) values(?,?,?,?,?,?,?,?)");

            st.setInt(1, tra.getIdTransferencia());
            st.setString(2, tra.getNombreCliente());
            st.setString(3, tra.getApellidoCliente());
            st.setString(4, tra.getDireccionCliente());
            st.setString(5, tra.getCorreoCliente());
            st.setString(6, tra.getCausallamada());
            st.setInt(7, tra.getIdPrioridadFk().getIdPrioridad());
            st.setInt(8, tra.getIdColaLlamadaFk().getIdColaLlamada());

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }

    public void modificar(TransferenciaDTO tra) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE transferencia SET direccion_cliente = ?,correo_cliente = ? WHERE id_transferencia = ? ");
            st.setString(1, tra.getDireccionCliente());
            st.setString(2, tra.getCorreoCliente());
            st.setInt(3, tra.getIdTransferencia());
            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(TransferenciaDTO tra) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM transferencia WHERE id_transferencia = ?");
            st.setInt(1, tra.getIdTransferencia());
            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<TransferenciaDTO> consultar() throws Exception {
        List<TransferenciaDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM transferencia");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                TransferenciaDTO tra = new TransferenciaDTO();

                PrioridadDTO pr = new PrioridadDTO();
                ColadeLlamadaDTO cl = new ColadeLlamadaDTO();

                tra.setIdTransferencia(rs.getInt("id_transferencia"));
                tra.setNombreCliente(rs.getString("nombre_cliente"));
                tra.setApellidoCliente(rs.getString("apellido_cliente"));
                tra.setDireccionCliente(rs.getString("direccion_cliente"));
                tra.setCorreoCliente(rs.getString("correo_cliente"));
                tra.setCausallamada(rs.getString("causa_llamada"));

                pr.setIdPrioridad(rs.getInt("id_prioridad"));
                cl.setIdColaLlamada(rs.getInt("id_colaLLamada"));

                tra.setIdPrioridadFk(pr);
                tra.setIdColaLlamadaFk(cl);

                lista.add(tra);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    //-----------------arreglar---------------
    public List<TransferenciaDTO> consultarNumeroFk() throws Exception {
        List<TransferenciaDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM transferencia");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                TransferenciaDTO tra = new TransferenciaDTO();
                ColadeLlamadaDTO cl = new ColadeLlamadaDTO();
                LlamadaDTO lla = new LlamadaDTO();

                //lla.setNumero(rs.getString("numero"));
                //cl.setNumeroFk(lla);
                cl.setIdColaLlamada(rs.getInt("id_colaLLamada"));

                tra.setIdColaLlamadaFk(cl);
                lista.add(tra);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<PrioridadDTO> consultarNivelPrioridadFk() throws Exception {
        List<PrioridadDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM prioridad");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                PrioridadDTO p = new PrioridadDTO();

                p.setNivelPrioridad(rs.getInt("nivel_De_prioridad"));

                lista.add(p);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<ListaDTO> consultarNombreListaFk() throws Exception {
        List<ListaDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM lista");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                ListaDTO ls = new ListaDTO();

                ls.setNombreLista(rs.getString("nombre_lista"));

                lista.add(ls);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public void ActualizarDatos(String nombre,String apellido,String direccion,String correo,int idtransfer) throws Exception {
        try {
            PreparedStatement st = this.connect.prepareStatement("UPDATE transferencia SET nombre_cliente = ?, apellido_cliente = ?, direccion_cliente = ?, correo_cliente = ? WHERE id_transferencia = ? ");
            st.setString(1, nombre);
            st.setString(2, apellido);
            st.setString(3, direccion);
            st.setString(4, correo);
            st.setInt(5, idtransfer);
            
            System.out.println("actualizacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }
    
     public void transferir(int id, String nombre, String apellido, String direccion, String correo, String causa ,int prioridad, int idCola) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO transferencia(id_transferencia,nombre_cliente,apellido_cliente,direccion_cliente,correo_cliente,causa_llamada,id_prioridad,id_colaLLamada) values(?,?,?,?,?,?,?,?)");

            st.setInt(1, id);
            st.setString(2, nombre);
            st.setString(3, apellido);
            st.setString(4, direccion);
            st.setString(5, correo);
            st.setString(6, causa);
            st.setInt(7, prioridad);
            st.setInt(8, idCola);

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }
    
}
