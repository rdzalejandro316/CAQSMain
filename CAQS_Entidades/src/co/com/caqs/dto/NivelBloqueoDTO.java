package co.com.caqs.dto;

public class NivelBloqueoDTO {
    
    
    private int idNivel;
    private String tipoDeBloqueo;
    private String descripcionBloqueo;
    
    public int getIdNivel(){
        return idNivel;
    }
    public void setIdNivel(int idNivel1){
        this.idNivel = idNivel1;
    }
    
    public String getTipoDeBloqueo(){
        return tipoDeBloqueo;
    }
    public void setTipoDeBloqueo(String tipoDeBloqueo1){
        this.tipoDeBloqueo = tipoDeBloqueo1;
    }
    
    public String getDescripcionBloqueo(){
        return descripcionBloqueo;
    }
    public void setDescripcionBloqueo(String descripcionBloqueo1){
        this.descripcionBloqueo = descripcionBloqueo1;
    }
    
}
