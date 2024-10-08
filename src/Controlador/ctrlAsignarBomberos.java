/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MisionesBomberos;
import Vistas.frmAsignarMisionesBomberos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlAsignarBomberos implements MouseListener {
    private frmAsignarMisionesBomberos vista;
    private MisionesBomberos modelo;

    public ctrlAsignarBomberos(frmAsignarMisionesBomberos vista, MisionesBomberos modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnguardar.addMouseListener(this);
        this.vista.btnVerRegistros.addMouseListener(this);
    }

    private void guardarAsigMis() {
        // Obtener los valores seleccionados
        int idBombero = (int) vista.cmbBombero.getSelectedItem();
        int idMision = (int) vista.cmbMision.getSelectedItem();
        
        // Actualizar el modelo con los nuevos datos
        modelo.setId_bombero(idBombero);
        modelo.setId_mision(idMision);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnguardar) {
            guardarAsigMis();
            modelo.guardar();  // Asegúrate de que este método está implementado correctamente
            JOptionPane.showMessageDialog(vista, "Información ingresada con éxito", "Agregar transporte", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == vista.btnVerRegistros) {
            frmAsignarMisionesBomberos.initfrmAsignarMisionesBomberos();
            vista.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Puedes dejarlo vacío si no necesitas implementar lógica aquí
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Puedes dejarlo vacío si no necesitas implementar lógica aquí
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Puedes dejarlo vacío si no necesitas implementar lógica aquí
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Puedes dejarlo vacío si no necesitas implementar lógica aquí
    }
}

    




    

    

    

    
