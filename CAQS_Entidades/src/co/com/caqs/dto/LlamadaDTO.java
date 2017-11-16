
package co.com.caqs.dto;


public class LlamadaDTO {

    private String numero;
    private String operador;
    private ClienteDTO clienteFk;
    
    
    public String getNumero() {    
        return numero;
    }
    public void setNumero(String numero1) {    
        this.numero = numero1;
    }
    
    public String getOperador() {    
        return operador;
    }
    public void setOperador(String operador1) {    
        this.operador = operador1;
    }
    
    public ClienteDTO  getClienteFk() {    
        return clienteFk;
    }
    
    public void setClienteFk(ClienteDTO idCliente1) {    
        this.clienteFk = idCliente1;
    }
    
}
