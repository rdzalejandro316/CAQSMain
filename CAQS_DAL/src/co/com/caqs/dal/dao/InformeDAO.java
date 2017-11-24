package co.com.caqs.dal.dao;

import co.com.caqs.dto.InformeDTO;
import co.com.caqs.dto.LlamadaDTO;
import co.com.caqs.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InformeDAO {

    private Connection connect;

    public InformeDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(InformeDTO in) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO informe(id_informe,fecha_informe,hora,descripcion_informe,id_usuario) values(?,?,?,?,?)");

            st.setInt(1, in.getIdInforme());
            st.setString(2, in.getFecha());
            st.setString(3, in.getHora());
            st.setString(4, in.getDescInforme());
            st.setInt(5, in.getIdUsuarioFk().getIdUsuario());

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }


    
    
    public void registrarInforme(int idInforme,String nombreInfo,String fecha,String hora, String descripcion,int idusuario) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO informe(id_informe,nombre_informe,fecha_informe,hora,descripcion_informe,id_usuario) values(?,?,?,?,?,?)");

            st.setInt(1, idInforme);
            st.setString(2, nombreInfo);
            st.setString(3,  fecha);
            st.setString(4,  hora);
            st.setString(5, descripcion);
            st.setInt(6, idusuario);
            
            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }
    
    public List<Integer> recorrerId(){
        
        List<Integer> lista;

        lista = new ArrayList();
        
        
        InformeDAO dao = new InformeDAO();
        
        try {
            for (InformeDTO c : dao.consultar()) {
                lista.add(c.getIdInforme());
            }
        } catch (Exception ex) {
            Logger.getLogger(InformeDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(lista);
        return lista;
    }
    
    public void modificar(InformeDTO in) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE informe SET descripcion_informe = ? WHERE id_informe = ? ");

            st.setString(1, in.getDescInforme());
            st.setInt(2, in.getIdInforme());

            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(InformeDTO in) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM informe WHERE id_informe = ?");

            st.setInt(1, in.getIdInforme());

            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<InformeDTO> consultar() throws Exception {
        List<InformeDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM informe");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                InformeDTO in = new InformeDTO();
                UsuarioDTO us = new UsuarioDTO();

                in.setIdInforme(rs.getInt("id_informe"));
                in.setFecha(rs.getDate("fecha_informe"));
                in.setHora(rs.getTime("hora"));
                in.setDescInforme(rs.getString("descripcion_informe"));

                us.setIdUsuario(rs.getInt("id_usuario"));
                in.setIdUsuarioFk(us);

                lista.add(in);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
