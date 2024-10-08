/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Transportes;
import Vistas.frmActualizarTransporte;
import Vistas.frmAgregarTransportes;
import Vistas.frmVerRegistroTransporter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ctrlRegistroTransporte implements MouseListener {
    
    private Transportes modelo;
    private frmVerRegistroTransporter vista;


public ctrlRegistroTransporte(frmVerRegistroTransporter vista, Transportes modelo) {
    this.modelo = modelo;
    this.vista = vista;
    modelo.Mostrar(vista.jtTransportes);
    vista.btnActualizar.addMouseListener(this);
    vista.btnEliminar.addMouseListener(this);
    vista.imgBack.addMouseListener(this);
}    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnActualizar) {
                 Transportes transporteSeleccionado = modelo.obtenerDatosTabla(vista);

            if (transporteSeleccionado != null) {
                
                frmActualizarTransporte.initfrmActualizarTransporte(transporteSeleccionado);
                vista.dispose();
               
            } else {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione una fila para actualizar.");
            }   
        }
        
    if (e.getSource() == vista.btnEliminar) {
    if (vista.jtTransportes.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Object[] opciones = {"Sí", "No"}; // Opciones en español

        int respuesta = JOptionPane.showOptionDialog(
            vista, 
            "¿Estás seguro de que deseas eliminar este transporte?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            modelo.Eliminar(vista.jtTransportes);
            modelo.Mostrar(vista.jtTransportes);
            JOptionPane.showMessageDialog(vista, "Registro eliminado exitosamente");
        }
    }
}

        
        if(e.getSource() == vista.imgBack) {
            frmAgregarTransportes.initFrmAgregarTransportes();
            
            vista.dispose();
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
