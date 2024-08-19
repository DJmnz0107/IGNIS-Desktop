/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vistas.frmAgregarBomberos;
import Vistas.frmLogin;

/**
 *
 * @author Diego
 */
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLogin frmLogin = new frmLogin();
                frmLogin.setVisible(true);
            }
        });
    }
}
