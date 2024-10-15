/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Recursos;
import Modelo.Usuarios;
import Vistas.frmActualizarInventario;
import Vistas.frmVerInventario;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;

/**
 *
 * @author Diego
 */
public class ctrlActualizarInventario implements MouseListener {
    
    private Recursos modelo;
    private frmActualizarInventario vista;
     private String rutaImagenSeleccionada;
                      private static EmergenciaController controller; // Mueve el controlador a un campo estático

    public ctrlActualizarInventario( Recursos modelo, frmActualizarInventario vista ) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnActualizar.addMouseListener(this);
        vista.btnVerInventario.addMouseListener(this);
        vista.imgAgregar.addMouseListener(this);
        
            rutaImagenSeleccionada = vista.obtenerRutaImagen();
           Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
            System.out.println(vista.obtenerRutaImagen());
        if(e.getSource() == vista.btnActualizar) {
            if(vista.txtDescripcionRecurso.getText().isEmpty() || vista.txtNombreInventario.getText().isEmpty()) {
              JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay campos vacíos
            }
            
              if (rutaImagenSeleccionada == null || rutaImagenSeleccionada.isEmpty()) {
              JOptionPane.showMessageDialog(vista, "Debes seleccionar una imagen antes de actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            if (vista.dtcRecepcion.getDate() == null) {
              JOptionPane.showMessageDialog(vista, "Por favor, selecciona una fecha", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            
            String disponibilidadRecurso = vista.cmbDisponibilidad.getSelectedItem().toString();
            String estadoRecurso = vista.cmbEstado.getSelectedItem().toString();
            
            modelo.setDescripcionRecurso(vista.txtDescripcionRecurso.getText());
            modelo.setNombreRecurso(vista.txtNombreInventario.getText());
            modelo.setEstadoRecurso(estadoRecurso);
            modelo.setDisponibilidadRecurso(disponibilidadRecurso);
            modelo.setFechaRecepcionRecurso(vista.dtcRecepcion.getDate());
            modelo.setIdRecurso(vista.obtenerIdRecurso());
            modelo.actualizarRecurso(rutaImagenSeleccionada);
            JOptionPane.showMessageDialog(vista, "Recurso actualizado exitosamente.");
            limpiarCampos();
            
        String txtNombreRecurso = modelo.getNombreRecurso();
        
        String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambio = "Recurso " + txtNombreRecurso + " Actualizado en el sistema"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        
        System.out.println("El nombre del Recurso es: " + txtNombreRecurso);
        }
        
        if(e.getSource() == vista.imgAgregar) {
            seleccionarImagen();
        }
        
          if(e.getSource() == vista.btnVerInventario) {
           frmVerInventario.initfrmVerInventario();
           vista.dispose();
        }
        
    }
    
  private void seleccionarImagen() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Seleccionar imagen");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    int resultado = fileChooser.showOpenDialog(null);

    if (resultado == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
         rutaImagenSeleccionada = archivoSeleccionado.getAbsolutePath(); // Guardar la ruta de la imagen seleccionada

        // Verificar si el archivo tiene una extensión válida
        if (esFormatoImagenValido(rutaImagenSeleccionada)) {
            // Mostrar la ruta de la imagen seleccionada
            System.out.println("Imagen seleccionada: " + rutaImagenSeleccionada);

            // Actualizar el JLabel con la imagen seleccionada
            vista.imgRecurso.setIcon(redimensionarImagen(rutaImagenSeleccionada, 150, 150));
        } else {
            System.out.println("Formato de imagen no válido. Seleccione un archivo con extensión .jpg, .png o .gif.");
            JOptionPane.showMessageDialog(null, "Formato de imagen no válido. Seleccione un archivo con extensión .jpg, .png o .gif.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}
  
  private void limpiarCampos() {
    vista.txtNombreInventario.setText("");
    vista.txtDescripcionRecurso.setText("");
    vista.cmbDisponibilidad.setSelectedIndex(0);
    vista.cmbEstado.setSelectedIndex(0); 
    vista.dtcRecepcion.setDate(null); 
    vista.imgRecurso.setIcon(null);
}

// Método para verificar si el archivo es de un formato de imagen válido
private boolean esFormatoImagenValido(String rutaImagen) {
    String[] formatosValidos = {".jpg", ".jpeg", ".png", ".gif"};
    for (String formato : formatosValidos) {
        if (rutaImagen.toLowerCase().endsWith(formato)) {
            return true;
        }
    }
    return false;
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
