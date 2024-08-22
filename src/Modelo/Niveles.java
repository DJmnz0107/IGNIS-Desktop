package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class Niveles {
    private int id_nivelUsuario;
    private String nombre_nivel;

    // Getters and Setters
    public String getNombre_nivel() {
        return nombre_nivel;
    }

    public void setNombre_nivel(String nombre_nivel) {
        this.nombre_nivel = nombre_nivel;
    }

    public int getId_nivelUsuario() {
        return id_nivelUsuario;
    }

    public void setId_nivelUsuario(int id_nivelUsuario) {
        this.id_nivelUsuario = id_nivelUsuario;
    }
    
    @Override
    public String toString(){
        return nombre_nivel;
    }
    

    public void obtenerNiveles(JComboBox comboBox) {
        Connection conexion = ClaseConexion.getConexion();
        try (PreparedStatement pstmt = conexion.prepareStatement(
            "SELECT * FROM niveles WHERE id_NivelUsuario > 1")) {
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               int id = rs.getInt("id_nivelUsuario");
               String nombre = rs.getString("nombre_nivel");
               
               Niveles nivelUsuario = new Niveles();
               nivelUsuario.setId_nivelUsuario(id);
               nivelUsuario.setNombre_nivel(nombre);
               
                comboBox.addItem(nivelUsuario);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener niveles: " + e.getMessage());
        }
    }
   

}
