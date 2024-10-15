/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.Emergencias;
import Modelo.Usuarios;
import Vistas.frmNotificacionEmergencia;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.EmergenciaController;

/**
 *
 * @author Diego
 */
public class ctrlNotificacion implements MouseListener {
    
    private frmNotificacionEmergencia vista;
    private Emergencias modelo;
    
    public ctrlNotificacion(frmNotificacionEmergencia vista,  Emergencias modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.lblDenegar.addMouseListener(this);
        vista.lblAyuda.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.lblDenegar) {
            
            modelo.setIdEmergencia(EmergenciaController.idEmergencia);
            modelo.setRespuestaNotificacion("Denegada");
            modelo.actualizarEstado();
            
            vista.dispose();
            
        
        String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambio = "Notificacion de ayuda denegada"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        
        
        
        }
        
        if(e.getSource() == vista.lblAyuda) {
                   modelo.setIdEmergencia(EmergenciaController.idEmergencia);
            modelo.setRespuestaNotificacion("En camino");
            modelo.actualizarEstado();
            
            vista.dispose();
            

        
        String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambio = "Notificacion de ayuda aceptada"; // Descripción del cambio
        
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
    
}
