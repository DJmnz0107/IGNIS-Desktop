/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Vistas.frmAgregarAspirante;
import java.sql.*;
import javax.swing.JComboBox;

/**
 *
 * @author User
 */
public class Aspirantes {
    
    public Aspirantes(){
    }

    public int getId_aspirante() {
        return id_aspirante;
    }

    public void setId_aspirante(int id_aspirante) {
        this.id_aspirante = id_aspirante;
    }

    public String getNombre_aspirante() {
        return nombre_aspirante;
    }

    public void setNombre_aspirante(String nombre_aspirante) {
        this.nombre_aspirante = nombre_aspirante;
    }

    public String getApellido_aspirante() {
        return apellido_aspirante;
    }

    public void setApellido_aspirante(String apellido_aspirante) {
        this.apellido_aspirante = apellido_aspirante;
    }

    public String getDui_aspirante() {
        return dui_aspirante;
    }

    public void setDui_aspirante(String dui_aspirante) {
        this.dui_aspirante = dui_aspirante;
    }

    public String getEntrenamiento_aspirante() {
        return entrenamiento_aspirante;
    }

    public void setEntrenamiento_aspirante(String entrenamiento_aspirante) {
        this.entrenamiento_aspirante = entrenamiento_aspirante;
    }

    public int getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(int edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public String getProgreso_aspirante() {
        return progreso_aspirante;
    }

    public void setProgreso_aspirante(String progreso_aspirante) {
        this.progreso_aspirante = progreso_aspirante;
    }

    public String getFoto_aspirante() {
        return foto_aspirante;
    }

    public void setFoto_aspirante(String foto_aspirante) {
        this.foto_aspirante = foto_aspirante;
    }

    
    
    private int id_aspirante;
    private String nombre_aspirante;
    private String apellido_aspirante;
    private String dui_aspirante;
    private String entrenamiento_aspirante;
    private int edad_usuario;
    private String progreso_aspirante;
    private String foto_aspirante;
    private int id_bombero;
    private String nombre_bombero;

    public String getNombre_bombero() {
        return nombre_bombero;
    }
    
    public void setNombre_bombero(String nombre_bombero) {
        this.nombre_bombero = nombre_bombero;
    }

    public int getId_bombero() {
        return id_bombero;
    }

    public void setId_bombero(int id_bombero) {
        this.id_bombero = id_bombero;
    }
    
    public Aspirantes(int id, String nombre)
    {
        this.id_bombero = id;
        this.nombre_bombero = nombre;
        
        /*LA TABLA ES RELACIONADA Y NECESITO TRAER OTRO GET POR QUE NO EXISTE BOMBEROS*/
    }
    
    @Override
    public String toString() {
        return nombre_bombero;  
    }
    
    
     
    
        public void CargarComboBomberos(JComboBox comboBox){    
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems();
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Bomberos");
            while (rs.next()) {
                int id = rs.getInt("id_bombero"); 
                String nombre = rs.getString("nombre_bombero");
                comboBox.addItem(new Aspirantes(id,nombre));   
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();  
        }
      }
        
        
        
    public void Guardar(){
        //primero lo que hacemos es llamar a la clase conexion para a continuacion hacer
        //el prepared statement para insertar los datos
    Connection conexion = ClaseConexion.getConexion();
    
      try {
        // Verifica si el id_bombero existe
        PreparedStatement checkBombero = conexion.prepareStatement("SELECT * FROM Bomberos WHERE id_bombero = ?");
        checkBombero.setInt(1, getId_bombero());
        ResultSet rs = checkBombero.executeQuery();
        
        if (!rs.next()) {
            System.out.println("El id_bombero no existe: " + getId_bombero());
            return; // No se puede guardar si no existe el bombero
        }
    
   
        PreparedStatement addAspirante = conexion.prepareStatement(
            "INSERT INTO Aspirantes (nombre_aspirante, apellido_aspirante, dui_aspirante, entrenamiento_aspirante, edad_usuario, progreso_aspirante, foto_aspirante, id_bombero ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        );
      
        
        addAspirante.setString(1, getNombre_aspirante());
        addAspirante.setString(2, getApellido_aspirante());
        addAspirante.setString(3, getDui_aspirante());
        addAspirante.setString(4, getEntrenamiento_aspirante());
        addAspirante.setInt(5, getEdad_usuario());
        addAspirante.setString(6, getProgreso_aspirante());
        addAspirante.setString(7, getFoto_aspirante());
        addAspirante.setInt(8, getId_bombero());
        
        addAspirante.executeUpdate();
    }
    
    catch(SQLException ex){
        System.out.println("Este es el error en el metodo Guardar: " + ex);
        }
    }
    
    public void Limpiar(frmAgregarAspirante Vistas){
        
        Vistas.txtNombreAspirante.setText("");
        Vistas.txtApellidoAspirante.setText("");
        Vistas.txtDuiAspirante.setText("");
        Vistas.txtEdadAspirante.setText("");
        Vistas.txtEntrenamientoAspirante.setText("");
        Vistas.txtProgresoAspirante.setText("");
        Vistas.txtFoto.setText("");
        
    }
    
    
    
    
   
}
