/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.caqs.dto;

/**
 *
 * @author ESTUDIANTE1220T
 */
public class ClienteDTO {
    
  
    private int idCliente;
    private String nombre;
    
    //constructor
  //  public ClienteDTO(String idCliente1,String nombre1){
  //      this.idCliente = idCliente1;
  //      this.nombre = nombre1;
  //  }
    
    public int getIdCliente() {    
        return idCliente;
    }
    
    public void setIdCliente(int idCliente1) {    
        this.idCliente = idCliente1;
    }
    public String getNombre() {    
        return nombre;
    }   
    public void setNombre(String nombre1) {    
        this.nombre = nombre1;
    }
    
}
