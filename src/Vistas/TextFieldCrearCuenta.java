package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

/**
 *
 * @author aless
 */
public class TextFieldCrearCuenta extends JPasswordField {

    private String hint;
    private Icon eyeOpenIcon;
    private Icon eyeClosedIcon;
    private boolean passwordVisible = false;
    private Icon suffixIcon;

    // Padding
    private final int iconPadding = 10; // Padding para los íconos

    public TextFieldCrearCuenta() {
        // Cargar los íconos desde la carpeta resources
        eyeOpenIcon = new ImageIcon(getClass().getResource("/vistas/resources/blackeye.png")); // Ojo abierto
        eyeClosedIcon = new ImageIcon(getClass().getResource("/vistas/resources/blackClosedEye.png")); // Ojo cerrado

        setBorder(new RoundedBorder(10, new Color(0xEF8A4C), 4));  // Uso de RoundedBorder
        initUI();
        initIcon();
    }

    private void initUI() {
        setForeground(new Color(0xEF8A4C));
        setBackground(Color.WHITE);
        setOpaque(false); 
        setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
        setEchoChar('•');  // Para ocultar el texto
    }

    private void initIcon() {
        suffixIcon = eyeClosedIcon; // Inicia con el ícono del ojo cerrado
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
        int iconX = getWidth() - iconWidth - iconPadding;  // Ajuste para el padding
        int iconY = (getHeight() - iconHeight) / 2;
        return e.getX() >= iconX && e.getX() <= iconX + iconWidth &&
               e.getY() >= iconY && e.getY() <= iconY + iconHeight;
    }

    private void togglePasswordVisibility() {
        passwordVisible = !passwordVisible;
        setEchoChar(passwordVisible ? (char) 0 : '•'); // Cambia entre mostrar/ocultar texto
        setSuffixIcon(passwordVisible ? eyeOpenIcon : eyeClosedIcon); // Cambia el ícono
        repaint(); 
    }

    public void setHint(String hint) {
        this.hint = hint;
        repaint();
    }

    public void setSuffixIcon(Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); // Fondo redondeado

        super.paintComponent(g2);

        if (getPassword().length == 0 && !isFocusOwner() && hint != null) {
            g2.setColor(new Color(0x8E8484)); // Color del hint
            g2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));

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

        // Dibuja el ícono de la derecha (sufijo) con padding
        if (suffixIcon != null) {
            Image suffix = ((ImageIcon) suffixIcon).getImage();
            int y = (getHeight() - suffixIcon.getIconHeight()) / 2;
            g2.drawImage(suffix, getWidth() - suffixIcon.getIconWidth() - iconPadding, y, this); // Padding aplicado
        }
    }

    // Definición de la clase RoundedBorder
    private static class RoundedBorder implements Border {
        private int radius;
        private Color color;
        private int thickness;

        public RoundedBorder(int radius, Color color, int thickness) {
            this.radius = radius;
            this.color = color;
            this.thickness = thickness;
        }

        @Override
        public Insets getBorderInsets(java.awt.Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(java.awt.Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(color);
            g2.setStroke(new java.awt.BasicStroke(thickness));
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);

            g2.dispose();
        }
    }
}