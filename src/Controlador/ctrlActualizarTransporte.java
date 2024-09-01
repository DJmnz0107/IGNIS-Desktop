/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Transportes;
import Vistas.frmActualizarTransporte;
import Vistas.frmVerRegistroTransporter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ctrlActualizarTransporte implements MouseListener {
        private Transportes modelo;
    private frmActualizarTransporte vista;
    
    public ctrlActualizarTransporte(Transportes modelo, frmActualizarTransporte vista) {
    this.modelo = modelo;
    this.vista = vista;
    vista.btnActualizar.addMouseListener(this);
    vista.imgVolver.addMouseListener(this);
}    

   @Override
public void mouseClicked(MouseEvent e) {
    if (e.getSource() == vista.imgVolver) {
        frmVerRegistroTransporter frmRegistro = frmVerRegistroTransporter.getInstance(); 
        if (frmRegistro != null) {
            modelo.Mostrar(frmRegistro.jtTransportes); // Actualiza la tabla
            frmVerRegistroTransporter.initFrmVerRegistroTransportes();
        }
        vista.dispose();
    }

    if (e.getSource() == vista.btnActualizar) {
        if (vista.txtCapacidad.getText().isEmpty() || vista.txtEstado.getText().isEmpty() || vista.txtNumeroTransporte.getText().isEmpty() || vista.txtPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay campos vacíos
        }
        String tipoVehiculo = vista.cmbAgregarTransportes.getSelectedItem().toString();
        String disponibilidad = vista.cmbDisponibilidad.getSelectedItem().toString();
        
        modelo.setPlaca_transporte(vista.txtPlaca.getText());
        modelo.setCapacidad_transporte(Integer.parseInt(vista.txtCapacidad.getText()));
        modelo.setDisponibilidad_transporte(disponibilidad);
        modelo.setEstado_transporte(vista.txtEstado.getText());
        modelo.setNumero_transporte(vista.txtNumeroTransporte.getText());
        modelo.setTipoVehiculo_transporte(tipoVehiculo);
        modelo.setId_transporte(vista.obtenerIdTransporte());
        modelo.actualizarTransportes();
        
        // Limpiar campos
        vista.txtCapacidad.setText("");
        vista.txtEstado.setText("");
        vista.txtNumeroTransporte.setText("");
        vista.txtPlaca.setText("");
        
        JOptionPane.showMessageDialog(vista, "Información actualizada con éxito", "Actualizar transporte", JOptionPane.OK_OPTION);
        
        // Volver a cargar la tabla en frmVerRegistroTransportes
        frmVerRegistroTransporter frmRegistro = frmVerRegistroTransporter.getInstance(); // Obtén la instancia actual
        if (frmRegistro != null) {
            modelo.Mostrar(frmRegistro.jtTransportes); // Actualiza la tabla
        }
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
