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
public class PrioridadDTO {
    
    private int idPrioridad;
    private int nivelPrioridad;
    private String descripcionPrioridad;
    

    public int getIdPrioridad() {
        return idPrioridad;
    }
    public void setIdPrioridad(int idPrioridad1) {
        this.idPrioridad = idPrioridad1;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }
    public void setNivelPrioridad(int nivelPrioridad1) {
        this.nivelPrioridad = nivelPrioridad1;
    }
    
    public String getDescripcionPrioridad() {
        return descripcionPrioridad;
    }
    public void setDescripcionPrioridad(String descripcionPrioridad1) {
        this.descripcionPrioridad = descripcionPrioridad1;
    }
}
