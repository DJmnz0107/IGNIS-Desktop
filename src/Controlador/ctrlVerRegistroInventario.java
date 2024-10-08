/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Recursos;
import Vistas.frmActualizarInventario;
import Vistas.frmVerRegistroInventario;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ctrlVerRegistroInventario implements MouseListener, KeyListener {
    
     private Recursos modelo;
    private frmVerRegistroInventario vista;
    
    public ctrlVerRegistroInventario(Recursos modelo, frmVerRegistroInventario vista) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnEliminar.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
        vista.txtBuscar.addKeyListener(this);
        modelo.Mostrar(vista.jtInventario);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
if (e.getSource() == vista.btnEliminar) {
    if (vista.jtInventario.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Object[] opciones = {"Sí", "No"}; // Opciones en español

        int respuesta = JOptionPane.showOptionDialog(
            vista, 
            "¿Estás seguro de que deseas eliminar este registro de inventario?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            modelo.Eliminar(vista.jtInventario);
            modelo.Mostrar(vista.jtInventario);
        }
    }
}


        
     if (e.getSource() == vista.btnActualizar) {
    try {
        Recursos recursoSeleccionado = modelo.obtenerDatosTabla(vista);

        if (recursoSeleccionado != null) {
            frmActualizarInventario.initfrmActualizarInventario(recursoSeleccionado);
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una fila para actualizar.");
        }
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(vista, "Error al convertir la fecha. Por favor, verifica el formato.");
        ex.printStackTrace(); // Opcionalmente imprime la traza del error en consola
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == vista.txtBuscar) {
            modelo.Buscar(vista.jtInventario, vista.txtBuscar);
        }
    }
    
}
