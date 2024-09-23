/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.modelo;
import Vistas.frmCambarContra;
import Vistas.frmLogin;
import Vistas.frmNuevaContra;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ctrlCambiarContra implements MouseListener {
    
        private frmCambarContra vista;
        private modelo modelo;

        public ctrlCambiarContra(frmCambarContra vista, modelo modelo) {
            this.vista = vista;
            this.modelo = modelo;
            
           vista.btnCambiarContra.addMouseListener(this);
            vista.imgCerrar.addMouseListener(this);
        }

    @Override
    public void mouseClicked(MouseEvent e) {
        
                    String contrasena = vista.txtPassword.getText();

        if(e.getSource() == vista.btnCambiarContra) {
             if (contrasena.length() < 8 ||
                !contrasena.matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~-].*") ||
                !contrasena.matches(".*[A-Z].*")) {
                 
                 JOptionPane.showMessageDialog(vista, "La contraseña debe contener más de 8 caracteres, al menos 1 símbolo especial y 1 letra mayúscula", "Error", JOptionPane.ERROR_MESSAGE);

        }else {
                 if(!contrasena.equals(vista.txtConfirmPassword.getText())) {
                     
                     JOptionPane.showMessageDialog(vista, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);

                 } else {
                     modelo.setNombre_usuario(ctrlRecuContrasena.verificarUsuario.getNombre_usuario());
                     modelo.setContrasena_usuario(contrasena);
                     modelo.actualizarUsuario();
                   JOptionPane.showMessageDialog(vista, "La contraseña ha sido actualizada con éxito", "Actualizar contraseña", JOptionPane.INFORMATION_MESSAGE);
                               vista.dispose();

                 }
             }
        
    }
        
        if(e.getSource() == vista.imgCerrar) {
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
