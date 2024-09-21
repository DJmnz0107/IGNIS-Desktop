/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Aspirantes;
import Vistas.frmAgregarAspirante;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ctrlAspirantes implements MouseListener {
    
    private Aspirantes Modelo;
    private frmAgregarAspirante Vistas;
    
    public ctrlAspirantes(Aspirantes modelo, frmAgregarAspirante vistas){
        this.Modelo = modelo;
        this.Vistas = vistas; 
        this.Vistas.cmbBomberoMentor.addMouseListener(this);
        this.Modelo.CargarComboBomberos(Vistas.cmbBomberoMentor);
        this.Vistas.btnAñadirInfo.addMouseListener(this);
        
    
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
       if (e.getSource() == Vistas.btnAñadirInfo) {
        Aspirantes seleccionado = (Aspirantes) Vistas.cmbBomberoMentor.getSelectedItem();
        if (seleccionado != null) {
            int idBomberoSeleccionado = seleccionado.getId_bombero();
            System.out.println("ID del bombero seleccionado: " + idBomberoSeleccionado);
            
            // En este apartado profesores establecemos el id del bobmero seleccionado
            Modelo.setId_bombero(idBomberoSeleccionado);
        } else {
            System.out.println("No se ha seleccionado ningún bombero.");
        }

        // es para hacerle el set en los get hacia las bases de datos, traemos los textos escritos en los textfields con los getText
        Modelo.setNombre_aspirante(Vistas.txtNombreAspirante.getText());
        Modelo.setApellido_aspirante(Vistas.txtApellidoAspirante.getText());
        Modelo.setDui_aspirante(Vistas.txtDuiAspirante.getText());
        Modelo.setEntrenamiento_aspirante(Vistas.txtEntrenamientoAspirante.getText());

        // sirve para convertir la edad que pedimos en INT y no en cadena de texto string
        try {
            int edad = Integer.parseInt(Vistas.txtEdadAspirante.getText());
            Modelo.setEdad_usuario(edad);
        } catch (NumberFormatException ex) {
            System.out.println("Error: La edad ingresada no es un número o no es válida.");
            JOptionPane.showMessageDialog(null, "Por favor, ingresa una edad válida.");
        }

        Modelo.setProgreso_aspirante(Vistas.txtProgresoAspirante.getText());
        Modelo.setFoto_aspirante(Vistas.txtFoto.getText());
        //y el metodo guardar para insertar a la base de datos :D
        Modelo.Guardar();
        Modelo.Limpiar(Vistas);
        
        
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
