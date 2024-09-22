/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vistas.frmNotificacionEmergencia;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Diego
 */
public class ctrlNotificacion implements MouseListener {
    
    private frmNotificacionEmergencia vista;
    
    public ctrlNotificacion(frmNotificacionEmergencia vista) {
        this.vista = vista;
        
        vista.lblDenegar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.lblDenegar) {
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
