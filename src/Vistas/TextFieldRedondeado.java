package Vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;

/**
 *
 * @author angel
 */
public class TextFieldRedondeado extends JTextField{

    public TextFieldRedondeado() {
        setOpaque(false); 
        setBackground(new Color(0, 0, 0, 0)); 
        setForeground(Color.BLACK); 
        setHorizontalAlignment(JTextField.CENTER);
        setSelectionColor(new Color(0, 120, 215)); 
        setBorder(null); // Asegúrate de no tener borde
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el fondo redondeado
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getHeight()));

        super.paintComponent(g2); // Llama al método de superclase para pintar el texto

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No dibujar el borde
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setOpaque(false); 
        setBorder(null); // Asegúrate de que el borde siga siendo nulo
    }
}
