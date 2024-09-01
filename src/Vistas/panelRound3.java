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
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

       
        Path2D path = new Path2D.Double();
        path.moveTo(roundTopLeft, 0); 
        path.lineTo(width - roundTopRight, 0); 
        path.quadTo(width, 0, width, roundTopRight); 
        path.lineTo(width, height - roundBottomRight); 
        path.quadTo(width, height, width - roundBottomRight, height); 
        path.lineTo(roundBottomLeft, height); 
        path.quadTo(0, height, 0, height - roundBottomLeft); 
        path.lineTo(0, roundTopLeft); 
        path.quadTo(0, 0, roundTopLeft, 0); 

       
        g2.setColor(getBackground());
        g2.fill(path);

        g2.dispose();
    }
}
