package servicio_login;

import co.com.caqs.dal.dao.UsuarioDAO;
import java.util.List;

public class LoginBL {
    
    public boolean baderaBL; 
    
    public boolean verificarUsurio(String usuario, String contraseña) throws Exception {
        
        try {

            UsuarioDAO dao = new UsuarioDAO();
            
            
            if (dao.consultarUsuario(usuario, contraseña)) {
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
    
}
