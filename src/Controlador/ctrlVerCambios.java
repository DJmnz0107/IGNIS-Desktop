/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Vistas.frmInicio;
import Vistas.frmVerCambios;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import modelo.EmergenciaController;

/**
 *
 * @author USUARIO
 */
public class ctrlVerCambios implements MouseListener, KeyListener{
    
    private CambioSistema CambioSistema;
    private frmVerCambios Vista;
                                    private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlVerCambios(CambioSistema cambioSistema,frmVerCambios vista){
        
        this.CambioSistema = cambioSistema;
        this.Vista =vista;
        
        vista.txtBuscarVerCambios.addKeyListener(this);
        vista.imgVolver.addMouseListener(this);
        CambioSistema.Mostar(vista.JtbVerCambios);
        
                Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
    
    
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == Vista.imgVolver){
            Vista.dispose();
            frmInicio.initfrmInicio();
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
        if(e.getSource() == Vista.txtBuscarVerCambios){
            CambioSistema.BuscarSistema(Vista.JtbVerCambios, Vista.txtBuscarVerCambios);
        }
    }
    
}

