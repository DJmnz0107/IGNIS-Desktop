package Controlador;

import Modelo.Niveles;
import Modelo.Usuarios;
import Vistas.frmCrearCuenta;
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
                Vista.txtEdadUsuario.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(Vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                ModeloUsuario.setNombre_usuario(Vista.txtNombreUsuario.getText());
                ModeloUsuario.setContrasena_usuario(Vista.txtContrasenaUsuario.getText());
                ModeloUsuario.setEdad_usuario(Integer.parseInt(Vista.txtEdadUsuario.getText()));
                ModeloUsuario.setDUI_usuario(Vista.txtDuiUsuario.getText());
                ModeloUsuario.setId_nivelUsuario(idNivelSeleccionado);
                ModeloUsuario.Guardar();
                
                JOptionPane.showMessageDialog(Vista, "Cuenta creada con éxito", "Creación de cuenta", JOptionPane.INFORMATION_MESSAGE);
                
                LimpiarCampos();
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    public void LimpiarCampos(){
        Vista.txtContrasenaUsuario.setText("");
        Vista.txtNombreUsuario.setText("");
        Vista.txtContrasenaUsuario.setText("");
        Vista.txtDuiUsuario.setText("");
        Vista.txtEdadUsuario.setText("");
    }
}
