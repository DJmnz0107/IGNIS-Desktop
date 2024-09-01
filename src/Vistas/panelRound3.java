/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.JPanel;

public class panelRound3 extends JPanel {
     private int roundTopLeft = 0;
    private int roundTopRight = 50;
    private int roundBottomLeft = 50;
    private int roundBottomRight = 0;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    public panelRound3() {
        setOpaque(false); // Para hacer que el fondo sea transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama a super.paintComponent para mantener la pintura adecuada

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Crear un Path2D para dibujar el área con esquinas redondeadas y rectas
        Path2D path = new Path2D.Double();
        path.moveTo(roundTopLeft, 0); // Esquina superior izquierda
        path.lineTo(width - roundTopRight, 0); // Borde superior
        path.quadTo(width, 0, width, roundTopRight); // Esquina superior derecha
        path.lineTo(width, height - roundBottomRight); // Borde derecho
        path.quadTo(width, height, width - roundBottomRight, height); // Esquina inferior derecha
        path.lineTo(roundBottomLeft, height); // Borde inferior
        path.quadTo(0, height, 0, height - roundBottomLeft); // Esquina inferior izquierda
        path.lineTo(0, roundTopLeft); // Borde izquierdo
        path.quadTo(0, 0, roundTopLeft, 0); // Cerrar el camino a la esquina superior izquierda

        // Rellenar el área con el color de fondo del panel
        g2.setColor(getBackground());
        g2.fill(path);

        g2.dispose();
    }
}
