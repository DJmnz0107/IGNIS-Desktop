/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MisionDisplay;
import Modelo.MisionesRecursos;
import Vistas.frmActualizarMisionRecurso;
import Vistas.frmAsignarRecursosVer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ctrlActualizarMisionRecurso implements MouseListener  {
    
    private frmActualizarMisionRecurso vista;
    private MisionesRecursos modelo;
    
    public ctrlActualizarMisionRecurso(MisionesRecursos modelo, frmActualizarMisionRecurso vista) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.imgBack.addMouseListener(this);
        vista.btnVerAsigRecu.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnActualizar) {
              if (vista.cmbMision.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir una misión nula, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (vista.cmbRecursos.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir un recurso nulo, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        MisionesRecursos idRecurso = (MisionesRecursos)vista.cmbRecursos.getSelectedItem();
    MisionDisplay misionSeleccionada = (MisionDisplay) vista.cmbMision.getSelectedItem();
    
    if (idRecurso != null && misionSeleccionada != null) {
        int idRecursoSelect = idRecurso.getId_recurso();
        int idMisionSeleccionada = misionSeleccionada.getIdMision(); // Asegúrate que este método esté bien implementado

        System.out.println("ID Misión (para guardar): " + idMisionSeleccionada); // Verificación
        System.out.println("ID Bombero (para guardar): " + idRecursoSelect); // Verificación

        // Verifica que el ID de misión y bombero son válidos
        if (idMisionSeleccionada > 0 && idRecursoSelect > 0) {
            modelo.setId_recurso(idRecursoSelect);
            modelo.setId_mision(idMisionSeleccionada);
            modelo.setId_misionRecurso(vista.obtenerIdRegistro());

            try {
                modelo.actualizarRegistro();// Asegúrate de que este método esté implementado correctamente
                JOptionPane.showMessageDialog(vista, "Información actualizada con éxito", "Agregar recurso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace(); // Manejo de excepciones
                JOptionPane.showMessageDialog(vista, "Error al actualizar la información: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("ID Misión o Recurso no válido.");
            JOptionPane.showMessageDialog(vista, "ID Misión o Recurso no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        System.out.println("No se ha seleccionado ningún recurso o misión.");
    }
        }
        
        if(e.getSource() == vista.imgBack) {
            frmAsignarRecursosVer.initFrmAsignarRecursosVer();
            vista.dispose();
        }
        
        if(e.getSource() == vista.btnVerAsigRecu) {
             frmAsignarRecursosVer.initFrmAsignarRecursosVer();
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
