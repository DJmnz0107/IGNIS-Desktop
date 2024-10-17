/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Bomberos;
import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Usuarios;
import Vistas.frmActualizarBomberos;
import Vistas.frmAgregarBomberos;
import Vistas.frmRegistroBomberos;
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
 * @author User
 */
public class ctrlActualizarBomberos implements MouseListener{
    
    private Bomberos Modelo;
    private frmActualizarBomberos Vistas;
    private String rutaImagenSeleccionada;
                 private static EmergenciaController controller; // Mueve el controlador a un campo estático
    
    
    public ctrlActualizarBomberos( Bomberos modelo, frmActualizarBomberos vistas){
    
        this.Modelo = modelo;
        this.Vistas = vistas;
        
        this.Vistas.btnActualizar.addMouseListener(this);
        this.Vistas.btnAgregarFoto1.addMouseListener(this);
        this.Vistas.btnMenu.addMouseListener(this);
        this.Vistas.btnVerRegistro.addMouseListener(this);
        this.Vistas.imgBack.addMouseListener(this);
        
                    Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
        
          rutaImagenSeleccionada = vistas.obtenerRutaImagen();
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()== Vistas.btnVerRegistro){
            frmRegistroBomberos.initfrmRegistroBomberos();
            Vistas.dispose();
            
        }
        
        if(e.getSource()== Vistas.imgBack){
            frmAgregarBomberos.initfrmAgregarBomberos();
            Vistas.dispose();
        }
                if(e.getSource() == Vistas.btnActualizar) {
            
           
             
            if(Vistas.txtNombreBombero.getText().isEmpty() || Vistas.txtApellidoBombero.getText().isEmpty() || Vistas.txtExperiencia.getText().isEmpty() || Vistas.txtEspecializacion.getText().isEmpty() ) {
                 JOptionPane.showMessageDialog(Vistas, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay campos vacíos
            }
            

            
            
              if (Vistas.cmbUsuario.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(Vistas, "No se puede añadir un bombero nulo, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
              
            
             if (rutaImagenSeleccionada == null || rutaImagenSeleccionada.isEmpty()) { 
    JOptionPane.showMessageDialog(Vistas, "Debes seleccionar una imagen antes de actualizar", "Error", JOptionPane.ERROR_MESSAGE);
    return;  // Salir del método si no se seleccionó una imagen
}

               
               
        Bomberos bomberoSeleccionado = (Bomberos) Vistas.cmbUsuario.getSelectedItem();
        int idUsuario = bomberoSeleccionado.getId_usuario();
        Modelo.setNombre_bombero(Vistas.txtNombreBombero.getText());
        Modelo.setApellido_bombero(Vistas.txtApellidoBombero.getText());
        Modelo.setExperiencia_bombero(Vistas.txtExperiencia.getText());
        Modelo.setEspecializacion_bombero(Vistas.txtEspecializacion.getText());
        Modelo.setId_usuario(idUsuario);
        Modelo.setId_bombero(Vistas.obtenerIdBombero());
        Modelo.actualizarBomberos(rutaImagenSeleccionada);
        JOptionPane.showMessageDialog(Vistas, "Bombero actualizado exitosamente.");
        Modelo.Limpiar(Vistas);
        
        
        String txtNombreBombero = Modelo.getNombre_bombero();
        
        String nombreUsuario = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreUsuario);
                  
        String descripcionCambio = "Bombero " + txtNombreBombero + " Actualizado en el sistema"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        
        System.out.println("El nombre del bombero es: " + txtNombreBombero);
        
                }
                
           if(e.getSource() == Vistas.btnAgregarFoto1) {
            seleccionarImagen();
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
