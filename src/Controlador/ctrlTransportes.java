package Controlador;

import Modelo.Transportes;
import Vistas.frmAgregarTransportes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlTransportes implements MouseListener{
    
    private Transportes Modelo;
    private frmAgregarTransportes Vistas;
    
    public ctrlTransportes (Transportes modelo, frmAgregarTransportes vistas){
    
        this.Modelo = modelo;
        this.Vistas = vistas;
        
        vistas.btnAgregar.addMouseListener(this);
        
        modelo.obtenerTransportes(Vistas.cmbAgregarTransporte);
        
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vistas.btnAgregar) {
            Transportes tipoTransportes = (Transportes) Vistas.cmbAgregarTransporte.getSelectedItem();
            int 
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
