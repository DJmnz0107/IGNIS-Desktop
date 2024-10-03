/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class CambiosSistema {

    /**
     * @return the idCambioSistema
     */
    public int getIdCambioSistema() {
        return idCambioSistema;
    }

    /**
     * @param idCambioSistema the idCambioSistema to set
     */
    public void setIdCambioSistema(int idCambioSistema) {
        this.idCambioSistema = idCambioSistema;
    }

    /**
     * @return the descripcionCambio
     */
    public String getDescripcionCambio() {
        return descripcionCambio;
    }

    /**
     * @param descripcionCambio the descripcionCambio to set
     */
    public void setDescripcionCambio(String descripcionCambio) {
        this.descripcionCambio = descripcionCambio;
    }

    /**
     * @return the fechaCambio
     */
    public Date getFechaCambio() {
        return fechaCambio;
    }

    /**
     * @param fechaCambio the fechaCambio to set
     */
    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    // Constructor
    public CambiosSistema(int idCambioSistema, String descripcionCambio, Date fechaCambio, int idUsuario) {
        this.idCambioSistema = idCambioSistema;
        this.descripcionCambio = descripcionCambio;
        this.fechaCambio = fechaCambio;
        this.idUsuario = idUsuario;
    }
    
     public CambiosSistema() {

    }
    
    private int idCambioSistema;      // ID del cambio en el sistema
    private String descripcionCambio;  // Descripción del cambio
    private Date fechaCambio;          // Fecha del cambio
    private int idUsuario; 
    
    
  public void insertarCambio(int idUsuario, String descripcionCambio) {
    Connection conexion = ClaseConexion.getConexion();
    String sql = "INSERT INTO Cambios_Sistema (descripcion_cambio, fecha_cambio, id_usuario) VALUES (?, ?, ?)"; // Se eliminó id_cambioSistema ya que es autoincremental
    
    try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setString(1, descripcionCambio);
        preparedStatement.setDate(2, new java.sql.Date(new Date().getTime())); // Fecha actual
        preparedStatement.setInt(3, idUsuario); // Asegúrate de que idUsuario no sea null

        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
}

}
