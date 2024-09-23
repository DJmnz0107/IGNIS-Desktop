/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Aspirantes;
import Vistas.frmAgregarAspirante;
import Vistas.frmVerRegistroAspirantes;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import raven.drawer.Drawer;


public class ctrlAspirantes implements MouseListener {
    
    private Aspirantes Modelo;
    private frmAgregarAspirante Vistas;
    private String rutaImagenSeleccionada;
    
    public ctrlAspirantes(Aspirantes modelo, frmAgregarAspirante vistas){
        this.Modelo = modelo;
        this.Vistas = vistas; 
        this.Vistas.cmbBomberoMentor.addMouseListener(this);
        this.Modelo.CargarComboBomberos(Vistas.cmbBomberoMentor);
        this.Vistas.btnAñadirInfo.addMouseListener(this);
        this.Vistas.btnAgregarFoto.addMouseListener(this);
        this.Vistas.btnMenu.addMouseListener(this);
        this.Vistas.btnVerAspirantes.addMouseListener(this);
        
         
    
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()==Vistas.btnMenu){
            
             Drawer.getInstance().showDrawer();
        }
        
        if(e.getSource() == Vistas.btnAgregarFoto){
            seleccionarImagen();
        }
        
        if(e.getSource() == Vistas.btnVerAspirantes) {
            frmVerRegistroAspirantes.initfrmVerRegistroAspirantes();
            Vistas.dispose();
        }
        
       if (e.getSource() == Vistas.btnAñadirInfo) {
              if(Vistas.txtApellidoAspirante.getText().isEmpty() || Vistas.txtDuiAspirante.getText().isEmpty() || Vistas.txtEdadAspirante.getText().isEmpty() || Vistas.txtEntrenamientoAspirante.getText().isEmpty() || Vistas.txtNombreAspirante.getText().isEmpty() || Vistas.txtProgresoAspirante.getText().isEmpty() ) {
                 JOptionPane.showMessageDialog(Vistas, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay campos vacíos
            }
              if (Vistas.txtEdadAspirante.getText().length() >= 3) {
                JOptionPane.showMessageDialog(Vistas, "Ingrese una edad valida", "Error", JOptionPane.ERROR_MESSAGE);
             return; 
            // Verificar que el DUI no tenga más de 10 dígitos
            }
              
               if (Vistas.txtDuiAspirante.getText().length() != 10) {
    JOptionPane.showMessageDialog(Vistas, "El DUI debe tener exactamente 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}
                if (Vistas.cmbBomberoMentor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(Vistas, "No se puede añadir un bombero nulo, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
                
                
                
                  String edadText = Vistas.txtEdadAspirante.getText();
                  int edadInt = Integer.parseInt(edadText);
if (edadInt < 18) {
    JOptionPane.showMessageDialog(Vistas, "La edad debe ser mayor o igual a 18", "Edad", JOptionPane.ERROR_MESSAGE);
    return;
}

if (!edadText.matches("\\d+")) {
    JOptionPane.showMessageDialog(Vistas, "Ingrese solo números", "Edad aspirante", JOptionPane.ERROR_MESSAGE);
    return;
}

           
               if (rutaImagenSeleccionada == null || rutaImagenSeleccionada.isEmpty()) {
              JOptionPane.showMessageDialog(Vistas, "Debes seleccionar una imagen antes de actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
              
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
        //y el metodo guardar para insertar a la base de datos :D
        Modelo.Guardar(rutaImagenSeleccionada);
        JOptionPane.showMessageDialog(Vistas, "Aspirante ingresado exitosamente.");
        Modelo.Limpiar(Vistas);
        
        
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
            Vistas.imgAspirante.setIcon(redimensionarImagen(rutaImagenSeleccionada, 150, 150));
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
