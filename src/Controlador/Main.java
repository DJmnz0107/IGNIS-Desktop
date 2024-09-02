/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuarios;
import Vistas.frmAgregarBomberos;
import Vistas.frmCrearCuenta;
import Vistas.frmAgregarInventario;
import Vistas.frmAgregarTransportes;
import Vistas.frmLogin;
import Vistas.frmMenu;
import Vistas.frmPrimerUso;
import Vistas.frmRecuperacionContrasena;
import Vistas.frmVerRegistroTransporter;


/**
 *
 * @author Diego
 */
public class Main {
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Usuarios modeloUsuario = new Usuarios();
            
            if(!modeloUsuario.verificarUsuario()) {
               frmPrimerUso.initFrmCrearCuenta();
            } else {
                frmLogin.initfrmLogin();
                frmRecuperacionContrasena.initfrmRecuperacionContrasena();
            }
            
            }
        });
        
       
    }
    
}
