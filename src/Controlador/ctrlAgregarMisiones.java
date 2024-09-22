/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Emergencias;
import Modelo.Misiones;
import Vistas.frmAgregarMision;
import Vistas.frmVerRegistroMisiones;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JOptionPane;
import raven.drawer.Drawer;

/**
 *
 * @author Diego
 */
public class ctrlAgregarMisiones implements MouseListener {
    
    private Emergencias emergencia;
    private Misiones modelo;
    private frmAgregarMision vista;
    
    public ctrlAgregarMisiones(Emergencias emergencia, Misiones modelo, frmAgregarMision vista ) {
     this.emergencia = emergencia;
    this.modelo = modelo;
    this.vista = vista;
    
    //Llenando cmbEmergencia con Emergencias
    emergencia.obtenerEmergencias(vista.cmbEmergencia); // Llenar con Emergencias
    vista.dtcEmergencia.setMaxSelectableDate(new Date());
    vista.btnAgregar.addMouseListener(this);
    vista.btnVerRegistro.addMouseListener(this);
    vista.btnMenu.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if (e.getSource() == vista.btnAgregar) {
        if (vista.txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, llena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Asegúrate de hacer el cast a Emergencias
        Emergencias emergenciaSeleccionada = (Emergencias) vista.cmbEmergencia.getSelectedItem();
        int idEmergencia = emergenciaSeleccionada.getIdEmergencia();
        modelo.setDescripcionMision(vista.txtDescripcion.getText());
        modelo.setFechaMision(vista.dtcEmergencia.getDate());
        modelo.setIdEmergencia(idEmergencia);
        modelo.insertarMision();
        JOptionPane.showMessageDialog(vista, "Misión ingresada exitosamente.");
        limpiarCampos();
    }
        if(e.getSource() == vista.btnMenu) {
            Drawer.getInstance().showDrawer();
            System.out.println("Hola");
        }
        
        if(e.getSource() == vista.btnVerRegistro) {
            frmVerRegistroMisiones.initFrmVerRegistroMisiones();
            vista.dispose();
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
