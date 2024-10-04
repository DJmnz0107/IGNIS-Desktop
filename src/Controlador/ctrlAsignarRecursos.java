/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MisionesRecursos;
import Vistas.frmAsignarRecursos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author USUARIO
 */
public class ctrlAsignarRecursos implements MouseListener{
    private MisionesRecursos Modelo;
    private frmAsignarRecursos Vistas;
    
    public ctrlAsignarRecursos(MisionesRecursos modelo,frmAsignarRecursos Vistas ){
    
       this.Modelo = modelo;
       this.Vistas = Vistas;
       
       this.Vistas.btnguardar.addMouseListener(this);
       this.Vistas.btnVerAsigRecu.addMouseListener(this);
       
       
       
       
    }
    
    private void guardarAsigRecu(){
        
        
    
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
