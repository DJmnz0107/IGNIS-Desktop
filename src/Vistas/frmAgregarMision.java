/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlAgregarInventario;
import Controlador.ctrlAgregarMisiones;
import Modelo.Emergencias;
import Modelo.Misiones;
import Modelo.Recursos;
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
 * @author Diego
 */
public class frmAgregarMision extends javax.swing.JFrame {
    private static frmAgregarMision instance;

    /**
     * Creates new form frmAgregarMision
     */
    public frmAgregarMision() {
                 GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        initComponents();
    }
    
    public static void initFrmAgregarMision() {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
        frmAgregarMision vista = new frmAgregarMision();
        Emergencias emergencia = new Emergencias();
        Misiones modelo = new Misiones();
        ctrlAgregarMisiones controlador = new ctrlAgregarMisiones(emergencia, modelo, vista);
        vista.setVisible(true);
    }
    
    public static frmAgregarMision getInstance() {
    return instance;
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
        jLabel9 = new javax.swing.JLabel();
        panelRound2 = new Vistas.PanelRound();
        txtDescripcion = new Vistas.TextFieldGris();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dtcEmergencia = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cmbEmergencia = new javax.swing.JComboBox<>();
        btnBomberos = new Vistas.btnRojoForms();
        btnEmergencias = new Vistas.btnRojoForms();
        btnTransportes2 = new Vistas.btnRojoForms();
        btnVerRegistro = new Vistas.btnNaranjaForms();
        btnAgregar = new Vistas.btnNaranjaForms();
        btnRecursos = new Vistas.btnRojoForms();
        btnInformes = new Vistas.btnRojoForms();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 650));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("> Misiones");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtDescripcion.setHint("");
        panelRound2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 490, 120));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Emergencia tratada");
        panelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Descripción de la misión");
        panelRound2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
        panelRound2.add(dtcEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 230, 40));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha de la misión");
        panelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        cmbEmergencia.setForeground(new java.awt.Color(240, 139, 77));
        panelRound2.add(cmbEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 230, 40));

        btnBomberos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Arrowmini.png"))); // NOI18N
        btnBomberos.setText("Asignar bomberos");
        btnBomberos.setToolTipText("");
        btnBomberos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnBomberos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBomberosActionPerformed(evt);
            }
        });
        panelRound2.add(btnBomberos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 210, 50));

        btnEmergencias.setText("Ver emergencias");
        btnEmergencias.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnEmergencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergenciasActionPerformed(evt);
            }
        });
        panelRound2.add(btnEmergencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 160, 30));

        btnTransportes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Arrowmini.png"))); // NOI18N
        btnTransportes2.setText("Asignar transportes");
        btnTransportes2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnTransportes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransportes2ActionPerformed(evt);
            }
        });
        panelRound2.add(btnTransportes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 210, 50));

        btnVerRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/contrato.png"))); // NOI18N
        btnVerRegistro.setText("Ver registro");
        btnVerRegistro.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        panelRound2.add(btnVerRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 210, 50));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/anadir.png"))); // NOI18N
        btnAgregar.setText("Añadir información");
        btnAgregar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        panelRound2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 240, 50));

        btnRecursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Arrowmini.png"))); // NOI18N
        btnRecursos.setText("Asignar recursos");
        btnRecursos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecursosActionPerformed(evt);
            }
        });
        panelRound2.add(btnRecursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 210, 50));

        btnInformes.setText("Ver informes");
        btnInformes.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformesActionPerformed(evt);
            }
        });
        panelRound2.add(btnInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 140, 30));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Informe");
        panelRound2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/misionNew.png"))); // NOI18N
        panelRound2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 300, 270));

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 910, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnBomberosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBomberosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBomberosActionPerformed

    private void btnEmergenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmergenciasActionPerformed

    private void btnTransportes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransportes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransportes2ActionPerformed

    private void btnRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecursosActionPerformed

    private void btnInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInformesActionPerformed

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
            java.util.logging.Logger.getLogger(frmAgregarMision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarMision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarMision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarMision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgregarMision().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnNaranjaForms btnAgregar;
    public Vistas.btnRojoForms btnBomberos;
    public Vistas.btnRojoForms btnEmergencias;
    public Vistas.btnRojoForms btnInformes;
    public javax.swing.JButton btnMenu;
    public Vistas.btnRojoForms btnRecursos;
    public Vistas.btnRojoForms btnTransportes2;
    public Vistas.btnNaranjaForms btnVerRegistro;
    public javax.swing.JComboBox<String> cmbEmergencia;
    public com.toedter.calendar.JDateChooser dtcEmergencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private Vistas.PanelRound panelRound1;
    private Vistas.PanelRound panelRound2;
    public Vistas.TextFieldGris txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
