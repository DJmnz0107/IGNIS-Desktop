/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Diego
 */
public class imgRedondeada {
    
 // Convierte un ImageIcon a BufferedImage
    public static BufferedImage toBufferedImage(ImageIcon img) {
        // Comprueba si el ImageIcon tiene una imagen válida
        if (img == null || img.getImage() == null) {
            return null; // Manejo de errores: retorna null si no hay imagen
        }
        
        // Si ya es un BufferedImage, lo retorna directamente
        if (img.getImage() instanceof BufferedImage) {
            return (BufferedImage) img.getImage();
        }

        // Crea un nuevo BufferedImage
        BufferedImage bimage = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img.getImage(), 0, 0, null); // Usa getImage() para obtener la imagen
        bGr.dispose();

        return bimage;
    }
// Crea una imagen circular a partir de un BufferedImage
public static BufferedImage makeCircularImage(BufferedImage image, int targetWidth, int targetHeight) {
    // Asegúrate de que la imagen original tenga dimensiones cuadradas
    int originalWidth = image.getWidth();
    int originalHeight = image.getHeight();
    
    // Redimensionar la imagen manteniendo la relación de aspecto
    BufferedImage scaledImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = scaledImage.createGraphics();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    // Calcular el ratio para escalar
    double scale = Math.min((double)targetWidth / originalWidth, (double)targetHeight / originalHeight);
    int newWidth = (int)(originalWidth * scale);
    int newHeight = (int)(originalHeight * scale);
    
    // Centrar la imagen escalada
    int x = (targetWidth - newWidth) / 2;
    int y = (targetHeight - newHeight) / 2;
    
    // Dibujar la imagen redimensionada
    g2d.drawImage(image, x, y, newWidth, newHeight, null);
    g2d.dispose();

    // Crear la imagen circular
    BufferedImage circularImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
    g2d = circularImage.createGraphics();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    // Crear un círculo como máscara
    g2d.setClip(new Ellipse2D.Double(0, 0, targetWidth, targetHeight));
    
    // Dibujar la imagen escalada en la máscara circular
    g2d.drawImage(scaledImage, 0, 0, null);
    g2d.dispose();

    return circularImage;
}


    
}
