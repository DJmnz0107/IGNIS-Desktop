/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;

public class btnInicio4 extends JButton {
    
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

    public btnInicio4() {
        fillOriginal = new Color(0xC06D3A); // Color de fondo original
        fillOver = new Color(0xA65E2D); // Color de fondo cuando el mouse está sobre el botón
        fillClick = new Color(0xC06D3A); // Color de fondo cuando el botón está presionado

        fill = fillOriginal;
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

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el fondo redondeado
        int s = strokeWidth;
        int w = getWidth() - (2 * s);
        int h = getHeight() - (2 * s);
        int arcW = h / 2; // Radio de curvatura ajustado para hacer más rectangular
        int arcH = h / 2;

        g2d.setColor(fill);
        g2d.fillRoundRect(s, s, w, h, arcW, arcH);

        // Configurar el icono
        int iconWidth = 0;
        int iconHeight = 0;

        if (icon != null) {
            iconWidth = icon.getIconWidth();
            iconHeight = icon.getIconHeight();
            int iconX = getWidth() - iconWidth - 10; // Margen de 10px desde el borde derecho
            int iconY = (getHeight() - iconHeight) / 2; // Centrar verticalmente
            icon.paintIcon(this, g2d, iconX, iconY);
        }

        // Configurar el texto
        String text = getText();
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);

        // Calcular la posición del texto
        int textMargin = 10; // Margen adicional desde el borde izquierdo
        int textX = (getWidth() - textWidth - iconWidth - 2 * textMargin) / 2; // Ajustar margen izquierdo del texto
        int textY = (getHeight() + fm.getAscent()) / 2; // Centrar verticalmente el texto

        // Dibujar el texto
        g2d.setColor(getForeground());
        g2d.drawString(text, textX, textY);

        g2d.dispose(); // Liberar recursos gráficos
    }
    
}
