package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.UUID;

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
    private int edad_usuario;
    private String DUI_usuario;
    private int id_nivelUsuario;
    
     public int getEdad_usuario() {
        return edad_usuario;
    }

 
    public void setEdad_usuario(int edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

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
        this.contrasena_usuario = EncryptSHA256.encriptarSHA256(contrasena_usuario);
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
    
    public boolean revisarLogin() {
        boolean login = false;
        
        Connection conexion = ClaseConexion.getConexion();
        
        try {
            PreparedStatement verificarLogin = conexion.prepareStatement("SELECT * FROM Usuarios WHERE nombre_usuario = ? AND contrasena_usuario = ?");
            
            verificarLogin.setString(1, getNombre_usuario());
            verificarLogin.setString(2, getContrasena_usuario());
            
            ResultSet rs = verificarLogin.executeQuery();
            
            login = rs.next();
            
            rs.close();
            
            verificarLogin.close();
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return login;
    }
    
    public boolean verificarUsuario() {
                boolean usuarios = false;

        Connection conexion = ClaseConexion.getConexion();
        
        try {
                PreparedStatement verificarUsuarios = conexion.prepareStatement("SELECT * FROM USUARIOS");
                
                ResultSet rs = verificarUsuarios.executeQuery();
                        
               usuarios = rs.next();
               
               
               
               rs.close();
               
               verificarUsuarios.close();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
        public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement CrearCuenta = conexion.prepareStatement("INSERT INTO USUARIOS (nombre_usuario, contrasena_usuario, edad_usuario, dui_usuario, id_nivelUsuario) VALUES (?, ?, ?, ?, ?)");

            //Establecer valores de la consulta SQL
            CrearCuenta.setString(1, getNombre_usuario());
            CrearCuenta.setString(2, getContrasena_usuario());
            CrearCuenta.setInt(3, getEdad_usuario());
            CrearCuenta.setString(4, getDUI_usuario());
            CrearCuenta.setInt(5, getId_nivelUsuario());
 
            //Ejecutar la consulta
            CrearCuenta.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
        
   
}
