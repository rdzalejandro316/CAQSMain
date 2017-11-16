
package co.com.caqs.dto;


public class TransferenciaDTO {

    private int idTransferencia;
    public String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String correoCliente;
    private String causallamada;
    private PrioridadDTO idPrioridadFk;       // llave foranea
    private ColadeLlamadaDTO idColaLlamadaFk; // llave foranea

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int transferencia1) {
        this.idTransferencia = transferencia1;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente1) {
        this.nombreCliente = nombreCliente1;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente1) {
        this.apellidoCliente = apellidoCliente1;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente1) {
        this.direccionCliente = direccionCliente1;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente1) {
        this.correoCliente = correoCliente1;
    }

    public String getCausallamada() {
        return causallamada;
    }

    public void setCausallamada(String causallamada1) {
        this.causallamada = causallamada1;
    }

    public PrioridadDTO getIdPrioridadFk() { //metodo para devolver ID de la prioridad
        return idPrioridadFk;
    }
    
    public void setIdPrioridadFk(PrioridadDTO idPrioridad1){// metodo de FK
        this.idPrioridadFk = idPrioridad1;
    }
    
    public ColadeLlamadaDTO getIdColaLlamadaFk(){
        return idColaLlamadaFk;
    }
    
    public void setIdColaLlamadaFk(ColadeLlamadaDTO idColadeLlamada){
        this.idColaLlamadaFk = idColadeLlamada;
    }
    
}