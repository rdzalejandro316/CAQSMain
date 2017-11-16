
package co.com.caqs.dto;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TraspasoDTO {
    
    private int idTraspaso;
    private String fecha;
    private String descripción;
    private UsuarioDTO idUsuarioFk;
    
    
        /*public static void main(String arg[]) {

            Date date = new Date();
            //DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
            String convertido = fechaHora.format(date);
            System.out.println(convertido);
                
        }*/
    
    public int getIdTraspaso() {    
        return idTraspaso;
    }
    public void setIdTraspaso(int idTraspaso1) {    
        this.idTraspaso = idTraspaso1;
    }
    
    public String getFecha() {    
        return fecha;
    }
    public void setFecha(Date date) {    
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
        String convertido = fechaHora.format(date);
        fecha = convertido;    
    }
    
    public String getDescripción() {    
        return descripción;
    }
    public void setDescripción(String descripción1) {    
        this.descripción = descripción1;
    }
    
    public UsuarioDTO getIdUsuarioFk() {    
        return idUsuarioFk;
    }
    
    public void setIdUsuarioFk(UsuarioDTO idUsuarioFk1) {    
        this.idUsuarioFk = idUsuarioFk1;
    }
    
}
