package Controlador;

import Modelo.ClaseConexion;
import Modelo.Usuarios;
import Vistas.frmCrearCuenta;
import Vistas.frmVerUsuarios;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;

/**
 *
 * @author aless
 */
public class ctrlVerUsuarios implements MouseListener, KeyListener{
    
    private Usuarios modelo;
    private frmVerUsuarios vista;
            private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlVerUsuarios(Usuarios usuarios, frmVerUsuarios vista){
        this.modelo = usuarios;
        this.vista = vista;
        
        vista.txtBuscar.addKeyListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.imgBack.addMouseListener(this);
        usuarios.Mostrar(vista.jtUsuarios);
        
           Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
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
