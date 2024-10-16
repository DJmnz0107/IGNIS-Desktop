/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.ctrlLogin.nombreUsuario;
import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Recursos;
import Modelo.Usuarios;
import Vistas.frmActualizarInventario;
import Vistas.frmVerInventario;
import Vistas.frmVerRegistroInventario;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;

/**
 *
 * @author Diego
 */
public class ctrlVerRegistroInventario implements MouseListener, KeyListener {
    
     private Recursos modelo;
    private frmVerRegistroInventario vista;
        private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlVerRegistroInventario(Recursos modelo, frmVerRegistroInventario vista) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnEliminar.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
        vista.txtBuscar.addKeyListener(this);
        modelo.Mostrar(vista.jtInventario);
        vista.imgBack.addMouseListener(this);
        
        
        
         int nivelUsuario = Usuarios.nivelUsuario;
         
         if(nivelUsuario == 2 || nivelUsuario == 4 ) {
             vista.btnEliminar.setEnabled(false);
         }

        
           Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()== vista.imgBack){
            
            frmVerInventario.initfrmVerInventario();
            vista.dispose();
        }
        
        
        
if (e.getSource() == vista.btnEliminar) {
    
      if (!vista.btnEliminar.isEnabled()) {
            JOptionPane.showMessageDialog(vista, "No tienes permiso para eliminar en el inventario.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
        } else {
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
    
        String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambio = "Un recurso ha sido eliminado"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
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
    
        String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambio = "Un recurso a sido actualizado"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
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
