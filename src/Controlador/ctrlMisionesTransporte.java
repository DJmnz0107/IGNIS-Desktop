/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Vistas.frmActualizarMisionTransporte;
import Modelo.MisionesTransporte;
import Modelo.Usuarios;
import Vistas.frmAgregarMision;
import Vistas.frmAgregarMisionTransportes;
import Vistas.frmRegistroTransportes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;


/**
 *
 * @author danie
 */
public class ctrlMisionesTransporte implements MouseListener, KeyListener {
    
    private MisionesTransporte modelo; 
    private  frmRegistroTransportes Vista;
                        private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    
    public ctrlMisionesTransporte (MisionesTransporte modelo, frmRegistroTransportes Vista){
    
        this.modelo = modelo;
        this.Vista = Vista;
        Vista.txtBuscar.addKeyListener(this);
        Vista.btnEliminar.addMouseListener(this);
        Vista.imgBack.addMouseListener(this);
        modelo.Mostrar(Vista.jtRegistroTransporte);
        Vista.btnActualizar.addMouseListener(this);
        
           Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vista.btnEliminar){
            modelo.Eliminar(Vista.jtRegistroTransporte);
            modelo.Mostrar(Vista.jtRegistroTransporte);
            
        String nombreMisiones = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreMisiones);
                  
        String descripcionCambio = "Una transporte de misión a sido eliminado "; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        }
        if(e.getSource() == Vista.imgBack){
            Vista.dispose();
            frmAgregarMisionTransportes.initfrmAgregarMisionTransportes();
        }
        
         if(e.getSource() == Vista.btnActualizar) {
            MisionesTransporte registroSeleccionado = modelo.obtenerDatosTabla(Vista);

        if (registroSeleccionado != null) {
            frmActualizarMisionTransporte.initfrmActualizarMisionTransporte(registroSeleccionado);
            Vista.dispose();
        } else {
            JOptionPane.showMessageDialog(Vista, "Por favor, seleccione una fila para actualizar.");
        }
        
        String nombreMisiones = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreMisiones);
                  
        String descripcionCambio = "Una transporte de misión a sido actualizada "; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
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
        if(e.getSource() == Vista.txtBuscar) {
            modelo.Buscar(Vista.jtRegistroTransporte, Vista.txtBuscar);
        }
    }
    
    
    
    
    
   
    
    
}
