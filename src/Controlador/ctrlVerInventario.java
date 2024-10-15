/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClaseConexion;
import Vistas.frmAgregarInventario;
import Vistas.frmVerInventario;
import Vistas.frmVerRegistroInventario;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import modelo.EmergenciaController;

/**
 *
 * @author Diego
 */
public class ctrlVerInventario implements MouseListener {
    
    private frmVerInventario vista;
    private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlVerInventario(frmVerInventario vista) {
        this.vista = vista;
        vista.btnVerRegistro.addMouseListener(this);
        this.vista.imgBack.addMouseListener(this);
        
        Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()== vista.imgBack){
            frmAgregarInventario.initfrmAgregarInventario();
            vista.dispose();
        }
        
        if(e.getSource() == vista.btnVerRegistro) {
            frmVerRegistroInventario.initfrmVerRegistroInventario();
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
