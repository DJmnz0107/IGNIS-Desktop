package Controlador;

import Modelo.Niveles;
import Modelo.Usuarios;
import Vistas.frmCrearCuenta;
import Vistas.frmInicio;
import Vistas.frmVerUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlCrearCuenta implements MouseListener {

    private Niveles ModeloNivel;
    private Usuarios ModeloUsuario;
    private frmCrearCuenta Vista;

    public ctrlCrearCuenta(Niveles modeloNivel, Usuarios modeloUsuarios, frmCrearCuenta vista) {
        this.ModeloNivel = modeloNivel;
        this.ModeloUsuario = modeloUsuarios;
        this.Vista = vista;
        
        
        vista.btnCrearCuenta.addMouseListener(this);
        vista.btnVerUsuarios.addMouseListener(this);
        vista.imgBack.addMouseListener(this);
        
        modeloNivel.obtenerNiveles(vista.jcmbTipoUsuario);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    if (e.getSource() == Vista.btnCrearCuenta) {

        Niveles nivelSeleccionado = (Niveles) Vista.jcmbTipoUsuario.getSelectedItem();
        int idNivelSeleccionado = nivelSeleccionado.getId_nivelUsuario();

        if (Vista.txtNombreUsuario.getText().isEmpty() ||
            Vista.txtContrasenaUsuario.getText().isEmpty() || 
            Vista.txtDuiUsuario.getText().isEmpty() || 
            Vista.txtEdadUsuario.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(Vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        
        } else {
            String contrasena = Vista.txtContrasenaUsuario.getText();
            String edad = Vista.txtEdadUsuario.getText();
            String dui = Vista.txtDuiUsuario.getText();

            // Verificar la longitud, al menos 1 símbolo especial y 1 letra mayúscula
            if (contrasena.length() < 8 ||
                !contrasena.matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~-].*") ||
                !contrasena.matches(".*[A-Z].*")) {
                
                JOptionPane.showMessageDialog(Vista, "La contraseña debe contener más de 8 caracteres, al menos 1 símbolo especial y 1 letra mayúscula", "Error", JOptionPane.ERROR_MESSAGE);

            // Verificar que la edad no tenga más de 3 dígitos
            } else if (edad.length() >= 3) {
                JOptionPane.showMessageDialog(Vista, "Ingrese una edad valida", "Error", JOptionPane.ERROR_MESSAGE);
            
            // Verificar que el DUI no tenga más de 10 dígitos
            } else if (dui.length() > 10 || dui.length() < 10) {
                JOptionPane.showMessageDialog(Vista, "El formato de DUI no es valido", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                try {
                    ModeloUsuario.setNombre_usuario(Vista.txtNombreUsuario.getText());
                    ModeloUsuario.setContrasena_usuario(contrasena);
                    ModeloUsuario.setEdad_usuario(Integer.parseInt(edad));
                    ModeloUsuario.setDUI_usuario(dui);
                    ModeloUsuario.setId_nivelUsuario(idNivelSeleccionado);
                    ModeloUsuario.Guardar();

                    JOptionPane.showMessageDialog(Vista, "Cuenta creada con éxito", "Creación de cuenta", JOptionPane.INFORMATION_MESSAGE);

                    LimpiarCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
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
}
