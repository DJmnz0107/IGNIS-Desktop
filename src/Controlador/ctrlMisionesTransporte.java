/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MisionesTransporte;
import Vistas.frmRegistroTransportes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author danie
 */
public class ctrlMisionesTransporte implements MouseListener {
    
    private MisionesTransporte modelo; 
    private  frmRegistroTransportes Vista;
    
    public ctrlMisionesTransporte (MisionesTransporte modelo, frmRegistroTransportes Vista){
    
        this.modelo = modelo;
        this.Vista = Vista;
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
