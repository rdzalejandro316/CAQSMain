package co.com.caqs.dal.dao;

import co.com.caqs.dto.ColadeLlamadaDTO;
import co.com.caqs.dto.LlamadaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColadeLlamadaDAO {

    private Connection connect;

    public ColadeLlamadaDAO() {

        this.connect = BaseDatos.getConexion();
    }

    public void registrar(ColadeLlamadaDTO cll) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("INSERT INTO cola_llamada(id_colaLLamada,nombre_colaLlamada,numero) values(?,?,?)");

            st.setInt(1, cll.getIdColaLlamada());
            st.setString(2, cll.getNombreColaLlamada());
            st.setString(3, cll.getNumeroFk().getNumero());

            System.out.println("insercion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            connect.close();
        }

    }

    public void modificar(ColadeLlamadaDTO cll) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("UPDATE cola_llamada SET nombre_colaLlamada = ?  WHERE id_colaLLamada = ? ");

            st.setString(1, cll.getNombreColaLlamada());
            st.setInt(2, cll.getIdColaLlamada());
            System.out.println("modificacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(ColadeLlamadaDTO cll) throws Exception {
        try {

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM cola_llamada WHERE id_colaLLamada = ?");

            st.setInt(1, cll.getIdColaLlamada());

            System.out.println("eliminacion exitosa");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    ;
    
    public List<ColadeLlamadaDTO> consultar() throws Exception {
        List<ColadeLlamadaDTO> lista = null;
        try {

            PreparedStatement st = this.connect.prepareStatement("SELECT * FROM cola_llamada");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ColadeLlamadaDTO cll = new ColadeLlamadaDTO();
                LlamadaDTO lla = new LlamadaDTO();

                cll.setIdColaLlamada(rs.getInt("id_colaLLamada"));
                cll.setNombreColaLlamada(rs.getString("nombre_colaLlamada"));
                lla.setNumero(rs.getString("numero"));

                cll.setNumeroFk(lla);

                lista.add(cll);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<String> recorrer(){
        
        List<String> lista = null;

        lista = new ArrayList();
            
        ColadeLlamadaDAO dao = new ColadeLlamadaDAO();
        
        try {
            for (ColadeLlamadaDTO c : dao.consultar()) {
                lista.add(c.getNombreColaLlamada());
            }
        } catch (Exception ex) {
            Logger.getLogger(ColadeLlamadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        return lista;
    }
    
    public List<ColadeLlamadaDTO> consultarNumero(String NombreLista) throws Exception {
        List<ColadeLlamadaDTO> lista = null;
        
            try { 
            PreparedStatement st = this.connect.prepareStatement("SELECT numero FROM cola_llamada WHERE nombre_colaLlamada = ?");

            st.setString(1, NombreLista);
        
            lista = new ArrayList();
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                ColadeLlamadaDTO cll = new ColadeLlamadaDTO();
                LlamadaDTO lla = new LlamadaDTO();

                lla.setNumero(rs.getString("numero"));
                cll.setNumeroFk(lla);
                lista.add(cll);

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
            
        ColadeLlamadaDAO dao = new ColadeLlamadaDAO();
        
        try {
            for (ColadeLlamadaDTO c : dao.consultarNumero(NombreLista)) {
                System.out.println(c.getNumeroFk().getNumero());
            }
        } catch (Exception ex) {
            Logger.getLogger(ColadeLlamadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(lista);
        return lista;
    }
    
}
