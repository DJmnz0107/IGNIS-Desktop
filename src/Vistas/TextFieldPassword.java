/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Diego
 */
public class TextFieldPassword extends JPasswordField {
     private String hint;
    private Icon eyeOpenIcon;
    private Icon eyeClosedIcon;
    private boolean passwordVisible = false;
    private Icon prefixIcon;
    private Icon suffixIcon;

    public TextFieldPassword() {
      eyeOpenIcon = new ImageIcon(getClass().getResource("/vistas/resources/eyeNew.png"));
        eyeClosedIcon = new ImageIcon(getClass().getResource("/vistas/resources/eyeClosedNew.png"));

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        initUI();
        initIcon();
    }
    
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
         repaint(); 

    }

    private void initUI() {
        setForeground(Color.WHITE);
        setBackground(new Color(0, 0, 0, 0)); 
        setOpaque(false);
        setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 22));
        setEchoChar('*'); 
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
   
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g.create();

    g2.setColor(new Color(0xF5D863)); 

    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

    if (getPassword().length == 0 && !isFocusOwner() && hint != null) {
        g2.setColor(new Color(0xf7e3c6));
        g2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 22));
        FontMetrics fontMetrics = g2.getFontMetrics();
        int hintWidth = fontMetrics.stringWidth(hint);
        int hintHeight = fontMetrics.getHeight();
        int x = (getWidth() - hintWidth) / 6;
        int y = (getHeight() - hintHeight) / 2 + fontMetrics.getAscent();
        g2.drawString(hint, x, y);
    }

    paintIcon(g2);

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


    public void setHint(String hint) {
        this.hint = hint;
        repaint(); 
    }
    
  
    


   private void initBorder() {
    int left = 5;
    int right = 5;
    if (prefixIcon != null) {
        left = prefixIcon.getIconWidth() + 5;
    }
    if (suffixIcon != null) {
        right = suffixIcon.getIconWidth() + 5;
    }
    setBorder(BorderFactory.createEmptyBorder(5, left, 5, right));
}


    
 
    
    
}
