package co.com.caqs.dal.dao;

import co.com.caqs.dto.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection connect;

    public ClienteDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(ClienteDTO clie) throws Exception {
        try {

            PreparedStatement st = connect.prepareStatement("INSERT INTO cliente(id_cliente,nombre_cliente) values(?,?)");
            st.setInt(1, clie.getIdCliente());
            st.setString(2, clie.getNombre());
            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }

    public void modificar(ClienteDTO clie) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE cliente SET nombre_cliente = ? WHERE id_cliente = ? ");
            st.setString(1, clie.getNombre());
            st.setInt(2, clie.getIdCliente());
            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(ClienteDTO clie) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
            st.setInt(1, clie.getIdCliente());
            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<ClienteDTO> consultar() throws Exception {
        List<ClienteDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM cliente");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClienteDTO clie = new ClienteDTO();
                clie.setIdCliente(rs.getInt("id_cliente"));
                clie.setNombre(rs.getString("nombre_cliente"));
                lista.add(clie);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
