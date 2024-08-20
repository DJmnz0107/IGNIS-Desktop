/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Color;

/**
 *
 * @author Diego
 */
public class ColorHex {
     public static Color hexToColor(String hex) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }
        int rgb = Integer.parseInt(hex, 16);
        return new Color(rgb);
    }
    
}
