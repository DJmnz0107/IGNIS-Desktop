/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Aspirantes;
import Vistas.frmActualizarAspirante;
import Vistas.frmSeguimientoAspirante;
import Vistas.frmVerRegistroAspirantes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
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
    vistas.imgBack.addMouseListener(this);

    }
  


    
   @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()== Vistas.imgBack){
        
            frmSeguimientoAspirante.initfrmSeguimientoAspirante();
            Vistas.dispose();
        }
      if (e.getSource() == Vistas.btnEliminar) {
    if (Vistas.jtAspirantes.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(Vistas, "Debes seleccionar un aspirante para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Object[] opciones = {"Sí", "No"}; // Opciones en español

        int respuesta = JOptionPane.showOptionDialog(
            Vistas, 
            "¿Estás seguro de que deseas eliminar este aspirante?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            Modelo.Eliminar(Vistas.jtAspirantes);
            Modelo.Mostrar(Vistas.jtAspirantes);
            JOptionPane.showMessageDialog(Vistas, "Aspirante eliminado exitosamente");
        }
    }
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

