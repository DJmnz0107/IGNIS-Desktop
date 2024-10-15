    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Controlador;

import Modelo.CambioSistema;
import Modelo.EncryptSHA256;
    import Modelo.Usuarios;
import Vistas.frmLogin;
    import Vistas.frmPrimerUso;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
    import javax.swing.JOptionPane;

    /**
     *
     * @author Diego
     */
    public class ctrlPrimerUso implements MouseListener {

        private Usuarios modelo;
        private EncryptSHA256 encriptacion;
        private frmPrimerUso vista;

        public ctrlPrimerUso(Usuarios modelo, frmPrimerUso vista) {
             this.modelo = modelo;
            this.vista  = vista;
            this.encriptacion = encriptacion;
            
            vista.btnCrearPrimerCuenta.addMouseListener(this);



            
        }
        
        // Método para reiniciar la ventana
private void reiniciarVentana() {
 vista.dispose();
 frmLogin.initfrmLogin();
}
        
         @Override
    public void mouseClicked(MouseEvent e) {
           if (e.getSource() == vista.btnCrearPrimerCuenta) {
    if (vista.txtNombreUsuarioPrimer.getText().isEmpty() ||
        vista.txtContrasenaPrimerUso.getText().isEmpty() ||
        vista.txtEdadPrimer.getText().isEmpty() ||
        vista.txtDUIPrimer.getText().isEmpty()) {

        JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String contrasena = vista.txtContrasenaPrimerUso.getText();
        String edadtxt = vista.txtEdadPrimer.getText();
        String dui = vista.txtDUIPrimer.getText();

        if (contrasena.length() < 8 ||
            !contrasena.matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~-].*") ||
            !contrasena.matches(".*[A-Z].*")) {

            JOptionPane.showMessageDialog(vista, "La contraseña debe contener más de 8 caracteres, al menos 1 símbolo especial y 1 letra mayúscula", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (edadtxt.length() >= 3) {
            JOptionPane.showMessageDialog(vista, "Ingrese una edad válida", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (dui.length() != 10) {
            JOptionPane.showMessageDialog(vista, "El formato de DUI no es válido", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                int edad = Integer.parseInt(edadtxt);
               
                 if (edad <= 18) {
                    JOptionPane.showMessageDialog(vista, "Debes ser mayor de 18 años para crear una cuenta", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                modelo.setNombre_usuario(vista.txtNombreUsuarioPrimer.getText());
                modelo.setContrasena_usuario(contrasena);
                modelo.setEdad_usuario(edad);
                modelo.setDUI_usuario(dui);
                modelo.setId_nivelUsuario(3);
                modelo.Guardar();

                // Limpiar campos
                vista.txtNombreUsuarioPrimer.setText("");
                vista.txtContrasenaPrimerUso.setText("");
                vista.txtEdadPrimer.setText("");
                vista.txtDUIPrimer.setText("");

                JOptionPane.showMessageDialog(vista, "Cuenta creada con éxito", "Creación de cuenta", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(vista, "La aplicación abrirá el formulario de login para que inicies sesión", "Próximo paso", JOptionPane.WARNING_MESSAGE);

                reiniciarVentana();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } 
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
