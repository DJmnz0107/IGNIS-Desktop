/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Misiones;
import Modelo.Recursos;
import Vistas.frmActualizarInventario;
import Vistas.frmActualizarMision;
import Vistas.frmVerRegistroMisiones;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ctrlMisiones implements MouseListener, KeyListener{
    
    private frmVerRegistroMisiones Vistas;
    private Misiones Modelo;
    
    public ctrlMisiones(frmVerRegistroMisiones vistas, Misiones modelo ){
    
    this.Modelo = modelo;
    this.Vistas = vistas;
    
    modelo.Mostrar(vistas.jtbMisiones);
    vistas.btnEliminar.addMouseListener(this);
    vistas.txtBuscar.addKeyListener(this);
    vistas.btnActualizar.addMouseListener(this);
    
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vistas.btnEliminar ){
           Modelo.Eliminar(Vistas.jtbMisiones);
           Modelo.Mostrar(Vistas.jtbMisiones);
            JOptionPane.showMessageDialog(Vistas, "Registro eliminado exitosamente");
        }
        if(e.getSource() == Vistas.btnActualizar) {
                try {
        Misiones misionSeleccionada = Modelo.obtenerDatosTabla(Vistas);

        if (misionSeleccionada != null) {
            frmActualizarMision.initfrmActualizarInventario(misionSeleccionada);
            Vistas.dispose();
        } else {
            JOptionPane.showMessageDialog(Vistas, "Por favor, seleccione una fila para actualizar.");
        }
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(Vistas, "Error al convertir la fecha. Por favor, verifica el formato.");
        ex.printStackTrace(); // Opcionalmente imprime la traza del error en consola
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
            Modelo.Buscar(Vistas.jtbMisiones, Vistas.txtBuscar);
        }
    }
    
    
}
