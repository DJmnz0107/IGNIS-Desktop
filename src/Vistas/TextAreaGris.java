package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

/**
 *
 * @author User
 */
public class TextAreaGris extends JTextArea {

    private String hint;
    private Icon prefixIcon;
    private Icon suffixIcon;

    public TextAreaGris() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        initUI();
    }

    private void initUI() {
        setForeground(Color.WHITE); // Color del texto
        setBackground(new Color(0xD9D9D9)); // Fondo del TextArea en color gris claro
        setOpaque(false); // Para que sea transparente y podamos ver el fondo personalizado
        setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 22));
        setLineWrap(true); // Ajusta el texto a la siguiente línea
        setWrapStyleWord(true); // Ajusta el texto por palabra completa
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
    }

    public void setHint(String hint) {
        this.hint = hint;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Dibujar el fondo con bordes redondeados
        g2.setColor(new Color(0xD9D9D9)); // Fondo gris claro
        int arcWidth = 25;  // Ancho del radio (curvatura horizontal)
        int arcHeight = 25; // Alto del radio (curvatura vertical)
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        // Dibujar el hint si el área está vacía y no tiene el foco
        if (getText().isEmpty() && !isFocusOwner() && hint != null) {
            g2.setColor(new Color(0xf7e3c6)); // Color del hint
            g2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 22));
            FontMetrics fontMetrics = g2.getFontMetrics();
            int hintWidth = fontMetrics.stringWidth(hint);
            int hintHeight = fontMetrics.getHeight();
            int x = (getWidth() - hintWidth) / 6;
            int y = (getHeight() - hintHeight) / 2 + fontMetrics.getAscent();
            g2.drawString(hint, x, y);
        }

        // Dibujar el borde redondeado
        g2.setColor(new Color(0xD9D9D9)); // Color del borde
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);

        super.paintComponent(g);
        paintIcon(g);

        // Color del borde según el estado de foco
        if (isFocusOwner()) {
            g.setColor(new Color(0xD9D9D9)); // Color del borde cuando el campo está enfocado
        } else {
            g.setColor(new Color(0xD9D9D9)); // Color del borde cuando el campo no está enfocado
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
        // Ajusta los bordes dependiendo de si hay iconos de prefijo o sufijo
        if (prefixIcon != null) {
            left = prefixIcon.getIconWidth() + 5;
        }
        if (suffixIcon != null) {
            right = suffixIcon.getIconWidth() + 5;
        }
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, left, 5, right));
    }
}
