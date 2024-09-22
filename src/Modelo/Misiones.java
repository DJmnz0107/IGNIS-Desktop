/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class Misiones {

    /**
     * @return the idMision
     */
    public int getIdMision() {
        return idMision;
    }

    /**
     * @param idMision the idMision to set
     */
    public void setIdMision(int idMision) {
        this.idMision = idMision;
    }

    /**
     * @return the descripcionMision
     */
    public String getDescripcionMision() {
        return descripcionMision;
    }

    /**
     * @param descripcionMision the descripcionMision to set
     */
    public void setDescripcionMision(String descripcionMision) {
        this.descripcionMision = descripcionMision;
    }

    /**
     * @return the fechaMision
     */
    public Date getFechaMision() {
        return fechaMision;
    }

    /**
     * @param fechaMision the fechaMision to set
     */
    public void setFechaMision(Date fechaMision) {
        this.fechaMision = fechaMision;
    }

    /**
     * @return the idEmergencia
     */
    public int getIdEmergencia() {
        return idEmergencia;
    }

    /**
     * @param idEmergencia the idEmergencia to set
     */
    public void setIdEmergencia(int idEmergencia) {
        this.idEmergencia = idEmergencia;
    }
    
    
    private int idMision;
    private String descripcionMision;
    private Date fechaMision;
    private int idEmergencia;
    
    
    public void Mostrar(JTable tabla) {
        
        Connection conexion = ClaseConexion.getConexion();
 
        
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"id","Placa", "Descripcion", "Fecha", "id Emergencia"});
 
        try {
            
            Statement statement = conexion.createStatement();
 
           
            ResultSet rs = statement.executeQuery("SELECT * FROM Misiones");
 
            
            while (rs.next()) {
                
                modeloDeDatos.addRow(new Object[]{
                    rs.getInt("id_mision"),
                    rs.getString("descripcion_mision"),
                    rs.getString("fecha_mision"),
                    rs.getInt("id_emergencia"),
                    rs.getString("tipoVehiculo_transporte"),
                    rs.getString("disponibilidad_transporte")});
            }
 
          
            tabla.setModel(modeloDeDatos);
            
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    
    //Funcion para insertar la misión
        public void insertarMision() {
    Connection conexion = ClaseConexion.getConexion();
    String sql = "INSERT INTO Misiones (descripcion_mision, fecha_mision, id_emergencia) VALUES (?, ?, ?)";


    // Insertar en la base de datos
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, this.descripcionMision);  
        stmt.setDate(2, new java.sql.Date(this.fechaMision.getTime()));
        stmt.setInt(3, this.idEmergencia); 

        stmt.executeUpdate();
        System.out.println("Mision insertada con éxito.");
    } catch (Exception e) {
        System.out.println("Error al insertar Mision: " + e.getMessage());
    }
}
    
}
