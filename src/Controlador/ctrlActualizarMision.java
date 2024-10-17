/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Emergencias;
import Modelo.Misiones;
import Modelo.Usuarios;
import Vistas.frmActualizarMision;
import Vistas.frmVerRegistroMisiones;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;
import raven.drawer.Drawer;

/**
 *
 * @author Diego
 */
public class ctrlActualizarMision implements MouseListener {
            private Misiones modelo;
            private frmActualizarMision vista;
                                  private static EmergenciaController controller; // Mueve el controlador a un campo estático

            public ctrlActualizarMision(Misiones modelo, frmActualizarMision vista ) {
                this.vista = vista;
                this.modelo = modelo;
                
               vista.btnActualizar.addMouseListener(this);
               vista.btnVerRegistro.addMouseListener(this);
               vista.btnMenu.addMouseListener(this);
                   vista.dtcEmergencia.setMaxSelectableDate(new Date());
                   
                   
                    Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
            }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnActualizar) {
            
              if (vista.txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, llena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
              
                if (vista.cmbEmergencia.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir una emergencia nula, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
              
        Misiones emergenciaSeleccionada = (Misiones) vista.cmbEmergencia.getSelectedItem();
        int idEmergencia = emergenciaSeleccionada.getIdEmergencia();
              
              modelo.setDescripcionMision(vista.txtDescripcion.getText());
              modelo.setFechaMision(vista.dtcEmergencia.getDate());
              modelo.setIdEmergencia(idEmergencia);
              modelo.setIdMision(vista.obtenerIdMision());
              modelo.actualizarMision();
               JOptionPane.showMessageDialog(vista, "Misión actualizada exitosamente.");
              limpiarCampos();
              
              

        
        String nombreMision = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreMision);
                  
        String descripcionCambio = "Mision actualizada en el sistema"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        
        
        
            
        }
        
        if(e.getSource() == vista.btnVerRegistro) {
            frmVerRegistroMisiones.initFrmVerRegistroMisiones();
            vista.dispose();
        }
        
        if(e.getSource() == vista.btnMenu) {
            Drawer.getInstance().showDrawer(); //Manda a llamar al drawer (el menú deslizable) y lo muestra
        }
    }
    
        private void limpiarCampos() {
        vista.txtDescripcion.setText("");
        vista.cmbEmergencia.setSelectedIndex(0); 
       vista.dtcEmergencia.setDate(null); 
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
