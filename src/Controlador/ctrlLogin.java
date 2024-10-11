/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.Usuarios;
import Vistas.frmAgregarInventario;
import Vistas.frmCrearCuenta;
import Vistas.frmInicio;
import Vistas.frmLogin;
import Vistas.frmRecuperacionContrasena;
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
    public static String nombreUsuario;
    
    public ctrlLogin(Usuarios modelo, frmLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnLogin.addMouseListener(this);
        vista.lblRecuContra.addMouseListener(this);
    }
    
    @Override
public void mouseClicked(MouseEvent e) {
    if (e.getSource() == vista.btnLogin) {
        if (vista.txtUsuario.getText().isEmpty() || vista.txtContrasena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            modelo.setNombre_usuario(vista.txtUsuario.getText());
            modelo.setContrasena_usuario(vista.txtContrasena.getText());
            
            boolean usuarioValido = modelo.revisarLogin();
            
            System.out.println(Usuarios.nivelUsuario);
            
            
        
            
          if (usuarioValido) {
    modelo.obtenerNivelUsuario();
    
    // Verifica el nivel del usuario
    if (Usuarios.nivelUsuario == 1) {
        JOptionPane.showMessageDialog(vista, "Ingresa con un usuario válido", "Inicio de sesión", JOptionPane.ERROR_MESSAGE);
        return;
    } else {
        JOptionPane.showMessageDialog(vista, "Sesión iniciada con éxito", "Inicio de sesión", JOptionPane.INFORMATION_MESSAGE);
        
        vista.dispose();
        nombreUsuario = modelo.obtenerUsuario();

        
        int idUsuario = modelo.obtenerIdUsuario(nombreUsuario);
        String descripcionCambio = "Usuario " + nombreUsuario + " ha iniciado sesión"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idUsuario, descripcionCambio);
        
        
        System.out.println(Usuarios.nivelUsuario);
        
        frmInicio.initfrmInicio();
    }
} else {
    JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
}


        }
        /*POR SI QUIERE SER OCUPADO*/
        /*
        String txtCuenta = modelo.getNombre_usuario();
        
        String nombreUsuarios = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreUsuarios);
                  
        String descripcionCambio = "Cuenta de: " + txtCuenta + " Iniciada en el sistema"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        
        System.out.println("El nombre del usuario es: " + txtCuenta);
        
        */
    }
    if(e.getSource() == vista.lblRecuContra) {
                        frmRecuperacionContrasena.initfrmRecuperacionContrasena();

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
