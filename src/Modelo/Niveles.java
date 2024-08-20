package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class Niveles {
    private int id_nivelUsuario;
    private String nombre_nivel;

    // Constructor
    public Niveles(int id_nivelUsuario, String nombre_nivel) {
        this.id_nivelUsuario = id_nivelUsuario;
        this.nombre_nivel = nombre_nivel;
    }

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

    // Método para obtener niveles desde la base de datos y agregarlos al ComboBox
    public void obtenerNiveles(JComboBox<Niveles> comboBox) {
        Connection conexion = ClaseConexion.getConexion();
        try (PreparedStatement pstmt = conexion.prepareStatement(
            "SELECT n.id_nivelUsuario, n.nombre_nivel FROM niveles n")) {
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_nivelUsuario");
                String nombre = rs.getString("nombre_nivel");
                comboBox.addItem(new Niveles(id, nombre));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener niveles: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return nombre_nivel;
    }
}
