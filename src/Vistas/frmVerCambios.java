/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlVerCambios;
import Modelo.CambioSistema;
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
 * @author USUARIO
 */
public class frmVerCambios extends javax.swing.JFrame {

    /**
     * Creates new form frmVerCambios
     */
    public frmVerCambios() {
        
        GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        initComponents();
    }
  public static void initfrmVerCambios(){
      
      FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
        
        CambioSistema  CambioSistema= new CambioSistema();
        frmVerCambios vista = new frmVerCambios();
        ctrlVerCambios controlador  = new ctrlVerCambios(CambioSistema, vista);
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
        panelRound1 = new Vistas.PanelRound();
        btnMenu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        imgVolver = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtbVerCambios = new javax.swing.JTable();
        JTextField = new javax.swing.JTextField();
        txtBuscarVerCambios = new javax.swing.JTextField();
        btnBuscarVerCambios = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 139, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setPreferredSize(new java.awt.Dimension(120, 800));
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

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));

        jPanel2.setBackground(new java.awt.Color(240, 139, 77));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2244, 0, -1, 688));

        imgVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Volver.png"))); // NOI18N
        jPanel1.add(imgVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 6, -1, -1));

        JtbVerCambios.setBackground(new java.awt.Color(255, 173, 122));
        JtbVerCambios.setModel(new javax.swing.table.DefaultTableModel(
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
        JtbVerCambios.setSelectionBackground(new java.awt.Color(239, 138, 76));
        JtbVerCambios.setShowGrid(false);
        jScrollPane1.setViewportView(JtbVerCambios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 914, 477));

        JTextField.setBackground(new java.awt.Color(192, 109, 58));
        JTextField.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        JTextField.setForeground(new java.awt.Color(255, 255, 255));
        JTextField.setText("   Buscar:");
        JTextField.setBorder(null);
        JTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JTextField.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        JTextField.setEnabled(false);
        JTextField.setMargin(new java.awt.Insets(2, 10, 2, 6));
        JTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(JTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 110, 45));

        txtBuscarVerCambios.setBackground(new java.awt.Color(255, 173, 122));
        txtBuscarVerCambios.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtBuscarVerCambios.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscarVerCambios.setBorder(null);
        txtBuscarVerCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscarVerCambios.setMargin(new java.awt.Insets(2, 10, 2, 6));
        txtBuscarVerCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarVerCambiosActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscarVerCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 350, 45));

        btnBuscarVerCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Buscar.png"))); // NOI18N
        jPanel1.add(btnBuscarVerCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 46, 45));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inicio > Ver Cambios");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void txtBuscarVerCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarVerCambiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarVerCambiosActionPerformed

    private void JTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(frmVerCambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVerCambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVerCambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVerCambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVerCambios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextField;
    public javax.swing.JTable JtbVerCambios;
    public javax.swing.JLabel btnBuscarVerCambios;
    public javax.swing.JButton btnMenu;
    public javax.swing.JLabel imgVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Vistas.PanelRound panelRound1;
    public javax.swing.JTextField txtBuscarVerCambios;
    // End of variables declaration//GEN-END:variables
}
