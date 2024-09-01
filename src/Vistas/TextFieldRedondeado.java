/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author angel
 */
public class TextFieldRedondeado extends JTextField{

    
    public TextFieldRedondeado() {
        setOpaque(false); 
        setBorder(null); 
        setBackground(new Color(0, 0, 0, 0)); 
        setForeground(Color.BLACK); 
        setHorizontalAlignment(JTextField.CENTER);
        setSelectionColor(new Color(0, 120, 215)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getHeight()));

        
        g2.setColor(Color.BLACK);
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, getHeight(), getHeight()));

        super.paintComponent(g2); 

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setOpaque(false); 
        setBorder(null); 
    }
}
