package Controlador;

import Modelo.ClaseConexion;
import Modelo.Usuarios;
import Vistas.frmCrearCuenta;
import Vistas.frmAgregarInventario;
import Vistas.frmAgregarTransportes;
import Vistas.frmAsignarRecursos;
import Vistas.frmAsignarRecursosVer;
import Vistas.frmLogin;
import java.sql.Connection;
import Vistas.frmMenu;
import Vistas.frmPrimerUso;
import Vistas.frmRecuperacionContrasena;
import Vistas.frmSplashScreen;
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
                
                frmSplashScreen splash = new frmSplashScreen();
                
                frmSplashScreen.initFrmSplash();                
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       
                        try {
                            Thread.sleep(4000); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        splash.dispose();
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
                }).start();
            }
        });
    }
}
