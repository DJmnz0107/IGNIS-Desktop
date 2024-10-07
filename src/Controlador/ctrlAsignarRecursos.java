/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MisionesRecursos;
import Vistas.frmAsignarRecursos;
import Vistas.frmAsignarRecursosVer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ctrlAsignarRecursos implements MouseListener{
        private frmAsignarRecursos vista;
      private MisionesRecursos modelo;
   
    public ctrlAsignarRecursos(frmAsignarRecursos vista,MisionesRecursos modelo ){
    
       this.modelo = modelo;
       this.vista = vista;
       this.vista.btnguardar.addMouseListener(this);
       this.vista.btnVerAsigRecu.addMouseListener(this);
       
       
       
       
    }
    
    private void guardarAsigRecu(){
        
        int Recurso = (int) vista.cmbRecursos.getSelectedItem();
        int Misiones = (int)vista.cmbMision.getSelectedItem();
        
        
    
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()==vista.btnguardar){
        
        guardarAsigRecu();
            modelo.Guardar();
            JOptionPane.showMessageDialog(vista,"Informacion ingresada con exito","Agregar transporte",JOptionPane.INFORMATION_MESSAGE);
        
        }
        
        
        if(e.getSource()==vista.btnVerAsigRecu){
            frmAsignarRecursosVer.initFrmAsignarRecursosVer();
            vista.dispose();
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
