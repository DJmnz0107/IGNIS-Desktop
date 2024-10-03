/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import javax.swing.text.DocumentFilter;
import javax.swing.text.*;


/**
 *
 * @author Diego
 */
public class DuiDocumentFilter extends DocumentFilter {
    
      private static final int MAX_LENGTH = 9; // Longitud máxima permitida sin el guion (8 dígitos + 1 para el guion)

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null) {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            StringBuilder newText = new StringBuilder(currentText);
            newText.insert(offset, string);
            // Verificar longitud total incluyendo el guion
            if (newText.length() <= MAX_LENGTH + 1) { // +1 para el guion
                setFormattedText(fb, newText.toString());
            }
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text != null) {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            StringBuilder newText = new StringBuilder(currentText);
            newText.replace(offset, offset + length, text);
            // Verificar longitud total incluyendo el guion
            if (newText.length() <= MAX_LENGTH + 1) { // +1 para el guion
                setFormattedText(fb, newText.toString());
            }
        }
    }

    private void setFormattedText(FilterBypass fb, String text) throws BadLocationException {
        String formattedText = formatDui(text);
        fb.replace(0, fb.getDocument().getLength(), formattedText, null);
    }

    private String formatDui(String dui) {
        dui = dui.replaceAll("[^0-9]", ""); // Quitar caracteres no numéricos
        if (dui.length() > 9) {
            dui = dui.substring(0, 9); // Limitar a 9 caracteres (8 dígitos + 1)
        }
        if (dui.length() > 8) {
            return dui.substring(0, 8) + "-" + dui.substring(8, 9); // Formato: XXXXXXXX-X
        }
        return dui; // Devolver sin cambios si no hay suficiente longitud
    }
}
