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
    
    private Usuarios modelo;
    private frmVerUsuarios vista;
    
    public ctrlVerUsuarios(Usuarios usuarios, frmVerUsuarios vista){
        this.modelo = usuarios;
        this.vista = vista;
        
        vista.txtBuscar.addKeyListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.imgBack.addMouseListener(this);
        usuarios.Mostrar(vista.jtUsuarios);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.btnEliminar){
            if (vista.jtUsuarios.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                 int respuesta = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de que deseas eliminar este registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                // Si el usuario selecciona "Sí/Yes"
                if (respuesta == JOptionPane.YES_OPTION) {
                    modelo.Eliminar(vista.jtUsuarios);
                    modelo.Mostrar(vista.jtUsuarios);
                }

            }
        }
        
        if (e.getSource() == vista.imgBack){
            vista.dispose();
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
        if(e.getSource() == vista.txtBuscar){
            modelo.Buscar(vista.jtUsuarios, vista.txtBuscar);
        }
    }

    
}
