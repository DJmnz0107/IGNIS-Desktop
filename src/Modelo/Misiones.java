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
import java.util.Date;

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
