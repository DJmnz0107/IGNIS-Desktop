/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vistas.frmAgregarBomberos;
import Vistas.frmAgregarInventario;
import Vistas.frmAgregarTransportes;
import Vistas.frmLogin;
import Vistas.frmVerRegistroTransporter;
import static Vistas.frmVerRegistroTransporter.initfrmVerRegistroTransporter;

/**
 *
 * @author Diego
 */
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmVerRegistroTransporter frmLogin = new frmVerRegistroTransporter();
                frmLogin.setVisible(true);
            }
        });
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmVerRegistroTransporter();
            }
        });
    }
    
}
