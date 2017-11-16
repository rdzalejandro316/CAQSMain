
package co.com.caqs.dto;


public class ListaDTO {
  
    private int idLista;
    private String nombreLista;
    
    //tranferencia
    private TransferenciaDTO idTransferenciaFk;
    private TransferenciaDTO nombreCliente;
    private TransferenciaDTO apellidoCliente;
    private TransferenciaDTO direccionCliente;
    private TransferenciaDTO correoCliente;
    private TransferenciaDTO causallamada;
    private PrioridadDTO idPrioridadFk;       
    private ColadeLlamadaDTO idColaLlamadaFk; 
    
    


    public int getIdLista() {    
        return idLista;
    }
    public void setIdLista(int idLista1) {    
        this.idLista = idLista1;
    }
    
    public String getNombreLista() {    
        return nombreLista;
    }
    public void setNombreLista(String nombreLista1) {    
        this.nombreLista = nombreLista1;
    }
    
    public TransferenciaDTO getIdTransferenciaFk(){
        return idTransferenciaFk;
    }
    
    public void setIdTransferenciaFk(TransferenciaDTO idTransferencia1){
        this.idTransferenciaFk = idTransferencia1;
    }   
    
    //tranferencia

    public TransferenciaDTO getNombreClienteFK() {
        return nombreCliente;
    }

    public TransferenciaDTO getApellidoClienteFK() {
        return apellidoCliente;
    }

    public TransferenciaDTO getDireccionClienteFK() {
        return direccionCliente;
    }

    public TransferenciaDTO getCorreoClienteFK() {
        return correoCliente;
    }

    public TransferenciaDTO getCausallamadaFK() {
        return causallamada;
    }

    public PrioridadDTO getIdPrioridadFkFK() {
        return idPrioridadFk;
    }

    public ColadeLlamadaDTO getIdColaLlamadaFkFK() {
        return idColaLlamadaFk;
    }

    public void setNombreClienteFK(TransferenciaDTO nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setApellidoClienteFK(TransferenciaDTO apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public void setDireccionClienteFK(TransferenciaDTO direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public void setCorreoClienteFK(TransferenciaDTO correoCliente) {
        this.correoCliente = correoCliente;
    }

    public void setCausallamadaFK(TransferenciaDTO causallamada) {
        this.causallamada = causallamada;
    }

    public void setIdPrioridadFkFK(PrioridadDTO idPrioridadFk) {
        this.idPrioridadFk = idPrioridadFk;
    }

    public void setIdColaLlamadaFkFK(ColadeLlamadaDTO idColaLlamadaFk) {
        this.idColaLlamadaFk = idColaLlamadaFk;
    }
    
    

}
