/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Aspirantes;
import Vistas.frmActualizarAspirante;
import Vistas.frmVerRegistroAspirantes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class ctrlVerRegistroAspirantes implements MouseListener,KeyListener {
    
    private frmVerRegistroAspirantes Vistas;
    private Aspirantes Modelo;
    
public ctrlVerRegistroAspirantes(frmVerRegistroAspirantes vistas, Aspirantes modelo ){
 
    this.Modelo = modelo;
    this.Vistas = vistas;
    modelo.Mostrar(vistas.jtAspirantes);
    
    vistas.btnEliminar.addMouseListener(this);
    
    vistas.txtBuscar.addKeyListener(this);
    vistas.btnActualizar.addMouseListener(this);

    }
  

    
   @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== Vistas.btnEliminar){
        
            Modelo.Eliminar(Vistas.jtAspirantes);
            Modelo.Mostrar(Vistas.jtAspirantes);
            JOptionPane.showMessageDialog(Vistas, "Registro eliminado exitosamente");
        }
        if(e.getSource() == Vistas.btnActualizar) {
            Aspirantes aspiranteSeleccionado = Modelo.obtenerDatosTabla(Vistas);

        if (aspiranteSeleccionado != null) {
            frmActualizarAspirante.initfrmActualizarAspirante(aspiranteSeleccionado);
            Vistas.dispose();
        } else {
            JOptionPane.showMessageDialog(Vistas, "Por favor, seleccione una fila para actualizar.");
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == Vistas.txtBuscar) {
            Modelo.Buscar(Vistas.jtAspirantes, Vistas.txtBuscar);
        }

    }
    
    
}

