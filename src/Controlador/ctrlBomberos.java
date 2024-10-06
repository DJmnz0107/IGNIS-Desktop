/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Bomberos;
import Vistas.frmRegistroBomberos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlBomberos implements MouseListener{
    
    private frmRegistroBomberos Vistas;
    private Bomberos Modelo;
    
    
    public ctrlBomberos (frmRegistroBomberos vistas, Bomberos modelo){
    
        this.Vistas = vistas;
        this.Modelo = modelo;
        
        Modelo.Mostrar(Vistas.jtBomberos);
        
        
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
