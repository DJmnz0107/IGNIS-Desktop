/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlRecuContrasena;
import Modelo.CredencialesRecuContra;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class frmRecuperacionContrasena extends javax.swing.JFrame {

    /**
     * Creates new form frmRecuperacionContrasena
     */
    public frmRecuperacionContrasena() {
        initComponents();
        int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }
    
    public static void initfrmRecuperacionContrasena(){
    
    CredencialesRecuContra Modelo = new CredencialesRecuContra();
    frmRecuperacionContrasena Vistas = new frmRecuperacionContrasena();
    ctrlRecuContrasena Controlador = new ctrlRecuContrasena(Modelo,Vistas);
    
    
    
    Vistas.setVisible(true);
    
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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRecuContra = new Vistas.btnPrimerUso();
        btnVerficarCode = new Vistas.btnPrimerUso();
        txtRecuCorreo = new Vistas.TextFieldBlanco();
        jLabel2 = new javax.swing.JLabel();
        txtRecuUsuario = new Vistas.TextFieldBlanco();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 139, 77));

        imgBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Volver.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Recuperacion de Contraseña");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(imgBack)
                .addGap(91, 91, 91)
                .addComponent(jLabel5)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 140));

        jLabel4.setBackground(new java.awt.Color(240, 139, 77));
        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 139, 77));
        jLabel4.setText("Ingresa tu nombre de usuario");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRecuContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/EnviarCodenEW.png"))); // NOI18N
        btnRecuContra.setText("Enviar código");
        btnRecuContra.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jPanel2.add(btnRecuContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 200, 40));

        btnVerficarCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/VerificarCODEn.png"))); // NOI18N
        btnVerficarCode.setText("Verificar código");
        btnVerficarCode.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jPanel2.add(btnVerficarCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 200, 40));

        txtRecuCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecuCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(txtRecuCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 350, 50));

        jLabel2.setBackground(new java.awt.Color(240, 139, 77));
        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 139, 77));
        jLabel2.setText("Ingresa tu correo");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        txtRecuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecuUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtRecuUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 350, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 800, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtRecuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecuUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecuUsuarioActionPerformed

    private void txtRecuCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecuCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecuCorreoActionPerformed

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
            java.util.logging.Logger.getLogger(frmRecuperacionContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRecuperacionContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRecuperacionContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRecuperacionContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnPrimerUso btnRecuContra;
    public Vistas.btnPrimerUso btnVerficarCode;
    public javax.swing.JLabel imgBack;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public Vistas.TextFieldBlanco txtRecuCorreo;
    public Vistas.TextFieldBlanco txtRecuUsuario;
    // End of variables declaration//GEN-END:variables
}
