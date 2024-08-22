    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Controlador;

import Modelo.EncryptSHA256;
    import Modelo.Usuarios;
    import Vistas.frmPrimerUso;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;
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
        
         @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnCrearPrimerCuenta) {

            if (vista.txtNombreUsuarioPrimer.getText().isEmpty() ||
                vista.txtContrasenaPrimerUso.getText().isEmpty() ||
                vista.txtEdadPrimer.getText().isEmpty() ||
                vista.txtDUIPrimer.getText().isEmpty()) {
                
                JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int edad = Integer.parseInt(vista.txtEdadPrimer.getText());
                    String contrasenaEncriptada = "";
                    modelo.setNombre_usuario(vista.txtNombreUsuarioPrimer.getText());
                    modelo.setContrasena_usuario(vista.txtContrasenaPrimerUso.getText());
                    modelo.setEdad_usuario(edad);
                    modelo.setDUI_usuario(vista.txtDUIPrimer.getText());
                    modelo.setId_nivelUsuario(23);
                    modelo.Guardar();
                    
                    vista.txtNombreUsuarioPrimer.setText("");
                    vista.txtContrasenaPrimerUso.setText("");
                    vista.txtEdadPrimer.setText("");
                    vista.txtDUIPrimer.setText("");
                    
JOptionPane.showMessageDialog(vista, 
                              "Cuenta creada con éxito", 
                              "Creación de cuenta", 
                              JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
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
