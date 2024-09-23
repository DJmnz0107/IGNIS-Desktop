/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Emergencias;
import Modelo.Misiones;
import Vistas.frmActualizarMision;
import Vistas.frmVerRegistroMisiones;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import raven.drawer.Drawer;

/**
 *
 * @author Diego
 */
public class ctrlActualizarMision implements MouseListener {
            private Misiones modelo;
            private frmActualizarMision vista;

            public ctrlActualizarMision(Misiones modelo, frmActualizarMision vista ) {
                this.vista = vista;
                this.modelo = modelo;
                
               vista.btnActualizar.addMouseListener(this);
               vista.btnVerRegistro.addMouseListener(this);
               vista.btnMenu.addMouseListener(this);
            }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnActualizar) {
            
              if (vista.txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, llena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
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
