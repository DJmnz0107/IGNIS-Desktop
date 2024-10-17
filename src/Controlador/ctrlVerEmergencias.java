/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Emergencias;
import Modelo.Usuarios;
import Vistas.frmInicio;
import Vistas.frmVerEmergencias;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;
import raven.drawer.Drawer;

/**
 *
 * @author Diego
 */
public class ctrlVerEmergencias implements MouseListener, KeyListener {
    
    private Emergencias modelo;
    private frmVerEmergencias vista;
                                        private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlVerEmergencias (Emergencias modelo, frmVerEmergencias vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnEliminar.addMouseListener(this);
        vista.txtBuscarEmergencia.addKeyListener(this);
        vista.btnMenu.addMouseListener(this);
        modelo.Mostrar(vista.jtEmergencias);
        vista.imgBack.addMouseListener(this);
        
           Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== vista.imgBack){
        frmInicio.initfrmInicio();
        vista.dispose();
        }
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
                   JOptionPane.showMessageDialog(vista, "Emergencia eliminada exitosamente");    

            
                    String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambio = "Una emergencia ha sido eliminada del sistema"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
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
