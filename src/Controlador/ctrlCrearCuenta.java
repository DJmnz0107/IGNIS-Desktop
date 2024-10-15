package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Niveles;
import Modelo.Usuarios;
import Vistas.frmCrearCuenta;
import Vistas.frmInicio;
import Vistas.frmVerUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;

public class ctrlCrearCuenta implements MouseListener, KeyListener {

    private Niveles ModeloNivel;
    private Usuarios ModeloUsuario;
    private frmCrearCuenta Vista;
                private static EmergenciaController controller; // Mueve el controlador a un campo estático


    public ctrlCrearCuenta(Niveles modeloNivel, Usuarios modeloUsuarios, frmCrearCuenta vista) {
        this.ModeloNivel = modeloNivel;
        this.ModeloUsuario = modeloUsuarios;
        this.Vista = vista;
        
        
        vista.btnCrearCuenta.addMouseListener(this);
        vista.btnVerUsuarios.addMouseListener(this);
        vista.txtEdadUsuario.addKeyListener(this);
        vista.txtDuiUsuario.addKeyListener(this);
        vista.imgBack.addMouseListener(this);
        
        modeloNivel.obtenerNiveles(vista.jcmbTipoUsuario);
        
           Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
   if (e.getSource() == Vista.btnCrearCuenta) {
    Niveles nivelSeleccionado = (Niveles) Vista.jcmbTipoUsuario.getSelectedItem();
    int idNivelSeleccionado = nivelSeleccionado.getId_nivelUsuario();

    // Verificar campos vacíos
    if (Vista.txtNombreUsuario.getText().isEmpty() ||
        Vista.txtContrasenaUsuario.getText().isEmpty() || 
        Vista.txtDuiUsuario.getText().isEmpty() || 
        Vista.txtEdadUsuario.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(Vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
    
    } else {
        String contrasena = Vista.txtContrasenaUsuario.getText();
        String edad = Vista.txtEdadUsuario.getText();
        String dui = Vista.txtDuiUsuario.getText();
        String nombreUsuario = Vista.txtNombreUsuario.getText();

        // Verificar la longitud, al menos 1 símbolo especial y 1 letra mayúscula
        if (contrasena.length() < 8 ||
            !contrasena.matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~-].*") ||
            !contrasena.matches(".*[A-Z].*")) {
            
            JOptionPane.showMessageDialog(Vista, "La contraseña debe contener más de 8 caracteres, al menos 1 símbolo especial y 1 letra mayúscula", "Error", JOptionPane.ERROR_MESSAGE);

        // Verificar que la edad no tenga más de 3 dígitos
        } else if (edad.length() >= 3) {
            JOptionPane.showMessageDialog(Vista, "Ingrese una edad válida", "Error", JOptionPane.ERROR_MESSAGE);
        
        // Verificar que el DUI no tenga exactamente 10 dígitos
        } else if (dui.length() != 10) {
            JOptionPane.showMessageDialog(Vista, "El formato de DUI no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        
        } else {
            try {
                int edadNumerica = Integer.parseInt(edad);
                
                // Si la edad es menor de 18, muestra error
                if (edadNumerica < 18) {
                    JOptionPane.showMessageDialog(Vista, "La edad debe ser mayor o igual a 18", "Error", JOptionPane.ERROR_MESSAGE);
                    Vista.txtEdadUsuario.setText(""); // Borra la edad si es menor a 18
                } else {
                    // Crear una instancia de tu modelo para la base de datos

                    // Verificar si el DUI ya existe
                    boolean duiExiste = ModeloUsuario.verificarDui(dui);
                    if (duiExiste) {
                        JOptionPane.showMessageDialog(Vista, "El DUI ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Detener la ejecución si el DUI existe
                    }

                    // Verificar si el nombre de usuario ya existe
                    boolean usuarioExiste = ModeloUsuario.verificarUsuario(nombreUsuario);
                    if (usuarioExiste) {
                        JOptionPane.showMessageDialog(Vista, "El nombre de usuario ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Detener la ejecución si el nombre de usuario existe
                    }

                    // Guardar los datos del nuevo usuario si todo es válido
                    ModeloUsuario.setNombre_usuario(nombreUsuario);
                    ModeloUsuario.setContrasena_usuario(contrasena);
                    ModeloUsuario.setEdad_usuario(edadNumerica); // Usar edadNumerica
                    ModeloUsuario.setDUI_usuario(dui);
                    ModeloUsuario.setId_nivelUsuario(idNivelSeleccionado);
                    ModeloUsuario.Guardar();

                    JOptionPane.showMessageDialog(Vista, "Cuenta creada con éxito", "Creación de cuenta", JOptionPane.INFORMATION_MESSAGE);
                    LimpiarCampos();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Vista, "Error al guardar la cuenta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}



    if (e.getSource() == Vista.btnVerUsuarios) {
        Vista.dispose();
        frmVerUsuarios.initfrmVerUsuarios();
    }
    
    if(e.getSource() == Vista.imgBack) {
        Vista.dispose();
        frmInicio.initfrmInicio();
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
    
    public void LimpiarCampos(){
        Vista.txtContrasenaUsuario.setText("");
        Vista.txtNombreUsuario.setText("");
        Vista.txtContrasenaUsuario.setText("");
        Vista.txtDuiUsuario.setText("");
        Vista.txtEdadUsuario.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == Vista.txtEdadUsuario){
            String edad = Vista.txtEdadUsuario.getText();
                
        }
    }
}
