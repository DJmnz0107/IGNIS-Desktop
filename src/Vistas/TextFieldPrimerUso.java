/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.BeanProperty;
import javax.swing.JTextField;

/**
 *
 * @author Diego
 */
public class TextFieldPrimerUso extends JTextField {
    
     private String placeholder = "Placeholder";

    public TextFieldPrimerUso() {
        this("");
    }

    public TextFieldPrimerUso(String placeholder) {
        this.placeholder = placeholder;
        setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
        setForeground(new Color(0xEF8A4C));
        setBackground(Color.WHITE);
        setOpaque(false);
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }
        });
    }

    @BeanProperty(description = "Placeholder text")
    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty() && !isFocusOwner()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(0xEF8A4C));
            g2.setFont(getFont().deriveFont(Font.BOLD));

            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(placeholder);
            int textHeight = fm.getAscent();

            int x = (getWidth() - textWidth) / 8;
            int y = (getHeight() + textHeight) / 2 - fm.getDescent();

            g2.drawString(placeholder, x, y);
            g2.dispose();
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(0xEF8A4C));
        g2.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        g2.dispose();
    }
    
}
