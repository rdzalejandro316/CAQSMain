
package co.com.caqs.dto;


public class tablaDTO {

    private int idColaLlamada;
    private String nombreColaLlamada;
    private String numeroFk;

    public tablaDTO(int idColaLlamada) {
        this.idColaLlamada = idColaLlamada;
        
    }
    

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
    
    public String getNumeroFk() {    
        return numeroFk;
    }
    public void setNumeroFk(String numero1) {    
        this.numeroFk = numero1;
    }
    
    
}
