package Controlador;

import Modelo.ClaseConexion;
import Modelo.Misiones;
import Vistas.frmInicio;
import Vistas.frmVerEstadisticas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import modelo.EmergenciaController;
import raven.drawer.Drawer;

/**
 *
 * @author aless
 */
public class ctrlVerEstadisticas implements MouseListener {

    private Misiones modelo;
    private frmVerEstadisticas vista;
                                            private static EmergenciaController controller; // Mueve el controlador a un campo estático


    public ctrlVerEstadisticas(Misiones modelo, frmVerEstadisticas vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnMenu.addMouseListener(this);
        vista.imgBack.addMouseListener(this);
        
          Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.imgBack){
        frmInicio.initfrmInicio();
        vista.dispose();
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
    
}
