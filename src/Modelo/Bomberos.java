/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.frmAgregarAspirante;
import Vistas.frmAgregarBomberos;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author User
 */
public class Bomberos {
    
    public Bomberos(){
    }

   private int id_bombero;
   private String nombre_bombero;
   private String apellido_bombero;
   private String experiencia_bombero;
   private String especializacion_bombero; 
   private String foto_bombero; 
   private int id_usuario;
   private String nombre_usuario;

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
   
   
    public int getId_bombero() {
        return id_bombero;
    }

    public void setId_bombero(int id_bombero) {
        this.id_bombero = id_bombero;
    }

    public String getNombre_bombero() {
        return nombre_bombero;
    }

    public void setNombre_bombero(String nombre_bombero) {
        this.nombre_bombero = nombre_bombero;
    }

    public String getApellido_bombero() {
        return apellido_bombero;
    }

    public void setApellido_bombero(String apellido_bombero) {
        this.apellido_bombero = apellido_bombero;
    }

    public String getExperiencia_bombero() {
        return experiencia_bombero;
    }

    public void setExperiencia_bombero(String experiencia_bombero) {
        this.experiencia_bombero = experiencia_bombero;
    }

    public String getEspecializacion_bombero() {
        return especializacion_bombero;
    }

    public void setEspecializacion_bombero(String especializacion_bombero) {
        this.especializacion_bombero = especializacion_bombero;
    }

    public String getFoto_bombero() {
        return foto_bombero;
    }

    public void setFoto_bombero(String foto_bombero) {
        this.foto_bombero = foto_bombero;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
     public Bomberos (int id, String nombre)
    {
        this.id_usuario = id;
        this.nombre_usuario = nombre;
        
        
    }
     @Override
     public String toString() {
        return nombre_usuario;  
    }
    
    //metodo para obternerlos niveles de la base de datos
    public void CargarComboUsuarios(JComboBox comboBox){    
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems();
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Usuarios");
            while (rs.next()) {
                int id = rs.getInt("id_usuario"); 
                String nombre = rs.getString("nombre_usuario");
                comboBox.addItem(new Bomberos(id,nombre));   
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();  
        }
      }
    
    public void Guardar(String rutaImagen){
        //primero lo que hacemos es llamar a la clase conexion para a continuacion hacer
        //el prepared statement para insertar los datos
    Connection conexion = ClaseConexion.getConexion();
    
    
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
    
    
      try {
    
   
        PreparedStatement addAspirante = conexion.prepareStatement(
            "INSERT INTO Bomberos (nombre_bombero, apellido_bombero, experiencia_bombero, especializacion_bombero, foto_bombero, id_usuario) VALUES (?, ?, ?, ?, ?, ?)"
        );
      
        
        addAspirante.setString(1, getNombre_bombero());
        addAspirante.setString(2, getApellido_bombero());
        addAspirante.setString(3, getExperiencia_bombero());
        addAspirante.setString(4, getEspecializacion_bombero());
        addAspirante.setString(5, destinoImagen.getAbsolutePath());
        addAspirante.setInt(6, getId_usuario());
        
        addAspirante.executeUpdate();
    }
    
    catch(SQLException ex){
        System.out.println("Este es el error en el metodo Guardar: " + ex);
        }
    }
        public void Limpiar(frmAgregarBomberos Vistas){
        
        Vistas.txtNombreBombero.setText("");
        Vistas.txtApellidoBombero.setText("");
        Vistas.txtExperiencia.setText("");
        Vistas.txtEspecializacion.setText("");
        Vistas.lblFoto.setIcon(null);
        
    }
    
  
}

