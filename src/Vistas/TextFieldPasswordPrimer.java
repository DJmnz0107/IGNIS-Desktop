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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.BeanProperty;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

/**
 *
 * @author Diego
 */
public class TextFieldPasswordPrimer extends JPasswordField {
        private String placeholder = "Placeholder";
        private Icon eyeOpenIcon;
    private Icon eyeClosedIcon;
        private Icon prefixIcon;
    private Icon suffixIcon;
        private boolean passwordVisible = false;


    public TextFieldPasswordPrimer() {
        this("");
        eyeOpenIcon = new ImageIcon(getClass().getResource("/vistas/resources/eyePrimerUso.png"));
        eyeClosedIcon = new ImageIcon(getClass().getResource("/vistas/resources/eyeCerradoPrimer.png"));
        initIcon();
    }
     public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
    }

    public Icon getSuffixIcon() {
        return suffixIcon;
    }

    public void setSuffixIcon(Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
         repaint(); 

    }

    public TextFieldPasswordPrimer(String placeholder) {
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
     private void initIcon() {
        suffixIcon = eyeClosedIcon;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isIconClicked(e)) {
                    togglePasswordVisibility();
                }
            }
        });
    }
     
         private boolean isIconClicked(MouseEvent e) {
        int iconWidth = (suffixIcon != null) ? ((ImageIcon) suffixIcon).getIconWidth() : 0;
        int iconHeight = (suffixIcon != null) ? ((ImageIcon) suffixIcon).getIconHeight() : 0;
        int iconX = getWidth() - iconWidth - 10; 
        int iconY = (getHeight() - iconHeight) / 2;
        return e.getX() >= iconX && e.getX() <= iconX + iconWidth &&
               e.getY() >= iconY && e.getY() <= iconY + iconHeight;
    }
            private void togglePasswordVisibility() {
        passwordVisible = !passwordVisible;
        setEchoChar(passwordVisible ? (char) 0 : '•'); 
        setSuffixIcon(passwordVisible ? eyeOpenIcon : eyeClosedIcon); 
        repaint(); 
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
            Graphics2D g2 = (Graphics2D) g.create();

        if (getPassword().length == 0 && !isFocusOwner()) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(0xEF8A4C));
            g2.setFont(getFont().deriveFont(Font.BOLD));

            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(placeholder);
            int textHeight = fm.getAscent();

            int x = (getWidth() - textWidth) / 2;
            int y = (getHeight() + textHeight) / 2 - fm.getDescent();

            g2.drawString(placeholder, x, y);
        }
        
           if (getPassword().length == 0 && !isFocusOwner() && placeholder != null) {
        g2.setColor(new Color(0xf7e3c6));
        g2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 22));
        FontMetrics fontMetrics = g2.getFontMetrics();
        int hintWidth = fontMetrics.stringWidth(placeholder);
        int hintHeight = fontMetrics.getHeight();
        int x = (getWidth() - hintWidth) / 6;
        int y = (getHeight() - hintHeight) / 2 + fontMetrics.getAscent();
        g2.drawString(placeholder, x, y);
    }
           
    paintIcon(g2);

    g2.dispose(); 
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(0xEF8A4C));
        g2.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        g2.dispose();
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
    
}
