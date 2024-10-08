/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Emergencias;
import Vistas.frmVerEmergencias;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import raven.drawer.Drawer;

/**
 *
 * @author Diego
 */
public class ctrlVerEmergencias implements MouseListener, KeyListener {
    
    private Emergencias modelo;
    private frmVerEmergencias vista;
    
    public ctrlVerEmergencias (Emergencias modelo, frmVerEmergencias vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnEliminar.addMouseListener(this);
        vista.txtBuscarEmergencia.addKeyListener(this);
        vista.btnMenu.addMouseListener(this);
        modelo.Mostrar(vista.jtEmergencias);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      if (e.getSource() == vista.btnEliminar) {
    if (vista.jtEmergencias.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Object[] opciones = {"Sí", "No"}; // Opciones en español

        int respuesta = JOptionPane.showOptionDialog(
            vista, 
            "¿Estás seguro de que deseas eliminar esta emergencia?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            modelo.Eliminar(vista.jtEmergencias);
            modelo.Mostrar(vista.jtEmergencias);
        }
    }
}

        if(e.getSource() == vista.btnMenu) {
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == vista.txtBuscarEmergencia) {
            modelo.Buscar(vista.jtEmergencias, vista.txtBuscarEmergencia);
        }
    }
    
}
