package co.com.caqs.dal.dao;

import co.com.caqs.dto.NivelBloqueoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NivelBloqueoDAO {

    private Connection connect;

    public NivelBloqueoDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(NivelBloqueoDTO nb) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO nivel_bloqueo(id_nivel,tipo_bloqueo,Descripción_bloqueo) values(?,?,?)");
            st.setInt(1, nb.getIdNivel());
            st.setString(2, nb.getTipoDeBloqueo());
            st.setString(3, nb.getDescripcionBloqueo());
            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }

    public void modificar(NivelBloqueoDTO nb) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE nivel_bloqueo SET tipo_bloqueo = ? WHERE id_nivel = ? ");
            st.setString(1, nb.getTipoDeBloqueo());
            st.setInt(2, nb.getIdNivel());
            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(NivelBloqueoDTO nb) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM nivel_bloqueo WHERE id_nivel = ?");
            st.setInt(1, nb.getIdNivel());
            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<NivelBloqueoDTO> consultar() throws Exception {
        List<NivelBloqueoDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM nivel_bloqueo");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                NivelBloqueoDTO nb = new NivelBloqueoDTO();

                nb.setIdNivel(rs.getInt("id_nivel"));
                nb.setTipoDeBloqueo(rs.getString("tipo_bloqueo"));
                nb.setDescripcionBloqueo(rs.getString("Descripción_bloqueo"));

                lista.add(nb);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
