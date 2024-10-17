/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vistas.frmCambarContra;
import Vistas.frmVerificarCodigo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ctrlVerificarCodigo implements MouseListener{
 private frmVerificarCodigo Vistas;
 
 public ctrlVerificarCodigo(frmVerificarCodigo Vistas){
  this.Vistas = Vistas;
  
  
 Vistas.btnVeriCodi.addMouseListener(this);
 
 }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vistas.btnVeriCodi) {
                    if(Vistas.txtVeriCodi.getText().isEmpty()) {            
            JOptionPane.showMessageDialog(Vistas, "Porfavor, el campo", "Error", JOptionPane.ERROR_MESSAGE);
                 return;            
        }
                    
            if (Integer.parseInt(Vistas.txtVeriCodi.getText()) == ctrlRecuContrasena.numeroAleatorio) {
            
            frmCambarContra.initFrmCambiar();
            Vistas.dispose();
            

        } else {
           JOptionPane.showMessageDialog(Vistas, "Codigo Incorrecto", "Recuperación de Contraseña", JOptionPane.WARNING_MESSAGE);

        }
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
