
package co.com.caqs.dto;


public class UsuarioDTO {

    private int idUsuario;
    private String tipoDeUsuario;
    private String nombre;
    private String usuario;
    private String contraseña;
    private ColadeLlamadaDTO idColaLlamadaFk;
    
    public int getIdUsuario() {    
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario1) {    
        this.idUsuario = idUsuario1;
    }
    
    public String getTipoDeUsuario() {    
        return tipoDeUsuario;
    }
    public void setTipoDeUsuario(String tipoDeUsuario1) {    
        this.tipoDeUsuario = tipoDeUsuario1;
    }
    
    public String getNombre() {    
        return nombre;
    }
    public void setNombre(String nombre1) {    
        this.nombre = nombre1;
    }
    public String getUsuario() {    
        return usuario;
    }
    public void setUsuario(String usuario1) {    
        this.usuario = usuario1;
    }
    public String getContraseña() {    
        return contraseña;
    }
    public void setContraseña(String contraseña1) {    
        this.contraseña = contraseña1;
    }
    
    public ColadeLlamadaDTO getIdColaLlamadaFk() {    
        return idColaLlamadaFk;
    }
    public void setIdColaLlamadaFk(ColadeLlamadaDTO idColaLlamada1) {    
        this.idColaLlamadaFk = idColaLlamada1;
    }
    
    
}
