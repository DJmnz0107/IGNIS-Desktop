/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.MisionDisplay;
import Modelo.MisionesTransporte;
import Modelo.TransporteDisplay;
import Modelo.Usuarios;
import Vistas.frmActualizarMisionTransporte;
import Vistas.frmRegistroTransportes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;

/**
 *
 * @author User
 */
public class ctrlActualizarMisionTransportes implements MouseListener{
    private MisionesTransporte Modelo;
    private frmActualizarMisionTransporte Vistas;
    private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlActualizarMisionTransportes (MisionesTransporte modelo, frmActualizarMisionTransporte vistas){
        
        this.Modelo = modelo;
        this.Vistas = vistas;
        
        vistas.btnVerRegistros.addMouseListener(this);
        vistas.btnActualizar.addMouseListener(this);
        vistas.imgBack.addMouseListener(this);
        Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
            if(e.getSource() == Vistas.imgBack) {
            frmRegistroTransportes.initfrmRegistroTransporte();
            Vistas.dispose();
        }
        
                if(e.getSource() == Vistas.btnVerRegistros) {
            frmRegistroTransportes.initfrmRegistroTransporte();
            Vistas.dispose();
        }
        if(e.getSource() == Vistas.btnActualizar) {
                 if (Vistas.cmbMision.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(Vistas, "No se puede añadir una misión nula, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Vistas.cmbTransporte.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(Vistas, "No se puede añadir un bombero nulo, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
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
            Modelo.setId_misionTransporte(Vistas.obtenerIdRegistro());
            

            try {
                Modelo.actualizarRegistro();// Asegúrate de que este método esté implementado correctamente
                JOptionPane.showMessageDialog(Vistas, "Información actualizada con éxito", "Actualizar Misiones y bomberos", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace(); // Manejo de excepciones
                JOptionPane.showMessageDialog(Vistas, "Error al actualizar la información: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("ID Misión o Bombero no válido.");
            JOptionPane.showMessageDialog(Vistas, "ID Misión o Bombero no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        System.out.println("No se ha seleccionado ningún bombero o misión.");
    }
    
    
        
        String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambio = "Mision transporte actualizada en el sistema"; // Descripción del cambio
        
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
    
}
