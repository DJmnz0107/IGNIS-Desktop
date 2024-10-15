/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class TransporteDisplay {
    
    private Transportes transportes;

    public TransporteDisplay(Transportes transportes) {
        this.transportes = transportes;
    }

    @Override
    public String toString() {
        return transportes.getPlaca_transporte(); // Mostrar el nombre completo
    }

    public Transportes getTransportes() {
        return transportes;
    }
    
    public int getId_Transporte() {
        return transportes.getId_transporte(); // Método para obtener el ID del bombero
    }
}
