package co.com.caqs.dto;


public class ListaNegraDTO {
 
    private int idListaNegra;
    private NivelBloqueoDTO idNivelFk;
    private ColadeLlamadaDTO idColaLlamadafk;
    
    public int getIdListaNegra(){
        return idListaNegra;
    }
    public void setIdListaNegra(int idListaNegra1){
        this.idListaNegra = idListaNegra1;
    }
    
    public NivelBloqueoDTO getIdNivelFk(){
        return idNivelFk;
    }
    public void setIdNivelFk(NivelBloqueoDTO idNivel1){
        this.idNivelFk = idNivel1;
    }
    
    public ColadeLlamadaDTO getIdColaLlamadafk() {    
        return idColaLlamadafk;
    }
    public void setIdColaLlamadafk(ColadeLlamadaDTO idColaLlamada1) {    
        this.idColaLlamadafk = idColaLlamada1;
    }
}
