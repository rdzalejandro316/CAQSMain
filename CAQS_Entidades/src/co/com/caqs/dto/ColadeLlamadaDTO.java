
package co.com.caqs.dto;


public class ColadeLlamadaDTO {

    private int idColaLlamada;
    private String nombreColaLlamada;
    private LlamadaDTO numeroFk;
    

    public int getIdColaLlamada() {
        return idColaLlamada;
    }

    public void setIdColaLlamada(int idColaLlamada1) {
        this.idColaLlamada = idColaLlamada1;
    }
    
    public String getNombreColaLlamada() {
        return nombreColaLlamada;
    }

    public void setNombreColaLlamada(String nombreColaLlamada1) {
        this.nombreColaLlamada = nombreColaLlamada1;
    }
    
    public LlamadaDTO getNumeroFk() {    
        return numeroFk;
    }
    public void setNumeroFk(LlamadaDTO numero1) {    
        this.numeroFk = numero1;
    }
    

}
