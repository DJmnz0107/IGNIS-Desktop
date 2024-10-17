package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Informes;
import Modelo.Usuarios;
import Vistas.frmInicio;
import Vistas.frmVerInformes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;
import raven.drawer.Drawer;

/**
 *
 * @author aless
 */
public class ctrlVerInformes implements MouseListener, KeyListener {

    private Informes modelo;
    private frmVerInformes vista;
                                            private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlVerInformes(Informes modelo, frmVerInformes vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnEliminar.addMouseListener(this);
        vista.txtBuscarInforme.addKeyListener(this);
        vista.btnMenu.addMouseListener(this);
        modelo.Mostrar(vista.jtInformes);
        vista.imgBack.addMouseListener(this);
        
         Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()== vista.imgBack){
        
            frmInicio.initfrmInicio();
            vista.dispose();
        }
   if(e.getSource() == vista.btnEliminar) {
    if (vista.jtInformes.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Object[] opciones = {"Sí", "No"}; // Opciones en español

        int respuesta = JOptionPane.showOptionDialog(
            vista, 
            "¿Estás seguro de que deseas eliminar este Informe?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        // Si el usuario selecciona "Sí"
        if (respuesta == JOptionPane.YES_OPTION) {
            modelo.Eliminar(vista.jtInformes);
            modelo.Mostrar(vista.jtInformes);
            
               String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambio = "Un informe ha sido eliminado"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        }
    }
    
     
}

        if(e.getSource() == vista.btnMenu) {
            Drawer.getInstance().showDrawer();
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

    
    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == vista.txtBuscarInforme) {
            modelo.Buscar(vista.jtInformes, vista.txtBuscarInforme);
        }
    }
    
}
