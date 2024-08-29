package Modelo;

import Controlador.ClaseConexion;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


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
    
    public void Mostrar(JTable tabla) {
        
        Connection conexion = ClaseConexion.getConexion();
 
        
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"id_transporte", "placa_transporte", "numero_transporte", "capacidad_transporte", "tipoVehiculo_transporte","disponibilidad_transporte","estado_transporte"});
 
        try {
            
            Statement statement = conexion.createStatement();
 
           
            ResultSet rs = statement.executeQuery("SELECT * FROM Transportes");
 
            
            while (rs.next()) {
                
                modeloDeDatos.addRow(new Object[]{rs.getInt("id_transporte"),
                    rs.getString("placa_transporte"),
                    rs.getString("numero_transporte"),
                    rs.getInt("capacidad_transporte"),
                    rs.getString("tipoVehiculo_transporte"),
                    rs.getString("disponibilidad_transporte"),
                    rs.getString("estado_transporte")});
            }
 
          
            tabla.setModel(modeloDeDatos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
}
