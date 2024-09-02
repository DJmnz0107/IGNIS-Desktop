package Controlador;

import Modelo.Usuarios;
import Vistas.frmCrearCuenta;
import Vistas.frmVerUsuarios;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author aless
 */
public class ctrlVerUsuarios implements MouseListener, KeyListener{
    
    private Usuarios Usuarios;
    private frmVerUsuarios Vista;
    
    public ctrlVerUsuarios(Usuarios usuarios, frmVerUsuarios vista){
        this.Usuarios = usuarios;
        this.Vista = vista;
        
        vista.txtBuscar.addKeyListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.imgBack.addMouseListener(this);
        usuarios.Mostrar(vista.JtbUsuarios);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vista.btnEliminar){
            if (Vista.JtbUsuarios.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(Vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                 int respuesta = JOptionPane.showConfirmDialog(Vista, "¿Estás seguro de que deseas eliminar este registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                // Si el usuario selecciona "Sí/Yes"
                if (respuesta == JOptionPane.YES_OPTION) {
                    Usuarios.Eliminar(Vista.JtbUsuarios);
                    Usuarios.Mostrar(Vista.JtbUsuarios);
                }

            }
        }
        
        if (e.getSource() == Vista.imgBack){
            Vista.dispose();
            frmCrearCuenta.initFrmCrearCuenta();
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

    //Keyliteners
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == Vista.txtBuscar){
            Usuarios.Buscar(Vista.JtbUsuarios, Vista.txtBuscar);
        }
    }

    
}
