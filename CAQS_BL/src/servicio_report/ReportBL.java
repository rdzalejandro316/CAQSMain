
package servicio_report;

import co.com.caqs.dal.dao.InformeDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportBL {

    public String fecha;
    public String hora;
    
    public String setFecha(Date date) {    
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
        String convertido = fechaHora.format(date);
        fecha = convertido;    
        return fecha;
    }
    
    public String setHora(Date time) {
        DateFormat fechaHora = new SimpleDateFormat("HH:mm:ss");
        String convertido = fechaHora.format(time);
        hora = convertido;    
        return hora;
    }
    
    public void verificarIngreso(int idInfo,String nombreInfo,String descripcion,int idUsu) throws Exception{
        
        Date date = new Date();
        
        
        InformeDAO dao = new InformeDAO();
        
        dao.registrarInforme(idInfo, nombreInfo, setFecha(date), setHora(date), descripcion, idUsu);
    }
    
    public int SiguienteId(){
        
        InformeDAO dao = new InformeDAO();
        List<Integer> ids = new ArrayList();
        
        ids = dao.recorrerId();
        int a = ids.get(ids.size() -1)+1;
        
        return a;
    }

    
    
}
