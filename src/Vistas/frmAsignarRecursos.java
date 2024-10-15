/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlAsignarRecursos;
import Modelo.MisionesRecursos;
import Vistas.drawer.MyDrawerBuilder;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

/**
 *
 * @author USUARIO
 */
public class frmAsignarRecursos extends javax.swing.JFrame {

    /**
     * Creates new form frmAsignarRecursos
     */
    public frmAsignarRecursos() {
              GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        initComponents();
        setTitle("IGNIS - Asignar Recurso");
        
                int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
    }
    
    public static void initFrmAsignarRecursos(){
         FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
                 UIManager.put("ComboBox.background", new Color(0xFFFFFF));       
        UIManager.put("ComboBox.foreground", Color.DARK_GRAY);              
        UIManager.put("ComboBox.selectionBackground", new Color(0xFF7043)); 
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);         
        UIManager.put("ComboBox.border", BorderFactory.createLineBorder(new Color(0xD9D9D9), 1)); 
        UIManager.put( "Component.arrowType", "triangle" );

        UIManager.put("TextField.arc", 50); 
        UIManager.put("ComboBox.arc", 50);  
        FlatLightLaf.setup();
    frmAsignarRecursos vista = new frmAsignarRecursos();
    MisionesRecursos modelo = new MisionesRecursos();
    ctrlAsignarRecursos controlador = new ctrlAsignarRecursos(vista,modelo);
    
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
        panelRound1 = new Vistas.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        cmbMision = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbRecursos = new javax.swing.JComboBox<>();
        btnVerAsigRecu = new Vistas.btnRojoForms();
        btnguardar = new Vistas.btnRojoForms();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 139, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Volver.png"))); // NOI18N
        jPanel1.add(imgBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(150);
        panelRound1.setRoundBottomRight(150);
        panelRound1.setRoundTopLeft(150);
        panelRound1.setRoundTopRight(150);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 139, 77));
        jLabel9.setText("Misión");
        panelRound1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        cmbMision.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelRound1.add(cmbMision, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 247, 66));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 139, 77));
        jLabel11.setText("Recursos");
        panelRound1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        cmbRecursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelRound1.add(cmbRecursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 247, 66));

        btnVerAsigRecu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/verificar (2).png"))); // NOI18N
        btnVerAsigRecu.setText("Ver Registro ");
        btnVerAsigRecu.setFocusable(false);
        btnVerAsigRecu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnVerAsigRecu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAsigRecuActionPerformed(evt);
            }
        });
        panelRound1.add(btnVerAsigRecu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 240, 63));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/anadir.png"))); // NOI18N
        btnguardar.setText("Añadir Información ");
        btnguardar.setFocusable(false);
        btnguardar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        panelRound1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 240, 63));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 560, 500));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Misiones >Asignar Recursos");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 530, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerAsigRecuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAsigRecuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerAsigRecuActionPerformed

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
            java.util.logging.Logger.getLogger(frmAsignarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAsignarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAsignarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAsignarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAsignarRecursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnRojoForms btnVerAsigRecu;
    public Vistas.btnRojoForms btnguardar;
    public javax.swing.JComboBox<String> cmbMision;
    public javax.swing.JComboBox<String> cmbRecursos;
    public javax.swing.JLabel imgBack;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private Vistas.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
