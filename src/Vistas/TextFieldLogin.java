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
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Diego
 */
public class TextFieldLogin extends JTextField {
    
    private String hint ;

    
   

   public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
        initBorder();
    }

    public Icon getSuffixIcon() {
        return suffixIcon;
    }

    public void setSuffixIcon(Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
        initBorder();
    }

    private Icon prefixIcon;
    private Icon suffixIcon;

    public TextFieldLogin() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        initUI();
    }
    
    private void initUI() {

        setForeground(Color.WHITE);

        setBackground(new Color(0, 0, 0, 0));

        setOpaque(false);
        
        setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 22));


    }
    public void setHint(String hint) {
    this.hint = hint;
    repaint(); 
}
    

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
       
  if (getText().isEmpty() && !isFocusOwner() && hint != null) {
        g2.setColor(new Color(0xf7e3c6));
        g2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 22));

       FontMetrics fontMetrics = g2.getFontMetrics();
        int hintWidth = fontMetrics.stringWidth(hint);
        int hintHeight = fontMetrics.getHeight();

        int x = (getWidth() - hintWidth) / 6;
        int y = (getHeight() - hintHeight) / 2 + fontMetrics.getAscent();

        g2.drawString(hint, x, y);
    }
    g2.setColor(new Color(0xF5D863));
    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        super.paintComponent(g);
        paintIcon(g);
        if (isFocusOwner()) {
                        g.setColor(new Color(0xF5D863));
       
        } else {
             g.setColor(new Color(0xF5D863));


        }
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (prefixIcon != null) {
            Image prefix = ((ImageIcon) prefixIcon).getImage();
            int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
            g2.drawImage(prefix, 3, y, this);
        }
        if (suffixIcon != null) {
            Image suffix = ((ImageIcon) suffixIcon).getImage();
            int y = (getHeight() - suffixIcon.getIconHeight()) / 2;
            g2.drawImage(suffix, getWidth() - suffixIcon.getIconWidth() - 3, y, this);
        }
    }

    private void initBorder() {
        int left = 5;
        int right = 5;
        //  5 is default
        if (prefixIcon != null) {
            //  prefix is left
            left = prefixIcon.getIconWidth() + 5;
        }
        if (suffixIcon != null) {
            //  suffix is right
            right = suffixIcon.getIconWidth() + 5;
        }
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, left, 5, right));
    }

                
                
                
        
   
    
   
        
    
}
