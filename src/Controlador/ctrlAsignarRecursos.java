/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.MisionDisplay;
import Modelo.MisionesRecursos;
import Modelo.Usuarios;
import Vistas.frmAgregarMision;
import Vistas.frmAsignarRecursos;
import Vistas.frmAsignarRecursosVer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;

/**
 *
 * @author USUARIO
 */
public class ctrlAsignarRecursos implements MouseListener{
        private frmAsignarRecursos vista;
      private MisionesRecursos modelo;
                                       private static EmergenciaController controller; // Mueve el controlador a un campo estático

   
    public ctrlAsignarRecursos(frmAsignarRecursos vista,MisionesRecursos modelo ){
    
       this.modelo = modelo;
       this.vista = vista;
       this.vista.btnguardar.addMouseListener(this);
       this.vista.btnVerAsigRecu.addMouseListener(this);
       this.vista.cmbMision.addMouseListener(this);
       this.modelo.CargarComboMisiones(vista.cmbMision);
       this.modelo.CargarComboRecursos(vista.cmbRecursos);
       vista.imgBack.addMouseListener(this);
       
       modelo.CargarComboMisiones(vista.cmbMision);
       modelo.CargarComboRecursos(vista.cmbRecursos);
       
         Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
       
      
       
    }
    
    
   
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.imgBack) {
            frmAgregarMision.initFrmAgregarMision();
            vista.dispose();
        }
        
        if(e.getSource()==vista.btnguardar){
        
      if (vista.cmbMision.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir una misión nula, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (vista.cmbRecursos.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir un bombero nulo, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
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

            try {
                modelo.Guardar();// Asegúrate de que este método esté implementado correctamente
                JOptionPane.showMessageDialog(vista, "Información ingresada con éxito", "Agregar transporte", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace(); // Manejo de excepciones
                JOptionPane.showMessageDialog(vista, "Error al guardar la información: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("ID Misión o Bombero no válido.");
            JOptionPane.showMessageDialog(vista, "ID Misión o Bombero no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        System.out.println("No se ha seleccionado ningún bombero o misión.");
    }
    
        String nombreTransporte = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreTransporte);
                  
        String descripcionCambio = "Se ha asignado un recurso a una mision"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        
        }
        
        
        if(e.getSource()==vista.btnVerAsigRecu){
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
