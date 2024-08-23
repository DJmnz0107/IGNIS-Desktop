package Modelo;

import Controlador.ClaseConexion;
import java.sql.*;
import javax.swing.JComboBox;


public class Transportes {
    
    private int id_transporte;
    private String placa_transporte;
    private String numero_transporte;
    private int capacidad_transporte;
    private String tipoVehiculo_transporte;
    private String disponibilidad_transporte;
    private String estado_transporte;

    public int getId_transporte() {
        return id_transporte;
    }

    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }

    public String getPlaca_transporte() {
        return placa_transporte;
    }

    public void setPlaca_transporte(String placa_transporte) {
        this.placa_transporte = placa_transporte;
    }

    public String getNumero_transporte() {
        return numero_transporte;
    }

    public void setNumero_transporte(String numero_transporte) {
        this.numero_transporte = numero_transporte;
    }

    public int getCapacidad_transporte() {
        return capacidad_transporte;
    }

    public void setCapacidad_transporte(int capacidad_transporte) {
        this.capacidad_transporte = capacidad_transporte;
    }

    public String getTipoVehiculo_transporte() {
        return tipoVehiculo_transporte;
    }

    public void setTipoVehiculo_transporte(String tipoVehiculo_transporte) {
        this.tipoVehiculo_transporte = tipoVehiculo_transporte;
    }

    public String getDisponibilidad_transporte() {
        return disponibilidad_transporte;
    }

    public void setDisponibilidad_transporte(String disponibilidad_transporte) {
        this.disponibilidad_transporte = disponibilidad_transporte;
    }

    public String getEstado_transporte() {
        return estado_transporte;
    }

    public void setEstado_transporte(String estado_transporte) {
        this.estado_transporte = estado_transporte;
    }
    
    
    public void Guardar(){
    
        Connection conexion = ClaseConexion.getConexion();
        
        try {
            PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO Transportes (id_transporte, placa_transporte, numero_transporte, capacidad_transporte, tipoVehiculo_transporte, disponibilidad_transporte, estado_transporte ) VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            addProducto.setInt(1, getId_transporte());
            addProducto.setString(2, getPlaca_transporte());
            addProducto.setString(3, getNumero_transporte());
            addProducto.setInt(4,getCapacidad_transporte() );
            addProducto.setString(5, getTipoVehiculo_transporte());
            addProducto.setString(6, getDisponibilidad_transporte());
            addProducto.setString(7, getEstado_transporte());
           
            addProducto.executeUpdate();
        } 
        
        catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar" + ex );
        }
         
    
    }

    
}
