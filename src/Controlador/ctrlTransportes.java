package Controlador;

import Modelo.Transportes;

import Vistas.frmVerRegistroTransporter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlTransportes implements MouseListener{
    
    private Transportes Modelo;
    private frmVerRegistroTransporter Vistas;
    
    public ctrlTransportes (Transportes modelo, frmVerRegistroTransporter vistas){
    
        this.Modelo = modelo;
        this.Vistas = vistas;
        
        modelo.Mostrar(Vistas.jtTransportes);
        
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
