package co.com.caqs.dal.dao;

import co.com.caqs.dto.ClienteDTO;
import co.com.caqs.dto.LlamadaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LlamadaDAO {

    private Connection connect;

    public LlamadaDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(LlamadaDTO lla) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO llamada(numero,operador,id_cliente) values(?,?,?)");

            st.setString(1, lla.getNumero());
            st.setString(2, lla.getOperador());
            st.setInt(3, lla.getClienteFk().getIdCliente());

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }

    public void modificar(LlamadaDTO lla) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE llamada SET operador = ? WHERE numero = ? ");
            st.setString(1, lla.getOperador());
            st.setString(2, lla.getNumero());
            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(LlamadaDTO lla) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM llamada WHERE numero = ?");
            st.setString(1, lla.getNumero());
            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<LlamadaDTO> consultar() throws Exception {
        List<LlamadaDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM llamada");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                LlamadaDTO lla = new LlamadaDTO();
                ClienteDTO cl = new ClienteDTO();

                //numero,operador,id_cliente
                lla.setNumero(rs.getString("numero"));
                lla.setOperador(rs.getString("operador"));

                cl.setIdCliente(rs.getInt("id_cliente"));
                lla.setClienteFk(cl);

                lista.add(lla);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
