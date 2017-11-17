package servicio_login;

import co.com.caqs.dal.dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LoginBL {
    
    public boolean baderaBL; 
    
    public boolean verificarUsurio(String usuario, String contraseña, String TipoUsuario) throws Exception {
        
        try {

            UsuarioDAO dao = new UsuarioDAO();
            
            
            if (dao.consultarUsuario(usuario, contraseña, TipoUsuario)) {
                System.out.println("si tiene bandera");
                baderaBL = true;
                
            }else{
                System.out.println("no tiene bandera");
                baderaBL = false;
            }
         
        }catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }        
        return baderaBL;
    }
    
   public List<String> obtenerNombreLista() throws Exception {

        UsuarioDAO dao = new UsuarioDAO();
        
        List<String> lista = new ArrayList();

        lista = dao.listaTpoUsuario();

        HashSet hs = new HashSet();
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);
        
        return lista;
    }
    
}
