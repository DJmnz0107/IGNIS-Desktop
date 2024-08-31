/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class panelRound2 extends JPanel {
    
    private int cornerRadius = 50;  // Radio de las esquinas redondeadas

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public panelRound2() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Crear un rectángulo redondeado que se ajusta al tamaño del panel
        RoundRectangle2D roundRect = new RoundRectangle2D.Double(0, 0, width, height, cornerRadius, cornerRadius);

        // Dibujar el fondo con color y esquinas redondeadas
        g2.setColor(getBackground());
        g2.fill(roundRect);

        g2.dispose();
    }
    
}
