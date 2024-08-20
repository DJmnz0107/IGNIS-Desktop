package Controlador;

import Modelo.Niveles;
import Modelo.Usuarios;
import Vistas.frmCrearCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
            // Acción a realizar cuando se presiona el botón "Crear cuenta"
            Niveles nivelSeleccionado = (Niveles) Vista.jcmbTipoUsuario.getSelectedItem();
            int idNivelSeleccionado = nivelSeleccionado.getId_nivelUsuario();
            System.out.println("ID del nivel seleccionado: " + idNivelSeleccionado);
            
            ModeloUsuario.setNombre_usuario(Vista.txtNombreUsuario.getText());
            ModeloUsuario.setContrasena_usuario(Vista.txtContrasenaUsuario.getText());
            ModeloUsuario.setEdad_usuario(Vista.txtEdadUsuario.getText());
            ModeloUsuario.setDUI_usuario(Vista.txtDuiUsuario.getText());
            ModeloUsuario.setId_nivelUsuario(idNivelSeleccionado);
            ModeloUsuario.Guardar();
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
