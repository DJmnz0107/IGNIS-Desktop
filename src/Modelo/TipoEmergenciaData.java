/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Diego
 */
public class TipoEmergenciaData {
    
     private String tipoEmergencia;
    private int cantidadMisiones;
    
    
    public TipoEmergenciaData(String tipoEmergencia, int cantidadMisiones) {
        this.tipoEmergencia = tipoEmergencia;
        this.cantidadMisiones = cantidadMisiones;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public int getCantidadMisiones() {
        return cantidadMisiones;
    }


    
}
