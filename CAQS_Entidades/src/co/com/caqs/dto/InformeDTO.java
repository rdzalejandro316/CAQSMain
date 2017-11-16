package co.com.caqs.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class InformeDTO {
    
    
    private int idInforme;
    private String fecha;
    private String hora;
    private String descInforme;
    private UsuarioDTO idUsuarioFk;


    public int getIdInforme() {
        return idInforme;
    }
    public void setIdInforme(int idInforme1) {
        this.idInforme = idInforme1;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(Date date) {    
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
        String convertido = fechaHora.format(date);
        fecha = convertido;    
    }
    
    public String getHora() {
        return hora;
    }
    public void setHora(Date time) {
        DateFormat fechaHora = new SimpleDateFormat("HH:mm:ss");
        String convertido = fechaHora.format(time);
        hora = convertido;    
    }
    
    public String getDescInforme() {
        return descInforme;
    }
    public void setDescInforme(String descInforme1) {
        this.descInforme = descInforme1;
    }
    
    public UsuarioDTO getIdUsuarioFk() {
        return idUsuarioFk;
    }
    public void setIdUsuarioFk(UsuarioDTO idUsuarioFk1) {
        this.idUsuarioFk = idUsuarioFk1;
    }
     
}
