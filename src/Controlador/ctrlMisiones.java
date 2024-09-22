/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Misiones;
import Vistas.frmVerRegistroMisiones;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author User
 */
public class ctrlMisiones implements MouseListener{
    
    private frmVerRegistroMisiones Vistas;
    private Misiones Modelo;
    
    public ctrlMisiones(frmVerRegistroMisiones vistas, Misiones modelo ){
    
    this.Modelo = modelo;
    this.Vistas = vistas;
    
    modelo.Mostrar(vistas.jtbMisiones);
    
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
