/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Vistas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;


public class btnInicio extends JButton {

   private boolean over;
    private Color fill;
    private Color fillOriginal;
    private Color fillOver;
    private Color fillClick;
    private static final int ICON_SIZE = 40; // Tamaño predeterminado del icono aumentado

    public btnInicio() {
        fillOriginal = new Color(255, 255, 255); // Fondo blanco
        fillOver = new Color(245, 245, 245); // Color al pasar el mouse (ligeramente gris)
        fillClick = new Color(230, 230, 230); // Color al hacer clic (gris más oscuro)
        fill = fillOriginal;

        setOpaque(false);
        setBorder(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBackground(fillOriginal);
        setForeground(new Color(0, 0, 0)); // Color del texto negro

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                fill = fillOriginal;
                over = false;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fill = fillOver;
                over = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                fill = over ? fillOver : fillOriginal;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                fill = fillClick;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arcSize = 30; // Tamaño del redondeo en todas las esquinas
        int w = getWidth();
        int h = getHeight();

        // Crear una forma redondeada
        RoundRectangle2D roundedRect = new RoundRectangle2D.Float(0, 0, w, h, arcSize, arcSize);

        // Dibujar el fondo del botón
        g2d.setColor(fill);
        g2d.fill(roundedRect);

        // Configurar el icono
        Icon icon = getIcon();
        if (icon != null) {
            int iconWidth = Math.min(icon.getIconWidth(), ICON_SIZE);
            int iconHeight = Math.min(icon.getIconHeight(), ICON_SIZE);
            Image img = ((ImageIcon) icon).getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
            Icon resizedIcon = new ImageIcon(img);

            int iconX = getWidth() - iconWidth - 10; // Ajustar la posición del icono desde el borde derecho
            int iconY = (getHeight() - iconHeight) / 2; // Centrar verticalmente
            resizedIcon.paintIcon(this, g2d, iconX, iconY);
        }

        // Configurar el texto
        String text = getText();
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);

        // Calcular la posición del texto
        int textX = 15; // Alinear el texto con un margen izquierdo
        int textY = (getHeight() + fm.getAscent()) / 2 - 3; // Centrar verticalmente el texto

        g2d.setColor(getForeground());
        g2d.drawString(text, textX, textY);

        g2d.dispose(); // Liberar recursos gráficos
    }

    // Métodos getters y setters para que el ícono sea configurable desde las propiedades
    @Override
    public Icon getIcon() {
        return super.getIcon();
    }

    @Override
    public void setIcon(Icon icon) {
        super.setIcon(icon);
        repaint();
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Botón Personalizado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        btnInicio button = new btnInicio();
        button.setText("Bomberos");

        // Asignar un icono de prueba
        ImageIcon icon = new ImageIcon("ruta/al/icono.png"); // Reemplaza con la ruta de tu icono
        button.setIcon(icon);

        button.setBounds(50, 50, 200, 100);

        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
    
