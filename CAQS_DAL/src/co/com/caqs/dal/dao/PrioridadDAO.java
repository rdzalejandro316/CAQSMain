package co.com.caqs.dal.dao;

import co.com.caqs.dto.PrioridadDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrioridadDAO {

    private Connection connect;

    public PrioridadDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(PrioridadDTO pd) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO prioridad(id_prioridad,nivel_De_prioridad,descripcion_prioridad) values(?,?,?)");
            st.setInt(1, pd.getIdPrioridad());
            st.setInt(2, pd.getNivelPrioridad());
            st.setString(3, pd.getDescripcionPrioridad());
            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }
    }

    public void modificar(PrioridadDTO pd) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE prioridad SET descripcion_prioridad = ? WHERE id_prioridad = ? ");
            st.setString(1, pd.getDescripcionPrioridad());
            st.setInt(2, pd.getIdPrioridad());
            System.out.println("modificacion exitosa");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(PrioridadDTO pd) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM prioridad WHERE id_prioridad = ?");
            st.setInt(1, pd.getIdPrioridad());
            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public List<PrioridadDTO> consultar() throws Exception {
        List<PrioridadDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM prioridad");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                PrioridadDTO p = new PrioridadDTO();

                p.setIdPrioridad(rs.getInt("id_prioridad"));
                p.setNivelPrioridad(rs.getInt("nivel_De_prioridad"));
                p.setDescripcionPrioridad(rs.getString("descripcion_prioridad"));
                lista.add(p);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public List<Integer> recorrerNivelPrioridad(){
        
        List<Integer> lista;

        lista = new ArrayList();
        
        
        PrioridadDAO dao = new PrioridadDAO();
        
        try {
            for (PrioridadDTO c : dao.consultar()) {
                lista.add(c.getNivelPrioridad());
            }
        } catch (Exception ex) {
            Logger.getLogger(PrioridadDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(lista);
        return lista;
    }

}
