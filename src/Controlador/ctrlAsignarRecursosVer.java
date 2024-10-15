/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClaseConexion;
import Modelo.MisionesRecursos;
import Vistas.frmActualizarMisionRecurso;
import Vistas.frmAsignarRecursos;
import Vistas.frmAsignarRecursosVer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;

/**
 *
 * @author USUARIO
 */
public class ctrlAsignarRecursosVer implements MouseListener,KeyListener{
    
    private frmAsignarRecursosVer vista;
    private MisionesRecursos modelo;
    private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    
    
    public ctrlAsignarRecursosVer(frmAsignarRecursosVer vista, MisionesRecursos modelo ){
    this.modelo = modelo;
    this.vista = vista;
    vista.txtBuscar.addKeyListener(this);
    vista.btnActualizar.addMouseListener(this);
    vista.btnEliminar.addMouseListener(this);
    vista.imgBack.addMouseListener(this);
        modelo.Mostrar(vista.jtbVerAsignarRecu);
        
        Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
    
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
              if(e.getSource()==vista.btnEliminar){
                  
                     if (vista.jtbVerAsignarRecu.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(vista, "Debes seleccionar una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Object[] opciones = {"Sí", "No"}; // Opciones en español

        int respuesta = JOptionPane.showOptionDialog(
            vista, 
            "¿Estás seguro de que deseas eliminar este aspirante?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            modelo.Eliminar(vista.jtbVerAsignarRecu);
               modelo.Mostrar(vista.jtbVerAsignarRecu);
       JOptionPane.showMessageDialog(vista, "Registro eliminado exitosamente");    
        }
           
        }
  
           
              }
              
              if(e.getSource()==vista.imgBack){
               
                  frmAsignarRecursos.initFrmAsignarRecursos();
                  vista.dispose();
                  
              }
              
              if(e.getSource() == vista.btnActualizar) {
                  
                  MisionesRecursos registroSeleccionado = modelo.obtenerDatosTabla(vista.jtbVerAsignarRecu);

        if (registroSeleccionado != null) {
            frmActualizarMisionRecurso.initFrmActulizarMisionesBomberos(registroSeleccionado);
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

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
       if(e.getSource()==vista.txtBuscar){
        modelo.Buscar(vista.jtbVerAsignarRecu, vista.txtBuscar);
       }
    }
    
}
