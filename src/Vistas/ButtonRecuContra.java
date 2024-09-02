/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;

public class ButtonRecuContra extends JButton {
    private boolean over;
    private Color fill;
    private Color line;

    private Color fillOriginal;
    private Color fillOver;
    private Color fillClick;
    private Color lineOriginal;
    private Color lineOver;
    private int strokeWidth;
    private Icon icon;

    public ButtonRecuContra() {
        fillOriginal = new Color(0xF3A462); // Color de fondo original (naranja claro)
        fillOver = new Color(0xE59255); // Color de fondo al pasar el ratón (naranja más oscuro)
        fillClick = new Color(0xC27E47); // Color de fondo al hacer clic (naranja aún más oscuro)
        lineOriginal = fillOriginal;
        lineOver = fillOver;
        line = lineOriginal;
        fill = fillOriginal;
        strokeWidth = 1; // Grosor del borde

        setOpaque(false);
        setBorder(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBackground(fillOriginal);
        setForeground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                fill = fillOriginal;
                line = lineOriginal;
                over = false;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fill = fillOver;
                line = lineOver;
                over = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (over) {
                    fill = fillOver;
                    line = lineOver;
                } else {
                    fill = fillOriginal;
                    line = lineOriginal;
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                fill = fillClick;
                repaint();
            }
        });
    }

    @java.beans.BeanProperty
    public void setIcon(Icon icon) {
        this.icon = icon;
        repaint();
    }

    public Icon getIcon() {
        return icon;
    }

    public Color getFillOriginal() {
        return fillOriginal;
    }

    public void setFillOriginal(Color fillOriginal) {
        this.fillOriginal = fillOriginal;
    }

    public Color getFillOver() {
        return fillOver;
    }

    public void setFillOver(Color fillOver) {
        this.fillOver = fillOver;
    }

    public Color getFillClick() {
        return fillClick;
    }

    public void setFillClick(Color fillClick) {
        this.fillClick = fillClick;
    }

    public Color getLineOriginal() {
        return lineOriginal;
    }

    public void setLineOriginal(Color lineOriginal) {
        this.lineOriginal = lineOriginal;
    }

    public Color getLineOver() {
        return lineOver;
    }

    public void setLineOver(Color lineOver) {
        this.lineOver = lineOver;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int s = strokeWidth;
        int w = getWidth() - (2 * s);
        int h = getHeight() - (2 * s);
        g2d.setColor(fill);
        g2d.fillRoundRect(s, s, w, h, h, h);

        g2d.setStroke(new BasicStroke(s));
        g2d.setColor(line);
        g2d.drawRoundRect(s, s, w, h, h, h);

        int iconWidth = 0;
        int iconHeight = 0;
        int iconX = s; // Posicionar icono al inicio con un margen
        int iconY = (getHeight() - iconHeight) / 2; // Centrar verticalmente

        if (icon != null) {
            iconWidth = icon.getIconWidth();
            iconHeight = icon.getIconHeight();
            icon.paintIcon(this, g2d, iconX, iconY);
        }

        String text = getText();
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textX = iconX + iconWidth + 5; // Posición del texto después del icono con margen de 5px
        int textY = (getHeight() + fm.getAscent()) / 2 - 2; // Centrar verticalmente el texto
        g2d.setColor(getForeground());
        g2d.drawString(text, textX, textY);

        g2d.dispose();
    }
}
