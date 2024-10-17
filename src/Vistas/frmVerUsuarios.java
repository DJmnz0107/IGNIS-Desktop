/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlVerUsuarios;
import Modelo.Usuarios;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author aless
 */
public class frmVerUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form frmVerUsuarios
     */
    public frmVerUsuarios() {
        initComponents();
        setTitle("IGNIS - Registro Usuarios");
        int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
        jtUsuarios.setDefaultEditor(Object.class, null); // Deshabilita la edición

    }
    
    public static void initfrmVerUsuarios(){
                FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
             UIManager.put("Table.background", new Color(0xFFFFFF));              
        UIManager.put("Table.foreground", Color.BLACK);                       
        UIManager.put("Table.selectionBackground", new Color(0xFFAD7A));       
        UIManager.put("Table.selectionForeground", Color.WHITE);               
        UIManager.put("Table.gridColor", new Color(0xDDDDDD));              
        UIManager.put("TableHeader.background", new Color(0xF5F5F5));          
        UIManager.put("TableHeader.foreground", Color.BLACK);                  
        UIManager.put("TableHeader.font", new Font("Microsoft Jheng UI", Font.BOLD, 14));  
        UIManager.put("Table.alternateRowColor", new Color(0xF8F8F8));  
        Usuarios Usuarios = new Usuarios();
        frmVerUsuarios vista = new frmVerUsuarios();
        ctrlVerUsuarios controlador  = new ctrlVerUsuarios(Usuarios, vista);
        vista.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imgBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        btnEliminar = new Vistas.btnRojoForms();
        txtBuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(239, 138, 76));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Volver.png"))); // NOI18N
        jPanel1.add(imgBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 18, -1, 40));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crear cuenta > Ver usuarios");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 31, -1, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Buscar.png"))); // NOI18N
        btnBuscar.setToolTipText("");
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 30, 45));

        jtUsuarios.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtUsuarios.setShowGrid(false);
        jScrollPane1.setViewportView(jtUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 920, 450));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/EliminarNew.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 20)); // NOI18N
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 190, 50));

        txtBuscar.setBackground(new java.awt.Color(255, 173, 122));
        txtBuscar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setBorder(null);
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.setMargin(new java.awt.Insets(2, 10, 2, 6));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 350, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("IGNIS");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        jButton2.setBackground(new java.awt.Color(192, 109, 58));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Buscar");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmVerUsuarios();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnBuscar;
    public Vistas.btnRojoForms btnEliminar;
    public javax.swing.JLabel imgBack;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtUsuarios;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
