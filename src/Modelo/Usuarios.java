package Modelo;

import Controlador.ctrlCrearCuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import static javax.swing.JOptionPane.showMessageDialog;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aless
 */
public class Usuarios {
    
    private String nombre_usuario;
    private String contrasena_usuario;
    private String edad_usuario;
    private String DUI_usuario;
    private int id_nivelUsuario;

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    public String getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(String edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public String getDUI_usuario() {
        return DUI_usuario;
    }

    public void setDUI_usuario(String DUI_usuario) {
        this.DUI_usuario = DUI_usuario;
    }

    public int getId_nivelUsuario() {
        return id_nivelUsuario;
    }

    public void setId_nivelUsuario(int id_nivelUsuario) {
        this.id_nivelUsuario = id_nivelUsuario;
    }
    
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement CrearCuenta = conexion.prepareStatement("INSERT INTO Usuarios(nombre_usuario, contrasena_usuario, edad_usuario, Dui_Usuario, id_nivelUsuario) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            CrearCuenta.setString(1, getNombre_usuario());
            CrearCuenta.setString(2, getContrasena_usuario());
            CrearCuenta.setString(3, getEdad_usuario());
            CrearCuenta.setString(4, getDUI_usuario());
            CrearCuenta.setInt(5, getId_nivelUsuario());
 
            //Ejecutar la consulta
            CrearCuenta.executeUpdate();
            showMessageDialog(null, "Cuenta creada excitosamente!");
            
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
}
