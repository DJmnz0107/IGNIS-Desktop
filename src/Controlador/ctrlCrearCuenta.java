package Controlador;

import Modelo.Niveles;
import Vistas.frmCrearCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlCrearCuenta implements ActionListener {

    private Niveles modelo;
    private frmCrearCuenta vistas;

    public ctrlCrearCuenta(Niveles modelo, frmCrearCuenta vista) {
        this.modelo = modelo;
        this.vistas = vista;
        this.vistas.btnCrearCuenta.addActionListener(this);
        cargarNiveles();
    }

    public void cargarNiveles() {
        modelo.obtenerNiveles(vistas.jcmbTipoUsuario);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistas.btnCrearCuenta) {
            // Acción a realizar cuando se presiona el botón "Crear cuenta"
            Niveles nivelSeleccionado = (Niveles) vistas.jcmbTipoUsuario.getSelectedItem();
            int idNivelSeleccionado = nivelSeleccionado.getId_nivelUsuario();
            System.out.println("ID del nivel seleccionado: " + idNivelSeleccionado);
        }
    }
}
