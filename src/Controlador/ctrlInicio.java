/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClaseConexion;
import Modelo.Usuarios;
import Vistas.frmAgregarAspirante;
import Vistas.frmAgregarBomberos;
import Vistas.frmAgregarInventario;
import Vistas.frmAgregarMision;
import Vistas.frmAgregarTransportes;
import Vistas.frmCrearCuenta;
import Vistas.frmInicio;
import Vistas.frmLogin;
import Vistas.frmVerCambios;
import Vistas.frmVerEmergencias;
import Vistas.frmVerEstadisticas;
import Vistas.frmVerInformes;
import Vistas.frmVerRegistroMisiones;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;
import raven.drawer.Drawer;
import java.sql.Connection;

/**
 *
 * @author Diego
 */
public class ctrlInicio implements MouseListener {
    
    private frmInicio vista;
        private static EmergenciaController controller; // Mueve el controlador a un campo estático
    
    public ctrlInicio(frmInicio vista) {
        this.vista = vista;
        vista.btnVerCambios.addMouseListener(this);
        vista.btnCrearUsuario.addMouseListener(this);
        vista.btnCerrarSesión.addMouseListener(this);
        vista.btnEmergencias.addMouseListener(this);
        vista.btnMisiones.addMouseListener(this);
        vista.btnInventario.addMouseListener(this);
        vista.btnTransporte.addMouseListener(this);
        vista.btnMenu.addMouseListener(this);
        vista.btnSeguimiento.addMouseListener(this);
        vista.btnInformes.addMouseListener(this);
        vista.btnBomberos.addMouseListener(this);
        vista.btnEstadisticas.addMouseListener(this);
        
         // Verificar el nivel de usuario
        int nivelUsuario = Usuarios.nivelUsuario;
        
        // Desactivar botones según el nivel de usuario
        if(nivelUsuario == 2) {
            vista.btnCrearUsuario.setEnabled(false); // Desactivar botón "Crear Usuario"
            vista.btnVerCambios.setEnabled(false);    // Desactivar botón "Ver Cambios"
        } else if(nivelUsuario == 4) {
             vista.btnCrearUsuario.setEnabled(false); // Desactivar botón "Crear Usuario"
            vista.btnVerCambios.setEnabled(false);
            vista.btnEmergencias.setEnabled(false);
            vista.btnBomberos.setEnabled(false);
            vista.btnSeguimiento.setEnabled(false);
            vista.btnEstadisticas.setEnabled(false);
            vista.btnInformes.setEnabled(false);
            vista.btnMisiones.setEnabled(false);
            
        }
        
              Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }

    
    }

   @Override
public void mouseClicked(MouseEvent e) {
    // Verificación de acceso para btnVerCambios
    if (e.getSource() == vista.btnVerCambios) {
        if (!vista.btnVerCambios.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmVerCambios.initfrmVerCambios();
            vista.dispose();
        }
    }
    
    if (e.getSource() == vista.btnBomberos) {
        if (!vista.btnBomberos.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmAgregarBomberos.initfrmAgregarBomberos();
            vista.dispose();
        }
    }

    // Verificación de acceso para btnCrearUsuario
    if (e.getSource() == vista.btnCrearUsuario) {
        if (!vista.btnCrearUsuario.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmCrearCuenta.initFrmCrearCuenta();
            vista.dispose();
        }
    }

    // Verificación de acceso para btnCerrarSesión
    if (e.getSource() == vista.btnCerrarSesión) {
        if (!vista.btnCerrarSesión.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            Object[] opciones = {"Sí", "No"}; // Opciones en español
            int opcion = JOptionPane.showOptionDialog(vista, 
                    "¿Estás seguro de que deseas cerrar sesión?", 
                    "Confirmar Cierre de Sesión", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0]); 

            if (opcion == JOptionPane.YES_OPTION) {
                frmLogin.initfrmLogin();
                vista.dispose();
            }
        }
    }
    
    // Verificación de acceso para btnEmergencias
    if (e.getSource() == vista.btnEmergencias) {
        if (!vista.btnEmergencias.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmVerEmergencias.initfrmVerEmergencias();
            vista.dispose();
        }
    }

    // Verificación de acceso para btnEstadisticas
    if (e.getSource() == vista.btnEstadisticas) {
        if (!vista.btnEstadisticas.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmVerEstadisticas.InitfrmVerEstadisticas();
            vista.dispose();
        }
    }

    // Verificación de acceso para btnSeguimiento
    if (e.getSource() == vista.btnSeguimiento) {
        if (!vista.btnSeguimiento.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmAgregarAspirante.initfrmAgregarAspirante();
            vista.dispose();
        }
    }

    // Verificación de acceso para bntInformes
    if (e.getSource() == vista.btnInformes) {
        if (!vista.btnInformes.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmVerInformes.initfrmVerInformes();
            vista.dispose();
        }
    }

    // Verificación de acceso para btnMisiones
    if (e.getSource() == vista.btnMisiones) {
        if (!vista.btnMisiones.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmAgregarMision.initFrmAgregarMision();
            vista.dispose();
        }
    }

    // Verificación de acceso para btnInventario
    if (e.getSource() == vista.btnInventario) {
        if (!vista.btnInventario.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmAgregarInventario.initfrmAgregarInventario();
            vista.dispose();
        }
    }

    // Verificación de acceso para btnTransportes
    if (e.getSource() == vista.btnTransporte) {
        if (!vista.btnTransporte.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para acceder a este formulario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
            frmAgregarTransportes.initFrmAgregarTransportes();
            vista.dispose();
        }
    }

    

    // Acción para btnMenu
    if (e.getSource() == vista.btnMenu) {
        Drawer.getInstance().showDrawer();
    }
}


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
