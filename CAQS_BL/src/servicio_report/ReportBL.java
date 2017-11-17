
package servicio_report;

import co.com.caqs.dal.dao.InformeDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportBL {

    
    
    public void verificarIngreso(int idInfo,String nombreInfo,String fecha,String hora,String descripcion,int idUsu) throws Exception{
    
        InformeDAO dao = new InformeDAO();
        
        dao.registrarInforme(idInfo, nombreInfo, fecha, hora, descripcion, idUsu);
    }
    
    public int SiguienteId(){
        
        InformeDAO dao = new InformeDAO();
        List<Integer> ids = new ArrayList();
        
        ids = dao.recorrerId();
        int a = ids.get(ids.size() -1)+1;
        
        return a;
    }

    
    
}
