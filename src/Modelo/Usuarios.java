package Modelo;

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
    
}
