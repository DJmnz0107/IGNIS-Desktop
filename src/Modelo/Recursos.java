/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public class Recursos {

    /**
     * @return the idRecurso
     */
    public int getIdRecurso() {
        return idRecurso;
    }

    /**
     * @param idRecurso the idRecurso to set
     */
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    /**
     * @return the nombreRecurso
     */
    public String getNombreRecurso() {
        return nombreRecurso;
    }

    /**
     * @param nombreRecurso the nombreRecurso to set
     */
    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    /**
     * @return the descripcionRecurso
     */
    public String getDescripcionRecurso() {
        return descripcionRecurso;
    }

    /**
     * @param descripcionRecurso the descripcionRecurso to set
     */
    public void setDescripcionRecurso(String descripcionRecurso) {
        this.descripcionRecurso = descripcionRecurso;
    }

    /**
     * @return the estadoRecurso
     */
    public String getEstadoRecurso() {
        return estadoRecurso;
    }

    /**
     * @param estadoRecurso the estadoRecurso to set
     */
    public void setEstadoRecurso(String estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }

    /**
     * @return the fechaRecepcionRecurso
     */
    public Date getFechaRecepcionRecurso() {
        return fechaRecepcionRecurso;
    }

    /**
     * @param fechaRecepcionRecurso the fechaRecepcionRecurso to set
     */
    public void setFechaRecepcionRecurso(Date fechaRecepcionRecurso) {
        this.fechaRecepcionRecurso = fechaRecepcionRecurso;
    }

    /**
     * @return the disponibilidadRecurso
     */
    public String getDisponibilidadRecurso() {
        return disponibilidadRecurso;
    }

    /**
     * @param disponibilidadRecurso the disponibilidadRecurso to set
     */
    public void setDisponibilidadRecurso(String disponibilidadRecurso) {
        this.disponibilidadRecurso = disponibilidadRecurso;
    }

    /**
     * @return the fotoRecurso
     */
    public String getFotoRecurso() {
        return fotoRecurso;
    }

    /**
     * @param fotoRecurso the fotoRecurso to set
     */
    public void setFotoRecurso(String fotoRecurso) {
        this.fotoRecurso = fotoRecurso;
    }
 private int idRecurso;
    private String nombreRecurso;
    private String descripcionRecurso;
    private String estadoRecurso;
    private Date fechaRecepcionRecurso; 
    private String disponibilidadRecurso;
    private String fotoRecurso;
    
    
public void insertarRecurso(String rutaImagen) {
    Connection conexion = ClaseConexion.getConexion();
    String sql = "INSERT INTO Recursos (nombre_recurso, descripcion_recurso, estado_recurso, fechaRecepcion_recurso, disponibilidad_recurso, foto_recurso) VALUES (?, ?, ?, ?, ?, ?)";

    // Ruta de la carpeta en el escritorio donde se guardarán las imágenes
    String escritorio = System.getProperty("user.home") + File.separator + "Desktop";
    String carpetaImagenes = escritorio + File.separator + "RecursosImágenes";
    File carpeta = new File(carpetaImagenes);

    // Crear la carpeta si no existe
    if (!carpeta.exists()) {
        carpeta.mkdirs();
    }

    // Nombre de la imagen que se guardará
    String nombreImagen = new File(rutaImagen).getName();
    File destinoImagen = new File(carpeta, nombreImagen);

    // Copiar la imagen a la carpeta
    try {
        Files.copy(new File(rutaImagen).toPath(), destinoImagen.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        System.out.println("Error al guardar la imagen: " + e.getMessage());
        return; // Termina el método si hay un error
    }

    // Insertar en la base de datos
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, this.nombreRecurso);  // Nombre del recurso
        stmt.setString(2, this.descripcionRecurso);  // Descripción
        stmt.setString(3, this.estadoRecurso);  // Estado

        // Fecha de recepción
        if (this.fechaRecepcionRecurso != null) {
            stmt.setDate(4, new java.sql.Date(this.fechaRecepcionRecurso.getTime()));
        } else {
            stmt.setDate(4, null); // Si es nulo, establece como nulo en la base de datos
        }

        stmt.setString(5, this.disponibilidadRecurso);  // Disponibilidad
        stmt.setString(6, destinoImagen.getAbsolutePath());  // Ruta de la imagen guardada

        stmt.executeUpdate();
        System.out.println("Recurso insertado con éxito.");
    } catch (Exception e) {
        System.out.println("Error al insertar recurso: " + e.getMessage());
    }
}

}
