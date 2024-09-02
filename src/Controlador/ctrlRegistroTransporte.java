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
public class ctrlRegistroTransporte implements MouseListener {
    
    private Transportes modelo;
    private frmVerRegistroTransporter vista;


public ctrlRegistroTransporte(Transportes modelo, frmVerRegistroTransporter vista) {
    this.modelo = modelo;
    this.vista = vista;
    vista.btnActualizar.addMouseListener(this);
    modelo.Mostrar(vista.jtTransportes);
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
