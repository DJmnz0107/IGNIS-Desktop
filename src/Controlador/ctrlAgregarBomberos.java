/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Bomberos;
import Vistas.frmAgregarBomberos;
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
 * @author User
 */
public class ctrlAgregarBomberos implements MouseListener{
    private Bomberos Modelo;
    private frmAgregarBomberos Vistas;
    private String rutaImagenSeleccionada;
    
    public ctrlAgregarBomberos(Bomberos modelo, frmAgregarBomberos vistas){
    
        this.Modelo = modelo;
        this.Vistas = vistas;
        
        this.Vistas.cmbUsuario.addMouseListener(this);
        this.Modelo.CargarComboUsuarios(Vistas.cmbUsuario);
        this.Vistas.btnAgregarFoto1.addMouseListener(this);
        this.Vistas.btnAgregarInfo1.addMouseListener(this);
        this.Vistas.btnMenu.addMouseListener(this);
        
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource() == Vistas.btnMenu){
           Drawer.getInstance().showDrawer();
       }
        
        if(e.getSource() == Vistas.btnAgregarFoto1){
            seleccionarImagen();
        }
        
        
        if (e.getSource() == Vistas.btnAgregarInfo1) {
            
            if(Vistas.txtNombreBombero.getText().isEmpty() || Vistas.txtApellidoBombero.getText().isEmpty() || Vistas.txtEspecializacion.getText().isEmpty() || Vistas.txtExperiencia.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(Vistas, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay campos vacíos
            }
               if (rutaImagenSeleccionada == null || rutaImagenSeleccionada.isEmpty()) {
              JOptionPane.showMessageDialog(Vistas, "Debes seleccionar una imagen antes de actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
              
        Bomberos seleccionado = (Bomberos) Vistas.cmbUsuario.getSelectedItem();
        if (seleccionado != null) {
            int idUsuario = seleccionado.getId_usuario();
            System.out.println("ID del bombero seleccionado: " + idUsuario);
            
            // En este apartado profesores establecemos el id del bobmero seleccionado
            Modelo.setId_usuario(idUsuario);
        } else {
            System.out.println("No se ha seleccionado ningún bombero.");
        }

        // es para hacerle el set en los get hacia las bases de datos, traemos los textos escritos en los textfields con los getText
        Modelo.setNombre_bombero(Vistas.txtNombreBombero.getText());
        Modelo.setApellido_bombero(Vistas.txtApellidoBombero.getText());
        Modelo.setExperiencia_bombero(Vistas.txtExperiencia.getText());
        Modelo.setEspecializacion_bombero(Vistas.txtEspecializacion.getText());
        //y el metodo guardar para insertar a la base de datos 
        Modelo.Guardar(rutaImagenSeleccionada);
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
            Vistas.lblFoto.setIcon(redimensionarImagen(rutaImagenSeleccionada, 150, 150));
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