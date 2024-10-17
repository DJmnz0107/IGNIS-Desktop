
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.MisionesBomberos;
import Modelo.Usuarios;
import Vistas.frmActualizarMisionBombero;
import Vistas.frmAsignarMisionesBomberos;
import Vistas.frmRegistroMisionesBomberos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;


public class ctrlMisionesBomberos implements MouseListener, KeyListener {
    
    private MisionesBomberos modelo; 
    private  frmRegistroMisionesBomberos Vista;
                    private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlMisionesBomberos (MisionesBomberos modelo, frmRegistroMisionesBomberos Vista){
    
        this.modelo = modelo;
        this.Vista = Vista;
        Vista.txtBuscar.addKeyListener(this);
        Vista.btnEliminar.addMouseListener(this);
        Vista.btnActualizar.addMouseListener(this);
        Vista.imgBack.addMouseListener(this);
        modelo.Mostrar(Vista.jtMisionesBomberos);
        
         Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vista.btnEliminar){
            
                if (Vista.jtMisionesBomberos.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(Vista, "Debes seleccionar una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Object[] opciones = {"Sí", "No"}; // Opciones en español

        int respuesta = JOptionPane.showOptionDialog(
            Vista, 
            "¿Estás seguro de que deseas eliminar este registro?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            modelo.Eliminar(Vista.jtMisionesBomberos);
            modelo.Mostrar(Vista.jtMisionesBomberos);
            JOptionPane.showMessageDialog(Vista, "Registro eliminado exitosamente");
                String nombreMisiones = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreMisiones);
                  
        String descripcionCambio = "Una mision de bombero ha sido eliminada "; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        }
           
        }
                
    
 
    }
        
        
         if(e.getSource() == Vista.btnActualizar) {
            MisionesBomberos registroSeleccionado = modelo.obtenerDatosTabla(Vista);

        if (registroSeleccionado != null) {
            frmActualizarMisionBombero.initFrmActulizarMisionesBomberos(registroSeleccionado);
            Vista.dispose();
        } else {
            JOptionPane.showMessageDialog(Vista, "Por favor, seleccione una fila para actualizar.");
        }
        
       
        }
        
               if(e.getSource() == Vista.imgBack){
            frmAsignarMisionesBomberos.initfrmAsignarMisionesBomberos();
                        Vista.dispose();
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
        if(e.getSource() == Vista.txtBuscar) {
            modelo.Buscar(Vista.jtMisionesBomberos, Vista.txtBuscar);
        }
    }
}
