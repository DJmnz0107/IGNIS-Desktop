/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Aspirantes;
import Vistas.frmSeguimientoAspirante;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import raven.drawer.Drawer;

/**
 *
 * @author User
 */
public class ctrlSeguimiento implements MouseListener{
    
    private Aspirantes Modelo;
    private frmSeguimientoAspirante Vistas;
    
    public ctrlSeguimiento(Aspirantes modelo, frmSeguimientoAspirante vistas){
        this.Vistas = vistas;
        this.Modelo=  modelo;
        
        this.Vistas.btnMenu.addMouseListener(this);
        
        
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vistas.btnMenu){
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
