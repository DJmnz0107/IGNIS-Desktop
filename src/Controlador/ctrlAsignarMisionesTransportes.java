/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.MisionDisplay;
import Modelo.Misiones;
import Modelo.MisionesTransporte;
import Modelo.TransporteDisplay;
import Modelo.Transportes;
import Modelo.Usuarios;
import Vistas.frmAgregarMision;
import Vistas.frmAgregarMisionTransportes;
import Vistas.frmRegistroTransportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;

/**
 *
 * @author User
 */
public class ctrlAsignarMisionesTransportes implements MouseListener{
    
    private frmAgregarMisionTransportes Vistas;
    private MisionesTransporte Modelo;
                                 private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlAsignarMisionesTransportes(frmAgregarMisionTransportes vistas, MisionesTransporte modelo){
        this.Vistas = vistas;
        this.Modelo = modelo;
        
        modelo.obtenerMisiones(vistas.cmbMision);
        modelo.obtenerTransporte(vistas.cmbTransporte);
        this.Vistas.btnVerRegistros.addMouseListener(this);
        this.Vistas.btnguardar.addMouseListener(this);
        vistas.imgBack.addMouseListener(this);
        
          Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
        
        
          vistas.cmbTransporte.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        TransporteDisplay transporteSeleccionado = (TransporteDisplay) vistas.cmbTransporte.getSelectedItem(); // Cambiar a BomberoDisplay
        if (transporteSeleccionado != null) {
            Transportes transportes = transporteSeleccionado.getTransportes(); // Obtener el objeto Bomberos
            System.out.println("Transporte seleccionado: " + transportes.getTipoVehiculo_transporte());
            System.out.println("ID Transporte: " + transportes.getId_transporte());
        }
    }
});
       
     vistas.cmbMision.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener el elemento seleccionado del JComboBox
        MisionDisplay misionSeleccionada = (MisionDisplay) vistas.cmbMision.getSelectedItem();
        
        // Comprobar si hay una misión seleccionada
        if (misionSeleccionada != null) {
            // Obtener el objeto Misiones desde MisionDisplay
        Misiones mision = misionSeleccionada.getMision();
        
            
            // Ahora puedes usar los métodos de Misiones sin problemas
            System.out.println("Misión seleccionada: " + mision.getDescripcionMision());
            System.out.println("ID Misión: " + mision.getIdMision());
        }
    }
});
            
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vistas.btnguardar) {
    
        if (Vistas.cmbMision.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(Vistas, "No se puede añadir una misión nula, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Vistas.cmbTransporte.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(Vistas, "No se puede añadir un transporte nulo, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    
    TransporteDisplay transporteSeleccionado = (TransporteDisplay) Vistas.cmbTransporte.getSelectedItem();
    MisionDisplay misionSeleccionada = (MisionDisplay) Vistas.cmbMision.getSelectedItem();

    if (transporteSeleccionado != null && misionSeleccionada != null) {
        int idTransporteSeleccionado = transporteSeleccionado.getId_Transporte();
        int idMisionSeleccionada = misionSeleccionada.getIdMision(); // Asegúrate que este método esté bien implementado

        System.out.println("ID Misión (para guardar): " + idMisionSeleccionada); // Verificación
        System.out.println("ID Bombero (para guardar): " + idTransporteSeleccionado); // Verificación

        // Verifica que el ID de misión y bombero son válidos
        if (idMisionSeleccionada > 0 && idTransporteSeleccionado > 0) {
            Modelo.setId_transporte(idTransporteSeleccionado);
            Modelo.setId_mision(idMisionSeleccionada);

            try {
                Modelo.guardar(); // Asegúrate de que este método esté implementado correctamente
                JOptionPane.showMessageDialog(Vistas, "Información ingresada con éxito", "Agregar transporte", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace(); // Manejo de excepciones
                JOptionPane.showMessageDialog(Vistas, "Error al guardar la información: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("ID Misión o Bombero no válido.");
            JOptionPane.showMessageDialog(Vistas, "ID Misión o Transporte no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        System.out.println("No se ha seleccionado ningún Transporte o misión.");
    }
    
    
        
        String nombreTransporte = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreTransporte);
                  
        String descripcionCambio = "Se ha asignado un tranporte a una mision"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        
        
}
        if(e.getSource()== Vistas.imgBack){
        frmAgregarMision.initFrmAgregarMision();
        Vistas.dispose();
        }
        
        if(e.getSource()== Vistas.btnVerRegistros){
        frmRegistroTransportes.initfrmRegistroTransporte();
        Vistas.dispose();
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
