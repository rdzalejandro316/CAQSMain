package co.com.caqs.dto;

public class ListaDTO {

    private int idLista;
    private String nombreLista;
    private TransferenciaDTO idTransferenciaFk;

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

    public TransferenciaDTO getIdTransferenciaFk() {
        return idTransferenciaFk;
    }

    public void setIdTransferenciaFk(TransferenciaDTO idTransferencia1) {
        this.idTransferenciaFk = idTransferencia1;
    }

}
