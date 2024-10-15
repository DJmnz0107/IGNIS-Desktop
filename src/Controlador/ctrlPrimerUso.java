    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Controlador;

import Modelo.CambioSistema;
import Modelo.EncryptSHA256;
    import Modelo.Usuarios;
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
                JOptionPane.showMessageDialog(vista, "Ingrese una edad valida", "Error", JOptionPane.ERROR_MESSAGE);
            
            } else if (dui.length() > 10 || dui.length() < 10) {
                JOptionPane.showMessageDialog(vista, "El formato de DUI no es valido", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                try {
                    int edad = Integer.parseInt(vista.txtEdadPrimer.getText());
                    modelo.setNombre_usuario(vista.txtNombreUsuarioPrimer.getText());
                    modelo.setContrasena_usuario(vista.txtContrasenaPrimerUso.getText());
                    modelo.setEdad_usuario(edad);
                    modelo.setDUI_usuario(vista.txtDUIPrimer.getText());
                    modelo.setId_nivelUsuario(3);
                    modelo.Guardar();
                    
                    vista.txtNombreUsuarioPrimer.setText("");
                    vista.txtContrasenaPrimerUso.setText("");
                    vista.txtEdadPrimer.setText("");
                    vista.txtDUIPrimer.setText("");
                    
JOptionPane.showMessageDialog(vista, 
                              "Cuenta creada con éxito", 
                              "Creación de cuenta", 
                              JOptionPane.INFORMATION_MESSAGE);

    JOptionPane.showMessageDialog(vista, "La aplicación se va a reiniciar para aplicar los cambios.", "Reinicio requerido", JOptionPane.WARNING_MESSAGE);
    
 String javaBin = System.getProperty("java.home") + "/bin/java";
    String jarPath = new java.io.File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath();

    ProcessBuilder builder = new ProcessBuilder(javaBin, "-jar", jarPath);
    builder.redirectErrorStream(true); 

    try {
        Process process = builder.start();
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        
    } catch (IOException j) {
        j.printStackTrace();
        JOptionPane.showMessageDialog(vista, "Error al reiniciar la aplicación: " + j.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Cerrar la aplicación actual
    System.exit(0);

    // Cerrar la aplicación actual
    System.exit(0);



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
