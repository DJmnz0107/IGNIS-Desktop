/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Aspirantes;
import Modelo.CambioSistema;
import Modelo.Usuarios;
import Vistas.frmActualizarAspirante;
import Vistas.frmVerRegistroAspirantes;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import raven.drawer.Drawer;

/**
 *
 * @author Diego
 */
public class ctrlActualizarAspirantes implements MouseListener {
    
    private Aspirantes modelo;
    private frmActualizarAspirante vista;
     private String rutaImagenSeleccionada;
     
     public ctrlActualizarAspirantes(Aspirantes modelo, frmActualizarAspirante vista ) {
         this.vista = vista;
         this.modelo = modelo;
         
        
         
         vista.btnAgregarFoto.addMouseListener(this);
         vista.btnMenu.addMouseListener(this);
         vista.btnActualizar.addMouseListener(this);
         vista.imgBack.addMouseListener(this);
         vista.btnVerAspirantes.addMouseListener(this);
         
         
             rutaImagenSeleccionada = vista.obtenerRutaImagen();

     }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnVerAspirantes) {
            frmVerRegistroAspirantes.initfrmVerRegistroAspirantes();
            vista.dispose();
        }
        
        if(e.getSource() == vista.imgBack) {
               frmVerRegistroAspirantes.initfrmVerRegistroAspirantes();
            vista.dispose();
        }
        
        if(e.getSource() == vista.btnMenu) {
            Drawer.getInstance().showDrawer();
        }
        
        if(e.getSource() == vista.btnActualizar) {
            
           
             
            if(vista.txtApellidoAspirante.getText().isEmpty() || vista.txtDuiAspirante.getText().isEmpty() || vista.txtEdadAspirante.getText().isEmpty() || vista.txtEntrenamientoAspirante.getText().isEmpty() || vista.txtNombreAspirante.getText().isEmpty() || vista.txtProgresoAspirante.getText().isEmpty() ) {
                 JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay campos vacíos
            }
            
              String edadText = vista.txtEdadAspirante.getText();

if (!edadText.matches("\\d+")) {
    JOptionPane.showMessageDialog(vista, "Ingrese solo números", "Edad aspirante", JOptionPane.ERROR_MESSAGE);
    return;
}
            
            if (vista.txtEdadAspirante.getText().length() >= 3) {
                JOptionPane.showMessageDialog(vista, "Ingrese una edad valida", "Error", JOptionPane.ERROR_MESSAGE);
             return; 
            // Verificar que el DUI no tenga más de 10 dígitos
            }
            int edadInt = Integer.parseInt(edadText);
if (edadInt < 18) {
    JOptionPane.showMessageDialog(vista, "La edad debe ser mayor o igual a 18", "Edad", JOptionPane.ERROR_MESSAGE);
    return;
}

   
            
              if (vista.cmbBomberoMentor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir un bombero nulo, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
            if (vista.txtDuiAspirante.getText().length() != 10) {
    JOptionPane.showMessageDialog(vista, "El DUI debe tener exactamente 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}
            
            
     
            
             if (rutaImagenSeleccionada == null || rutaImagenSeleccionada.isEmpty()) { 
    JOptionPane.showMessageDialog(vista, "Debes seleccionar una imagen antes de actualizar", "Error", JOptionPane.ERROR_MESSAGE);
    return;  // Salir del método si no se seleccionó una imagen
}

               
               
                       Aspirantes bomberoSeleccionado = (Aspirantes) vista.cmbBomberoMentor.getSelectedItem();
        int idBombero = bomberoSeleccionado.getId_bombero();
        modelo.setNombre_aspirante(vista.txtNombreAspirante.getText());
        modelo.setApellido_aspirante(vista.txtApellidoAspirante.getText());
        modelo.setDui_aspirante(vista.txtDuiAspirante.getText());
        modelo.setEntrenamiento_aspirante(vista.txtEntrenamientoAspirante.getText());
        modelo.setEdad_usuario(Integer.parseInt(vista.txtEdadAspirante.getText()));
        modelo.setProgreso_aspirante(vista.txtProgresoAspirante.getText());
        modelo.setId_bombero(idBombero);
        modelo.setId_aspirante(vista.obtenerIdAspirante());
        modelo.actualizarAspirante(rutaImagenSeleccionada);
                    JOptionPane.showMessageDialog(vista, "Aspirante actualizado exitosamente.");
        modelo.Limpiar(vista);
        

        
        String nombreUsuario = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idUsuario = usuario.obtenerIdUsuario(nombreUsuario);
                  
        String descripcionCambio = "Un aspirante ha sido actualizado en el sistema"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idUsuario, descripcionCambio);
        
        
        
        
        }
        
        if(e.getSource() == vista.btnAgregarFoto) {
            seleccionarImagen();
        }
        
    }
    
    //Metodo para seleccionar una imagen
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
            vista.imgAspirante.setIcon(redimensionarImagen(rutaImagenSeleccionada, 150, 150));
        } else {
            System.out.println("Formato de imagen no válido. Seleccione un archivo con extensión .jpg, .png o .gif.");
            JOptionPane.showMessageDialog(null, "Formato de imagen no válido. Seleccione un archivo con extensión .jpg, .png o .gif.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
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
