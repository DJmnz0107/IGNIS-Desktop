/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

/**
 *
 * @author User
 */
public class VerticalLayout implements java.awt.LayoutManager {

     @Override
    public void addLayoutComponent(String name, Component comp) {
        // Método no utilizado en este layout.
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // Método no utilizado en este layout.
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return layoutSize(parent, true);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return layoutSize(parent, false);
    }

    private Dimension layoutSize(Container parent, boolean preferred) {
        Dimension dim = new Dimension(0, 0);
        Insets insets = parent.getInsets();
        int totalHeight = insets.top + insets.bottom;
        int maxWidth = 0;

        int nmembers = parent.getComponentCount();

        for (int i = 0; i < nmembers; i++) {
            Component m = parent.getComponent(i);
            if (m.isVisible()) {
                Dimension d = preferred ? m.getPreferredSize() : m.getMinimumSize();
                totalHeight += d.height;
                maxWidth = Math.max(maxWidth, d.width);
            }
        }

        dim.width = maxWidth + insets.left + insets.right;
        dim.height = totalHeight;

        return dim;
    }

    @Override
    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();
        int y = insets.top;

        int nmembers = parent.getComponentCount();

        for (int i = 0; i < nmembers; i++) {
            Component m = parent.getComponent(i);
            if (m.isVisible()) {
                Dimension d = m.getPreferredSize();
                m.setBounds(insets.left, y, parent.getWidth() - insets.left - insets.right, d.height);
                y += d.height;
            }
        }
    }
    
}
    
