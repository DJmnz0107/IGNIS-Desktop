/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Recursos;
import Vistas.frmAgregarInventario;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ctrlAgregarInventario implements MouseListener {
    private frmAgregarInventario vista;
    private Recursos modelo;
     private String rutaImagenSeleccionada; // Variable para almacenar la ruta de la imagen seleccionada
    
          public ctrlAgregarInventario(frmAgregarInventario vista, Recursos modelo)  {
              this.vista = vista;
              this.modelo = modelo;
              
              vista.btnInsertar.addMouseListener(this);
              vista.dtcRecepcion.setMaxSelectableDate(new Date());
              vista.imgAgregar.addMouseListener(this);  
          }

    @Override
    public void mouseClicked(MouseEvent e) {
        
           if (e.getSource() == vista.btnInsertar) {
            // Comprobar si se ha seleccionado una imagen
            if (rutaImagenSeleccionada == null || rutaImagenSeleccionada.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen antes de insertar.");
                return; // Salir del método si no se ha seleccionado una imagen
            }

            // Obtener los valores de la vista
            String cmbDisponibilidad = (String) vista.cmbDisponibilidad.getSelectedItem();
            String cmbEstado = (String) vista.cmbEstado.getSelectedItem();
            String txtDescripcionRecurso = vista.txtDescripcionRecurso.getText();
            String txtNombreInventario = vista.txtNombreInventario.getText();
            java.util.Date fechaRecepcion = vista.dtcRecepcion.getDate();

          if (rutaImagenSeleccionada == null || rutaImagenSeleccionada.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen antes de insertar.");
                return; 
            }
            if (fechaRecepcion == null) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha.");
                return; 
            }
            
            if(txtNombreInventario.isEmpty() || txtDescripcionRecurso.isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Por favor, llena todos los campos.");
                 return;
            }
            // Establecer los valores en el modelo
            modelo.setNombreRecurso(txtNombreInventario);
            modelo.setDescripcionRecurso(txtDescripcionRecurso);
            modelo.setFechaRecepcionRecurso(fechaRecepcion);
            modelo.setDisponibilidadRecurso(cmbDisponibilidad);
            modelo.setEstadoRecurso(cmbEstado);

            // Insertar el recurso en la base de datos con la ruta de la imagen seleccionada
            modelo.insertarRecurso(rutaImagenSeleccionada); 
            JOptionPane.showMessageDialog(vista, "Recurso ingresado exitosamente.");
            limpiarCampos();
        } 
        // Detectar si el clic fue en imgAgregar para seleccionar la imagen
        else if (e.getSource() == vista.imgAgregar) {
            seleccionarImagen();  // Llamar al método que abre el JFileChooser para seleccionar la imagen
        }
  
    }
    
    private void limpiarCampos() {
    vista.txtNombreInventario.setText("");
    vista.txtDescripcionRecurso.setText("");
    vista.cmbDisponibilidad.setSelectedIndex(0);
    vista.cmbEstado.setSelectedIndex(0); 
    vista.dtcRecepcion.setDate(null); 
    vista.imgAgregar.setIcon(null);
}
    
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            rutaImagenSeleccionada = archivoSeleccionado.getAbsolutePath(); // Guardar la ruta de la imagen seleccionada

            // Mostrar la ruta de la imagen seleccionada
            System.out.println("Imagen seleccionada: " + rutaImagenSeleccionada);

            // Actualizar el JLabel con la imagen seleccionada
            vista.imgRecurso.setIcon(redimensionarImagen(rutaImagenSeleccionada, 150, 150));
        }
    }
    
    private ImageIcon redimensionarImagen(String rutaImagen, int ancho, int alto) {
    ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
    Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    return new ImageIcon(imagenEscalada);
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
