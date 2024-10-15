/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Aspirantes;
import Modelo.ClaseConexion;
import Vistas.frmAgregarAspirante;
import Vistas.frmSeguimientoAspirante;
import Vistas.frmVerRegistroAspirantes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import modelo.EmergenciaController;
import raven.drawer.Drawer;

/**
 *
 * @author User
 */
public class ctrlSeguimiento implements MouseListener{
    
    private Aspirantes Modelo;
    private frmSeguimientoAspirante Vistas;
                            private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlSeguimiento(Aspirantes modelo, frmSeguimientoAspirante vistas){
        this.Vistas = vistas;
        this.Modelo=  modelo;
        
        this.Vistas.btnMenu.addMouseListener(this);
        this.Vistas.btnVerRegistro.addMouseListener(this);
        this.Vistas.imgBack.addMouseListener(this);
        
               Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
        
        
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == Vistas.imgBack){
            frmAgregarAspirante.initfrmAgregarAspirante();
            Vistas.dispose();
        }
        
        if(e.getSource() == Vistas.btnMenu){
            Drawer.getInstance().showDrawer();
        }
        
        if(e.getSource()== Vistas.btnVerRegistro){
        frmVerRegistroAspirantes.initfrmVerRegistroAspirantes();
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
