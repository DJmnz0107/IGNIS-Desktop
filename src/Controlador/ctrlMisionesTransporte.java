/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MisionesTransporte;
import Vistas.frmAgregarMision;
import Vistas.frmRegistroTransportes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author danie
 */
public class ctrlMisionesTransporte implements MouseListener, KeyListener {
    
    private MisionesTransporte modelo; 
    private  frmRegistroTransportes Vista;
    
    public ctrlMisionesTransporte (MisionesTransporte modelo, frmRegistroTransportes Vista){
    
        this.modelo = modelo;
        this.Vista = Vista;
        Vista.txtBuscar.addKeyListener(this);
        Vista.btnEliminar.addMouseListener(this);
        Vista.imgBack.addMouseListener(this);
        modelo.Mostrar(Vista.jtRegistroTransporte);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vista.btnEliminar){
            modelo.Eliminar(Vista.jtRegistroTransporte);
            modelo.Mostrar(Vista.jtRegistroTransporte);
        }
        if(e.getSource() == Vista.imgBack){
            Vista.dispose();
            frmAgregarMision.initFrmAgregarMision();
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
