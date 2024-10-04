/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClaseConexion;
import Modelo.Usuarios;

import Vistas.frmCrearCuenta;
import Vistas.frmAgregarInventario;
import Vistas.frmAgregarTransportes;
import Vistas.frmLogin;
import java.sql.Connection;
import Vistas.frmMenu;
import Vistas.frmPrimerUso;
import Vistas.frmRecuperacionContrasena;
import Vistas.frmVerCambios;
import Vistas.frmVerRegistroAspirantes;
import Vistas.frmVerRegistroTransporter;
import modelo.EmergenciaController;


/**
 *
 * @author Diego
 */
public class Main {

    private static EmergenciaController controller; // Mueve el controlador a un campo estático

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuarios modeloUsuario = new Usuarios();

                if (!modeloUsuario.verificarUsuario()) {
                    frmPrimerUso.initFrmCrearCuenta();
                } else {
                    frmLogin.initfrmLogin();
                    Connection conexion = ClaseConexion.getConexion();

                    // Verifica si el controlador ya ha sido creado
                    if (controller == null) {
                        controller = new EmergenciaController(conexion);
                    }
                }
            }
        });
    }
}

