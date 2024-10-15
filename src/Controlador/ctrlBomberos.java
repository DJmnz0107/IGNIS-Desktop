/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Bomberos;
import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Usuarios;
import Vistas.frmActualizarBomberos;
import Vistas.frmAgregarBomberos;
import Vistas.frmRegistroBomberos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;
import raven.drawer.Drawer;


public class ctrlBomberos implements MouseListener, KeyListener{
    
    private frmRegistroBomberos Vistas;
    private Bomberos Modelo;
            private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    
    public ctrlBomberos (frmRegistroBomberos vistas, Bomberos modelo){
    
        this.Vistas = vistas;
        this.Modelo = modelo;
        
        Modelo.Mostrar(Vistas.jtBomberos);
        this.Vistas.imgBack.addMouseListener(this);
        this.Vistas.btnEliminar.addMouseListener(this);
        this.Vistas.btnActualizar.addMouseListener(this);
        this.Vistas.txtBuscar.addKeyListener(this);
        this.Vistas.btnMenu.addMouseListener(this);
        
           Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()== Vistas.btnMenu){
            Drawer.getInstance().showDrawer();
        }
        
        if (e.getSource() == Vistas.btnActualizar) {
    try {
        Bomberos BomberosSeleccionado = Modelo.obtenerDatosTabla(Vistas);

        if (BomberosSeleccionado != null) {
            frmActualizarBomberos.initfrmActualizarBomberos(BomberosSeleccionado);
            Vistas.dispose();
        } else {
            JOptionPane.showMessageDialog(Vistas, "Por favor, seleccione una fila para actualizar.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();  
    }
    

}
        
        if(e.getSource()== Vistas.imgBack){
        frmAgregarBomberos.initfrmAgregarBomberos();
        Vistas.dispose();
        }
        
                if (e.getSource() == Vistas.btnEliminar) {
    if (Vistas.jtBomberos.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(Vistas, "Debes seleccionar una misión para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Object[] opciones = {"Sí", "No"}; // Opciones en español

        int respuesta = JOptionPane.showOptionDialog(
            Vistas, 
            "¿Estás seguro de que deseas eliminar esta misión?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            Modelo.Eliminar(Vistas.jtBomberos); 
            Modelo.Mostrar(Vistas.jtBomberos); 
            JOptionPane.showMessageDialog(Vistas, "Misión eliminada exitosamente");
        }
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
            Modelo.Buscar(Vistas.jtBomberos, Vistas.txtBuscar);
        }
        
    }
}
