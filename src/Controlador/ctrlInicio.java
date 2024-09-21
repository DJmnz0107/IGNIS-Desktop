/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vistas.frmCrearCuenta;
import Vistas.frmInicio;
import Vistas.frmLogin;
import Vistas.frmVerEmergencias;
import Vistas.frmVerRegistroMisiones;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ctrlInicio implements MouseListener {
    
    private frmInicio vista;
    
    public ctrlInicio(frmInicio vista) {
        this.vista = vista;
        
        vista.btnCrearUsuario.addMouseListener(this);
        vista.btnCerrarSesión.addMouseListener(this);
        vista.btnEmergencias.addMouseListener(this);
        vista.btnMisiones.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnEmergencias) {
            frmVerEmergencias.initfrmVerEmergencias();
            vista.dispose();
        }
        
        if(e.getSource() == vista.btnCrearUsuario) {
            frmCrearCuenta.initFrmCrearCuenta();
            vista.dispose();
        }
    if (e.getSource() == vista.btnCerrarSesión) {
        int opcion = JOptionPane.showConfirmDialog(vista, 
                "¿Estás seguro de que deseas cerrar sesión?", 
                "Confirmar Cierre de Sesión", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            frmLogin.initfrmLogin();
            vista.dispose();
        } 
    }
    if(e.getSource() == vista.btnMisiones) {
        frmVerRegistroMisiones.initFrmVerRegistroMisiones();
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
