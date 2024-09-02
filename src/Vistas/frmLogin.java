/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlLogin;
import Modelo.Usuarios;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Diego
 */
public class frmLogin extends JFrame  {
    
    

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
        this.setSize(1250, 800);
        this.getContentPane().setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);

        
        txtContrasena.setHint("Ingresa tu contraseña");
        txtUsuario.setHint("Ingresa tu usuario");
        
        

    }

       public static void initfrmLogin(){
        Usuarios modeloUsuarios = new Usuarios();
        frmLogin vista = new frmLogin();
        ctrlLogin controlador = new ctrlLogin(modeloUsuarios, vista);
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

        loginBackground1 = new Vistas.loginBackground();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new Vistas.TextFieldLogin();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLogin = new Vistas.buttonLogin();
        txtContrasena = new Vistas.TextFieldPassword();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1250, 800));

        loginBackground1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        loginBackground1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginBackground1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, 80, -1));

        txtUsuario.setHint("Ingresa tu usuario");
        txtUsuario.setInheritsPopupMenu(true);
        txtUsuario.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/userIconNew.png"))); // NOI18N
        loginBackground1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 440, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/gotasAguaNew.png"))); // NOI18N
        loginBackground1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 480, 430, 340));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Recuperar la contraseña");
        loginBackground1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 540, 150, -1));

        btnLogin.setForeground(new java.awt.Color(240, 139, 77));
        btnLogin.setText("Iniciar Sesión");
        btnLogin.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        loginBackground1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 580, 270, 50));

        txtContrasena.setHint("Ingresa tu contraseña");
        loginBackground1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 440, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/accountCircle.png"))); // NOI18N
        loginBackground1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(239, 138, 76));
        jLabel8.setText("Inicia sesión con tus credenciales para continuar con el programa.");
        loginBackground1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 580, 90));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 55)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(239, 138, 76));
        jLabel9.setText("Bienvenido a IGNIS");
        loginBackground1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 530, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/logoinicioNew.png"))); // NOI18N
        loginBackground1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 210, 330));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 3)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(239, 138, 76));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/circuloBlanco2.png"))); // NOI18N
        loginBackground1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-650, -110, 1410, 1020));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
           FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
         
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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.buttonLogin btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private Vistas.loginBackground loginBackground1;
    public Vistas.TextFieldPassword txtContrasena;
    public Vistas.TextFieldLogin txtUsuario;
    // End of variables declaration//GEN-END:variables
}
