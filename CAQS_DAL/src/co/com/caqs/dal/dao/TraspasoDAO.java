package co.com.caqs.dal.dao;

import co.com.caqs.dto.TraspasoDTO;
import co.com.caqs.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TraspasoDAO {

    private Connection connect;

    public TraspasoDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(TraspasoDTO tp) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO traspaso(id_traspaso,fecha_traspaso,descripcion_traspaso,id_usuario) values(?,?,?,?)");

            st.setInt(1, tp.getIdTraspaso());
            st.setString(2, tp.getFecha());
            st.setString(3, tp.getDescripción());
            st.setInt(4, tp.getIdUsuarioFk().getIdUsuario());

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }

    public void modificar(TraspasoDTO tp) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE traspaso SET descripcion_traspaso = ? WHERE id_traspaso = ? ");

            st.setString(1, tp.getDescripción());
            st.setInt(2, tp.getIdTraspaso());

            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(TraspasoDTO tp) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM traspaso WHERE id_traspaso = ?");

            st.setInt(1, tp.getIdTraspaso());

            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<TraspasoDTO> consultar() throws Exception {
        List<TraspasoDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM traspaso");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TraspasoDTO tp = new TraspasoDTO();
                UsuarioDTO us = new UsuarioDTO();
                //,,,id_usuario
                tp.setIdTraspaso(rs.getInt("id_traspaso"));
                tp.setFecha(rs.getDate("fecha_traspaso"));
                tp.setDescripción(rs.getString("descripcion_traspaso"));

                us.setIdUsuario(rs.getInt("id_traspaso"));

                tp.setIdUsuarioFk(us);
                lista.add(tp);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
