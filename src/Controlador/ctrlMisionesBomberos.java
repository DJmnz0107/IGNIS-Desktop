
package Controlador;

import Modelo.MisionesBomberos;
import Vistas.frmRegistroMisionesBomberos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlMisionesBomberos implements MouseListener, KeyListener {
    
    private MisionesBomberos modelo; 
    private  frmRegistroMisionesBomberos Vista;
    
    public ctrlMisionesBomberos (MisionesBomberos modelo, frmRegistroMisionesBomberos Vista){
    
        this.modelo = modelo;
        this.Vista = Vista;
        Vista.txtBuscar.addKeyListener(this);
        Vista.btnEliminar.addMouseListener(this);
        Vista.imgBack.addMouseListener(this);
        modelo.Mostrar(Vista.jtMisionesBomberos);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vista.btnEliminar){
            modelo.Eliminar(Vista.jtMisionesBomberos);
            modelo.Mostrar(Vista.jtMisionesBomberos);
        }
        if(e.getSource() == Vista.imgBack){
            Vista.dispose();
            frmRegistroMisionesBomberos.initfrmRegistroMisionesBomberos();
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
            modelo.Buscar(Vista.jtMisionesBomberos, Vista.txtBuscar);
        }
    }
}
