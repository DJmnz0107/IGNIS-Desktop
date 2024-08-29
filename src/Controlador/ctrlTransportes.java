package Controlador;

import Modelo.Transportes;
import Vistas.frmAgregarTransportes;
import Vistas.frmVerRegistroTransporter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlTransportes implements MouseListener{
    
    private Transportes Modelo;
    private frmVerRegistroTransporter verRegistroTransporter;
    private frmAgregarTransportes VistasverRegistroTransporter;
    
    public ctrlTransportes (Transportes modelo, frmVerRegistroTransporter verRegistroTransporter, frmAgregarTransportes VistasverRegistroTransporter){
    
        this.Modelo = modelo;
        this.verRegistroTransporter = verRegistroTransporter;
        this.VistasverRegistroTransporter = VistasverRegistroTransporter;

        
        modelo.Mostrar(verRegistroTransporter.jtTransportes);
        
    }
        
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
       
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
