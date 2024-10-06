/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MisionesRecursos;
import Vistas.frmAsignarRecursosVer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author USUARIO
 */
public class ctrlAsignarRecursosVer implements MouseListener{
    
    private frmAsignarRecursosVer vista;
    private MisionesRecursos modelo;
    
    
    
    public ctrlAsignarRecursosVer(frmAsignarRecursosVer vista,MisionesRecursos modelo ){
    this.modelo = modelo;
    this.vista = vista;
    modelo.Mostrar(vista.jtbVerAsignarRecu);
    vista.btnActualizar.addMouseListener(this);
    vista.btnEliminar.addMouseListener(this);
    
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
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
