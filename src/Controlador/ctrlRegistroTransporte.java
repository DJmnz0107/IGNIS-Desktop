/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Transportes;
import Modelo.Usuarios;
import Vistas.frmActualizarTransporte;
import Vistas.frmAgregarTransportes;
import Vistas.frmVerRegistroTransporter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;

/**
 *
 * @author Diego
 */
public class ctrlRegistroTransporte implements MouseListener, KeyListener {
    
    private Transportes modelo;
    private frmVerRegistroTransporter vista;
    private static EmergenciaController controller; // Mueve el controlador a un campo estático



public ctrlRegistroTransporte(frmVerRegistroTransporter vista, Transportes modelo) {
    this.modelo = modelo;
    this.vista = vista;
    modelo.Mostrar(vista.jtTransportes);
    vista.btnActualizar.addMouseListener(this);
    vista.btnEliminar.addMouseListener(this);
    vista.imgBack.addMouseListener(this);
    vista.txtBuscar.addKeyListener(this);
    
    
       Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
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
        
    if (e.getSource() == vista.btnEliminar) {
    if (vista.jtTransportes.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Object[] opciones = {"Sí", "No"}; // Opciones en español

        int respuesta = JOptionPane.showOptionDialog(
            vista, 
            "¿Estás seguro de que deseas eliminar este transporte?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            modelo.Eliminar(vista.jtTransportes);
            modelo.Mostrar(vista.jtTransportes);
            JOptionPane.showMessageDialog(vista, "Registro eliminado exitosamente");
                String nombreVehiculo = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreVehiculo);
                  
        String descripcionCambio = "Vehiculo eliminado en el sistema"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        }
    }
    
        
        
    
        
        
}

        
        if(e.getSource() == vista.imgBack) {
            frmAgregarTransportes.initFrmAgregarTransportes();
            
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == vista.txtBuscar) {
            modelo.Buscar(vista.jtTransportes, vista.txtBuscar);
        }
    }
    
}
