/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Aspirantes;
import Vistas.frmAgregarAspirante;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlAspirantes implements MouseListener {
    
    private Aspirantes Modelo;
    private frmAgregarAspirante Vistas;
    
    public ctrlAspirantes(Aspirantes modelo, frmAgregarAspirante vistas){
        this.Modelo = modelo;
        this.Vistas = vistas; 
    
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
