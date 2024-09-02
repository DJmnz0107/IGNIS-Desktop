/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Modelo.Usuarios;
import Vistas.drawer.MyDrawerBuilder;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Font;
import javax.swing.UIManager;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

/**
 *
 * @author angel
 */
public class frmInicio extends javax.swing.JFrame {

    /**
     * Creates new form frmInicio
     */
    public frmInicio(String usuario) {
        GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        initComponents();
        
        
       if (usuario != null) {
            jlblTextoInicio.setText("Bienvenido a IGNIS, nos alegra verte de nuevo " + usuario);
        } else {
            jlblTextoInicio.setText("Bienvenido a IGNIS");
        }
    }
    
    
    public static void initfrmInicio(String usuario) {
 
         FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
        frmInicio vista = new frmInicio(usuario);
        
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
        jlblTextoInicio = new javax.swing.JLabel();
        panelRound1 = new Vistas.PanelRound();
        btnMenu = new javax.swing.JButton();
        panelRound21 = new Vistas.panelRound2();
        panelRound31 = new Vistas.panelRound3();
        jLabel2 = new javax.swing.JLabel();
        btnInicio3 = new Vistas.btnInicio();
        btnInicio4 = new Vistas.btnInicio();
        btnInicio5 = new Vistas.btnInicio();
        btnInicio6 = new Vistas.btnInicio();
        btnInicio7 = new Vistas.btnInicio();
        btnInicio8 = new Vistas.btnInicio();
        btnInicio9 = new Vistas.btnInicio();
        btnInicio10 = new Vistas.btnInicio();
        btnInicio21 = new Vistas.btnInicio2();
        btnInicio31 = new Vistas.btnInicio3();
        btnInicio41 = new Vistas.btnInicio4();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 139, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTextoInicio.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 28)); // NOI18N
        jlblTextoInicio.setForeground(new java.awt.Color(255, 255, 255));
        jlblTextoInicio.setText("Bienvenido a IGNIS nos alegra verte de nuevo ");
        jPanel1.add(jlblTextoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 940, 80));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopRight(50);

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/lista.png"))); // NOI18N
        btnMenu.setBorder(null);
        btnMenu.setContentAreaFilled(false);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(594, Short.MAX_VALUE))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 650));

        panelRound21.setBackground(new java.awt.Color(245, 216, 99));
        panelRound21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound31.setBackground(new java.awt.Color(240, 139, 77));
        panelRound31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 243, 243));
        jLabel2.setText("Funciones principales");
        panelRound31.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        btnInicio3.setForeground(new java.awt.Color(240, 139, 77));
        btnInicio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoStat.png"))); // NOI18N
        btnInicio3.setText("Estadísticas");
        btnInicio3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        panelRound31.add(btnInicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 170, 60));

        btnInicio4.setForeground(new java.awt.Color(240, 139, 77));
        btnInicio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoInforme.png"))); // NOI18N
        btnInicio4.setText("Informes");
        btnInicio4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        panelRound31.add(btnInicio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 170, 60));

        btnInicio5.setForeground(new java.awt.Color(240, 139, 77));
        btnInicio5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoCamionsito.png"))); // NOI18N
        btnInicio5.setText("Transporte");
        btnInicio5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        panelRound31.add(btnInicio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 170, 60));

        btnInicio6.setForeground(new java.awt.Color(240, 139, 77));
        btnInicio6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoManguera.png"))); // NOI18N
        btnInicio6.setText("Inventario");
        btnInicio6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        panelRound31.add(btnInicio6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 170, 60));

        btnInicio7.setForeground(new java.awt.Color(240, 139, 77));
        btnInicio7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoMision.png"))); // NOI18N
        btnInicio7.setText("Misiones");
        btnInicio7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        panelRound31.add(btnInicio7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 170, 60));

        btnInicio8.setForeground(new java.awt.Color(240, 139, 77));
        btnInicio8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoSeguimiento.png"))); // NOI18N
        btnInicio8.setText("Seguimiento");
        btnInicio8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        panelRound31.add(btnInicio8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 170, 60));

        btnInicio9.setForeground(new java.awt.Color(240, 139, 77));
        btnInicio9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoBombero.png"))); // NOI18N
        btnInicio9.setText("Bomberos");
        btnInicio9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        panelRound31.add(btnInicio9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 170, 60));

        btnInicio10.setForeground(new java.awt.Color(240, 139, 77));
        btnInicio10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoEmergencia.png"))); // NOI18N
        btnInicio10.setText("Emergencias");
        btnInicio10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        panelRound31.add(btnInicio10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 170, 60));

        panelRound21.add(panelRound31, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 26, 650, 430));

        jPanel1.add(panelRound21, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 730, 480));

        btnInicio21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoAgregarU.png"))); // NOI18N
        btnInicio21.setText("Crear nuevo usuario");
        btnInicio21.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jPanel1.add(btnInicio21, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 250, 50));

        btnInicio31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoCerrar.png"))); // NOI18N
        btnInicio31.setText("Cerrar sesión");
        btnInicio31.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jPanel1.add(btnInicio31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 580, 240, 50));

        btnInicio41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoVer.png"))); // NOI18N
        btnInicio41.setText("Ver cambios");
        btnInicio41.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jPanel1.add(btnInicio41, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 580, 230, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vistas.btnInicio btnInicio10;
    private Vistas.btnInicio2 btnInicio21;
    private Vistas.btnInicio btnInicio3;
    private Vistas.btnInicio3 btnInicio31;
    private Vistas.btnInicio btnInicio4;
    private Vistas.btnInicio4 btnInicio41;
    private Vistas.btnInicio btnInicio5;
    private Vistas.btnInicio btnInicio6;
    private Vistas.btnInicio btnInicio7;
    private Vistas.btnInicio btnInicio8;
    private Vistas.btnInicio btnInicio9;
    public javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jlblTextoInicio;
    private Vistas.PanelRound panelRound1;
    private Vistas.panelRound2 panelRound21;
    private Vistas.panelRound3 panelRound31;
    // End of variables declaration//GEN-END:variables
}
