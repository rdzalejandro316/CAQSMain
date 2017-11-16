package co.com.caqs.dal.dao;

import co.com.caqs.dto.ColadeLlamadaDTO;
import co.com.caqs.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection connect;

    public UsuarioDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(UsuarioDTO user) throws Exception {

        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO usuario(id_usuario,tipo_de_usuario,nombre_usuario,usuario,contraseña_usuario,id_colaLLamada) values(?,?,?,?,?,?)");

            st.setInt(1, user.getIdUsuario());
            st.setString(2, user.getTipoDeUsuario());
            st.setString(3, user.getNombre());
            st.setString(4, user.getUsuario());
            st.setString(5, user.getContraseña());
            st.setInt(6, user.getIdColaLlamadaFk().getIdColaLlamada());

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }

    public void modificar(UsuarioDTO user) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE usuario SET usuario = ?,contraseña_usuario = ? WHERE id_usuario = ?");
            st.setString(1, user.getUsuario());
            st.setString(2, user.getContraseña());
            st.setInt(3, user.getIdUsuario());
            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(UsuarioDTO user) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            st.setInt(1, user.getIdUsuario());
            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<UsuarioDTO> consultar() throws Exception {
        List<UsuarioDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM usuario");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UsuarioDTO user = new UsuarioDTO();
                ColadeLlamadaDTO cll = new ColadeLlamadaDTO();

                user.setIdUsuario(rs.getInt("id_usuario"));
                user.setTipoDeUsuario(rs.getString("tipo_de_usuario"));
                user.setNombre(rs.getString("nombre_usuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setContraseña(rs.getString("contraseña_usuario"));

                cll.setIdColaLlamada(rs.getInt("id_colaLLamada"));
                user.setIdColaLlamadaFk(cll);

                lista.add(user);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public boolean consultarUsuario(String usuarioDAO, String contraseñaDAO) throws Exception {

        try {
            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM usuario WHERE usuario = ? AND contraseña_usuario = ?");

            st.setString(1, usuarioDAO);
            st.setString(2, contraseñaDAO);

            ResultSet rs = st.executeQuery();

            boolean baderaDAO;

            if (rs.next()) {
                baderaDAO = true;
            } else {

                baderaDAO = false;
            }

            rs.close();
            st.close();

            System.out.println(baderaDAO);
            return baderaDAO;

        } catch (Exception e) {
            throw e;
        }

    }

}
