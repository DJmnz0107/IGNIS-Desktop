/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.BomberoDisplay;
import Modelo.MisionDisplay;
import Modelo.MisionesBomberos;
import Vistas.frmActualizarMisionBombero;
import Vistas.frmRegistroMisionesBomberos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ctrlActualizarMisionBombero implements MouseListener {
    
    private MisionesBomberos modelo;
    private frmActualizarMisionBombero vista;
    

    public ctrlActualizarMisionBombero(MisionesBomberos modelo,  frmActualizarMisionBombero vista ) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnVerRegistros.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnVerRegistros) {
            frmRegistroMisionesBomberos.initfrmRegistroMisionesBomberos();
            vista.dispose();
        }
        if(e.getSource() == vista.btnActualizar) {
                 if (vista.cmbMision.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir una misión nula, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (vista.cmbBombero.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir un bombero nulo, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    
    BomberoDisplay bomberoSeleccionado = (BomberoDisplay) vista.cmbBombero.getSelectedItem();
    MisionDisplay misionSeleccionada = (MisionDisplay) vista.cmbMision.getSelectedItem();

    if (bomberoSeleccionado != null && misionSeleccionada != null) {
        int idBomberoSeleccionado = bomberoSeleccionado.getId_bombero();
        int idMisionSeleccionada = misionSeleccionada.getIdMision(); // Asegúrate que este método esté bien implementado

        System.out.println("ID Misión (para guardar): " + idMisionSeleccionada); // Verificación
        System.out.println("ID Bombero (para guardar): " + idBomberoSeleccionado); // Verificación

        // Verifica que el ID de misión y bombero son válidos
        if (idMisionSeleccionada > 0 && idBomberoSeleccionado > 0) {
            modelo.setId_bombero(idBomberoSeleccionado);
            modelo.setId_mision(idMisionSeleccionada);
            modelo.setId_misionesbombero(vista.obtenerIdRegistro());
            

            try {
                modelo.actualizarRegistro();// Asegúrate de que este método esté implementado correctamente
                JOptionPane.showMessageDialog(vista, "Información actualizada con éxito", "Actualizar Misiones y bomberos", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace(); // Manejo de excepciones
                JOptionPane.showMessageDialog(vista, "Error al actualizar la información: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("ID Misión o Bombero no válido.");
            JOptionPane.showMessageDialog(vista, "ID Misión o Bombero no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        System.out.println("No se ha seleccionado ningún bombero o misión.");
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
