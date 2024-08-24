/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuarios;
import Vistas.frmAgregarInventario;
import Vistas.frmCrearCuenta;
import Vistas.frmLogin;
import Vistas.frmVerRegistroTransporter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Diego
 */
public class ctrlLogin implements MouseListener {

    private Usuarios modelo;
    private frmLogin vista;
    
    public ctrlLogin(Usuarios modelo, frmLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnLogin.addMouseListener(this);
    }
    
    public void mostrarAgregarInventario() {
    SwingUtilities.invokeLater(() -> {
        frmAgregarInventario frame = new frmAgregarInventario();
        frame.setVisible(true);
    });
}
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.btnLogin) {
                        if (vista.txtUsuario.getText().isEmpty() ||
                vista.txtContrasena.getText().isEmpty())
                                {
                
                JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                            modelo.setNombre_usuario(vista.txtUsuario.getText());
                            modelo.setContrasena_usuario(vista.txtContrasena.getText());
                            
                            boolean usuarioValido = modelo.revisarLogin();
                            
                            if(usuarioValido) {
                                      JOptionPane.showMessageDialog(vista, 
                              "Sesión iniciada con éxito", 
                              "Inicio de sesión", 
                              JOptionPane.INFORMATION_MESSAGE);
                                      
                                      vista.dispose();
                                      
                                      frmCrearCuenta.initFrmCrearCuenta();
                                      
                                      
                            } else {
                                       JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            
                      
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
    
}
