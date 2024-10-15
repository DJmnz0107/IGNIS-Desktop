/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Emergencias;
import Modelo.Misiones;
import Modelo.Usuarios;
import Vistas.frmAgregarMision;
import Vistas.frmAgregarMisionTransportes;
import Vistas.frmAsignarMisionesBomberos;
import Vistas.frmRegistroMisionesBomberos;
import Vistas.frmAsignarRecursos;
import Vistas.frmAsignarRecursosVer;
import Vistas.frmInicio;
import Vistas.frmRegistroTransportes;
import Vistas.frmVerEmergencias;
import Vistas.frmVerInformes;
import Vistas.frmVerRegistroMisiones;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;
import raven.drawer.Drawer;

/**
 *
 * @author Diego
 */
public class ctrlAgregarMisiones implements MouseListener {
    
    private Emergencias emergencia;
    private Misiones modelo;
    private frmAgregarMision vista;
                     private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlAgregarMisiones(Emergencias emergencia, Misiones modelo, frmAgregarMision vista ) {
     this.emergencia = emergencia;
    this.modelo = modelo;
    this.vista = vista;
    
    //Llenando cmbEmergencia con Emergencias
    emergencia.obtenerEmergencias(vista.cmbEmergencia); // Llenar con Emergencias
    vista.dtcEmergencia.setMaxSelectableDate(new Date());
    vista.btnAgregar.addMouseListener(this);
    vista.btnVerRegistro.addMouseListener(this);
    vista.btnMenu.addMouseListener(this);
    vista.btnTransportes2.addMouseListener(this);
    vista.btnBomberos.addMouseListener(this);
      vista.btnRecursos.addMouseListener(this);   
    vista.imgBack.addMouseListener(this);
    vista.btnEmergencias.addMouseListener(this);
    vista.btnInformes.addMouseListener(this);
    
                 
            Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnEmergencias) {
            frmVerEmergencias.initfrmVerEmergencias();
            vista.dispose();
        }
        
        if(e.getSource() == vista.btnInformes) {
            frmVerInformes.initfrmVerInformes();
            vista.dispose();
        }
        
        if(e.getSource()== vista.imgBack){
        frmInicio.initfrmInicio();
        vista.dispose();
        }
         
       if (e.getSource() == vista.btnAgregar) {
        if (vista.txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, llena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
     
        
      
          if (vista.cmbEmergencia.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir una emergencia nula, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Asegúrate de hacer el cast a Emergencias
        Emergencias emergenciaSeleccionada = (Emergencias) vista.cmbEmergencia.getSelectedItem();
        int idEmergencia = emergenciaSeleccionada.getIdEmergencia();
        modelo.setDescripcionMision(vista.txtDescripcion.getText());
        modelo.setFechaMision(vista.dtcEmergencia.getDate());
        modelo.setIdEmergencia(idEmergencia);
        modelo.insertarMision();
        JOptionPane.showMessageDialog(vista, "Misión ingresada exitosamente.");
        limpiarCampos();
        
        
        
        String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuarios = new Usuarios();
                 
         int idsUsuario = usuarios.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambios = "Mision agregada al Sistema"; // Descripción del cambio
        
        CambioSistema cambiosSistemas = new CambioSistema();
        
        cambiosSistemas.insertarCambio(idsUsuario, descripcionCambios);
        
        
        
    }
       
              if(e.getSource() == vista.btnBomberos){
            //1-Creo un objeto del panel que quiero mostrar
            frmAsignarMisionesBomberos.initfrmAsignarMisionesBomberos();
            vista.dispose();
        }
       

          if(e.getSource() == vista.btnRecursos) {
                frmAsignarRecursos.initFrmAsignarRecursos();
                vista.dispose();
        }
          
        if(e.getSource() == vista.btnMenu) {
            Drawer.getInstance().showDrawer();
            System.out.println("Hola");
        }
        
        if(e.getSource() == vista.btnVerRegistro) {
            frmVerRegistroMisiones.initFrmVerRegistroMisiones();
            vista.dispose();
        }
        
        if(e.getSource() == vista.btnTransportes2){
            frmAgregarMisionTransportes.initfrmAgregarMisionTransportes();
            vista.dispose();
        }
    }
    
    private void limpiarCampos() {
        vista.txtDescripcion.setText("");
        vista.cmbEmergencia.setSelectedIndex(0); 
       vista.dtcEmergencia.setDate(null); 
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
