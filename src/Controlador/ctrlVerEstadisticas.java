package Controlador;

import Modelo.Misiones;
import Vistas.frmEstadisticas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import raven.drawer.Drawer;

/**
 *
 * @author aless
 */
public class ctrlVerEstadisticas implements MouseListener {

    private Misiones modelo;
    private frmEstadisticas vista;

    public ctrlVerEstadisticas(Misiones modelo, frmEstadisticas vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnMenu.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
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
