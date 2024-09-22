/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlAspirantes;
import Modelo.Aspirantes;
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
 * @author User
 */
public class frmAgregarAspirante extends javax.swing.JFrame {

    /**
     * Creates new form frmAgregarAspirante
     */
    public frmAgregarAspirante() {
        GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        initComponents();
    }

    public static void initfrmAgregarAspirante() {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
        frmAgregarAspirante vistas = new frmAgregarAspirante();
        Aspirantes modelo = new Aspirantes();
        ctrlAspirantes controlador = new ctrlAspirantes(modelo, vistas);
        
        vistas.setVisible(true);
        
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
        panelRound31 = new Vistas.panelRound3();
        txtNombreAspirante = new Vistas.TextFieldGris();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProgresoAspirante = new Vistas.TextFieldGris();
        jLabel4 = new javax.swing.JLabel();
        txtEdadAspirante = new Vistas.TextFieldGris();
        txtDuiAspirante = new Vistas.TextFieldGris();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbBomberoMentor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtApellidoAspirante = new Vistas.TextFieldGris();
        txtEntrenamientoAspirante = new Vistas.TextFieldGris();
        jLabel8 = new javax.swing.JLabel();
        btnAgregarFoto = new Vistas.btnRojoForms();
        btnAñadirInfo = new Vistas.btnRojoForms();
        btnVerAspirantes = new Vistas.btnRojoForms();
        txtFoto = new javax.swing.JTextField();
        imgAspirante = new javax.swing.JLabel();
        imgBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 139, 77));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound31.setRoundBottomLeft(20);
        panelRound31.setRoundBottomRight(20);
        panelRound31.setRoundTopLeft(20);
        panelRound31.setRoundTopRight(20);
        panelRound31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtNombreAspirante.setHint("");
        panelRound31.add(txtNombreAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 69, 252, 49));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel1.setText("Nombre del aspirante");
        panelRound31.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 29, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel3.setText("Apellido del aspirante");
        panelRound31.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 29, -1, -1));

        txtProgresoAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtProgresoAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtProgresoAspirante.setHint("");
        panelRound31.add(txtProgresoAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 252, 97));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel4.setText("Edad");
        panelRound31.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        txtEdadAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtEdadAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtEdadAspirante.setHint("");
        panelRound31.add(txtEdadAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 103, 49));

        txtDuiAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtDuiAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtDuiAspirante.setHint("");
        panelRound31.add(txtDuiAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 252, 49));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel5.setText("Dui");
        panelRound31.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 144, -1, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel6.setText("Bombero mentor");
        panelRound31.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        cmbBomberoMentor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelRound31.add(cmbBomberoMentor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 160, 34));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel7.setText("Progreso del aspirante");
        panelRound31.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        txtApellidoAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtApellidoAspirante.setHint("");
        panelRound31.add(txtApellidoAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 69, 252, 49));

        txtEntrenamientoAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtEntrenamientoAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtEntrenamientoAspirante.setHint("");
        panelRound31.add(txtEntrenamientoAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 252, 119));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel8.setText("Entrenamiento del aspirante");
        panelRound31.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        btnAgregarFoto.setText("    Agregar foto");
        btnAgregarFoto.setAlignmentY(0.0F);
        btnAgregarFoto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        panelRound31.add(btnAgregarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 155, 51));

        btnAñadirInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/anadir.png"))); // NOI18N
        btnAñadirInfo.setText("  Añadir informacion");
        btnAñadirInfo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        panelRound31.add(btnAñadirInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 246, 60));

        btnVerAspirantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/contrato.png"))); // NOI18N
        btnVerAspirantes.setText("   Ver aspirantes");
        btnVerAspirantes.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        panelRound31.add(btnVerAspirantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 224, 60));

        txtFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFotoActionPerformed(evt);
            }
        });
        panelRound31.add(txtFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 144, -1));
        panelRound31.add(imgAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 260, 210));

        imgBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Volver.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inicio > Seguimiento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(imgBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(panelRound31, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound31, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
       
    }//GEN-LAST:event_btnMenuActionPerformed

    private void txtFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFotoActionPerformed

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
            java.util.logging.Logger.getLogger(frmAgregarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmAgregarAspirante();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnRojoForms btnAgregarFoto;
    public Vistas.btnRojoForms btnAñadirInfo;
    public javax.swing.JButton btnMenu;
    public Vistas.btnRojoForms btnVerAspirantes;
    public javax.swing.JComboBox<String> cmbBomberoMentor;
    public javax.swing.JLabel imgAspirante;
    public javax.swing.JLabel imgBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private Vistas.PanelRound panelRound1;
    private Vistas.panelRound3 panelRound31;
    public Vistas.TextFieldGris txtApellidoAspirante;
    public Vistas.TextFieldGris txtDuiAspirante;
    public Vistas.TextFieldGris txtEdadAspirante;
    public Vistas.TextFieldGris txtEntrenamientoAspirante;
    public javax.swing.JTextField txtFoto;
    public Vistas.TextFieldGris txtNombreAspirante;
    public Vistas.TextFieldGris txtProgresoAspirante;
    // End of variables declaration//GEN-END:variables
}
