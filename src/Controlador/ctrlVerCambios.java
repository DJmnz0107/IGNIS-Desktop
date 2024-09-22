/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Vistas.frmVerCambios;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author USUARIO
 */
public class ctrlVerCambios implements MouseListener, KeyListener{
    
    private CambioSistema CambioSistema;
    private frmVerCambios Vista;
    
    public ctrlVerCambios(CambioSistema cambioSistema,frmVerCambios vista){
        
        this.CambioSistema = cambioSistema;
        this.Vista =vista;
        
        vista.txtBuscarVerCambios.addKeyListener(this);
        vista.
    
    
    
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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
     
    }

    @Override
    public void keyReleased(KeyEvent e) {
      
    }
    
}
