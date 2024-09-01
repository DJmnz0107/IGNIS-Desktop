/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;


public class panelRound2 extends JPanel {
    
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

        Area area = new Area();

       
        area.add(new Area(new RoundRectangle2D.Double(0, 0, roundTopLeft * 2, roundTopLeft * 2, roundTopLeft, roundTopLeft)));
        area.add(new Area(new RoundRectangle2D.Double(width - roundTopRight * 2, 0, roundTopRight * 2, roundTopRight * 2, roundTopRight, roundTopRight)));
        area.add(new Area(new RoundRectangle2D.Double(0, height - roundBottomLeft * 2, roundBottomLeft * 2, roundBottomLeft * 2, roundBottomLeft, roundBottomLeft)));
        area.add(new Area(new RoundRectangle2D.Double(width - roundBottomRight * 2, height - roundBottomRight * 2, roundBottomRight * 2, roundBottomRight * 2, roundBottomRight, roundBottomRight)));

        
        Area rect = new Area(new RoundRectangle2D.Double(0, 0, width, height, 0, 0));
        rect.subtract(new Area(new RoundRectangle2D.Double(0, 0, roundTopLeft * 2, roundTopLeft * 2, roundTopLeft, roundTopLeft)));
        rect.subtract(new Area(new RoundRectangle2D.Double(width - roundTopRight * 2, 0, roundTopRight * 2, roundTopRight * 2, roundTopRight, roundTopRight)));
        rect.subtract(new Area(new RoundRectangle2D.Double(0, height - roundBottomLeft * 2, roundBottomLeft * 2, roundBottomLeft * 2, roundBottomLeft, roundBottomLeft)));
        rect.subtract(new Area(new RoundRectangle2D.Double(width - roundBottomRight * 2, height - roundBottomRight * 2, roundBottomRight * 2, roundBottomRight * 2, roundBottomRight, roundBottomRight)));

        area.add(rect);

        g2.setColor(getBackground());
        g2.fill(area);
        g2.dispose();
    }
    
}
