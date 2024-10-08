/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Modelo.Recursos;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Diego
 */
public class itemRecurso extends javax.swing.JPanel {

    /**
     * Creates new form itemRecurso
     */
    public itemRecurso() {
        initComponents();
         setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }
    
     public Recursos getData() {
        return data;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    private boolean selected;

    private Recursos data;

public void setData(Recursos data) {
 this.data = data;

   int nuevoAncho = 100; 
int nuevoAlto = 100;  

try {
    // Obtener la ruta de la imagen desde el objeto data
    String rutaImagen = data.getFotoRecurso(); // Asegúrate de que contenga la ruta completa

    // Cargar la imagen desde el sistema de archivos
    File file = new File(rutaImagen);
   
    // Verifica si el archivo existe
    if (!file.exists()) {
            imgRecurso.setIcon(new ImageIcon("/Vistas/resources/ignisFormsCircular.png")); // Cambia esto a tu imagen por defecto
            
        System.out.println("No se encontró el archivo en la ruta especificada: " + file.getAbsolutePath());
        // Opcional: puedes asignar una imagen por defecto o dejar el JLabel vacío
    }
    
    // Leer la imagen desde el archivo
    BufferedImage image = ImageIO.read(file);
    
    // Verifica si la imagen se ha leído correctamente
    if (image == null) {
        System.out.println("No se pudo leer la imagen desde la ruta especificada.");
    imgRecurso.setIcon(new ImageIcon("/Vistas/resources/ignisFormsCircular.png")); // Cambia esto a tu imagen por defecto
    }

    // Crear la imagen circular
    BufferedImage circularImage = imgRedondeada.makeCircularImage(image, nuevoAncho, nuevoAlto);
    
    // Asignar la imagen circular al JLabel
    imgRecurso.setIcon(new ImageIcon(circularImage));

} catch (IOException e) {
    // Opcional: puedes manejar la excepción asignando una imagen por defecto
    imgRecurso.setIcon(new ImageIcon("/Vistas/resources/ignisFormsCircular.png")); // Cambia esto a tu imagen por defecto
    
    
}


    // Asignar el nombre del recurso
    lblNombre.setText(data.getNombreRecurso());

    // Asignar la descripción del recurso
    String descripcion = "<html><div style='width: " + lblDescripcion.getWidth() + "px;'>" +
                         data.getDescripcionRecurso() + "</div></html>";
    lblDescripcion.setText(descripcion);
    
    // Asignar el estado del recurso
    lblEstado.setText("Estado: " + data.getEstadoRecurso());

    // Formatear y asignar la fecha de recepción del recurso
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    lblFecha.setText("Fecha de Recepción: " + sdf.format(data.getFechaRecepcionRecurso()));

    String disponibilidad = data.getDisponibilidadRecurso();
    lblDisponibilidad.setText(disponibilidad);
    
    // Cambiar el color del texto de disponibilidad si es necesario
    if ("En uso".equalsIgnoreCase(disponibilidad)) {
        lblDisponibilidad.setForeground(Color.RED);
    } else if ("Disponible".equalsIgnoreCase(disponibilidad)) {
        lblDisponibilidad.setForeground(Color.GREEN); // Color por defecto, ajusta según tus necesidades
    }
}



private ImageIcon redimensionarImagen(String rutaImagen, int ancho, int alto) {
    ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
    Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    return new ImageIcon(imagenEscalada);
}


    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255,173,122));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selected) {
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgRecurso = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDisponibilidad = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 173, 122));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(imgRecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, 106, 130));

        lblFecha.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha de recepción");
        add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 230, 281, -1));

        lblNombre.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Text");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 14, -1, -1));

        lblDisponibilidad.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        lblDisponibilidad.setForeground(new java.awt.Color(255, 255, 255));
        lblDisponibilidad.setText("Disponibilidad");
        add(lblDisponibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        lblDescripcion.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("Descripción del recurso");
        add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 86, 169, 100));

        lblEstado.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado del recurso");
        add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 196, 160, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel imgRecurso;
    public javax.swing.JLabel lblDescripcion;
    public javax.swing.JLabel lblDisponibilidad;
    public javax.swing.JLabel lblEstado;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
