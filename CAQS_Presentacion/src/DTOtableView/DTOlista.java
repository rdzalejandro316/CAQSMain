package DTOtableView;

public class DTOlista {

    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String causa;
    private int prioridad;

    public DTOlista(String nombre, String apellido, String direccion, String correo, String causa,int prioridad ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.causa = causa;
        this.prioridad = prioridad;
    }

    
    
    

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre1) {
        this.nombre = nombre1;
    }
    
    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido1) {
        this.apellido = apellido1;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCausa() {
        return causa;
    }
    
    public void setCausa(String causa) {
        this.causa = causa;
    }

    public int getPrioridad() {
        return prioridad;
    }
    
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }   
}
