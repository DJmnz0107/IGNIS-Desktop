/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlCrearCuenta;
import Modelo.Niveles;
import Modelo.Usuarios;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author aless
 */
public class frmCrearCuenta extends javax.swing.JFrame {

    /**
     * Creates new form frmCrearCuenta
     */
    public frmCrearCuenta() {
                setSize(900, 600);
        initComponents();
        setTitle("IGNIS - Crear Cuenta");
                int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);

         JTextField duiField = txtDuiUsuario; 
        ((AbstractDocument) duiField.getDocument()).setDocumentFilter(new DuiDocumentFilter());
    }
    
    public static void initFrmCrearCuenta(){
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
              UIManager.put("ComboBox.background", new Color(0xFFFFFF));       
        UIManager.put("ComboBox.foreground", Color.DARK_GRAY);              
        UIManager.put("ComboBox.selectionBackground", new Color(0xFF7043)); 
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);         
        UIManager.put("ComboBox.border", BorderFactory.createLineBorder(new Color(0xFFFFFF), 1)); 
        UIManager.put( "Component.arrowType", "triangle" );

        UIManager.put("TextField.arc", 50); 
        UIManager.put("ComboBox.arc", 50); 
        
        Niveles modeloNivel = new Niveles();
        Usuarios modeloUsuarios = new Usuarios();
        frmCrearCuenta vista = new frmCrearCuenta();
        ctrlCrearCuenta controlador  = new ctrlCrearCuenta(modeloNivel, modeloUsuarios, vista);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imgBack = new javax.swing.JLabel();
        jcmbTipoUsuario = new javax.swing.JComboBox();
        txtNombreUsuario = new Vistas.TextFieldBlancoHint();
        txtContrasenaUsuario = new Vistas.TextFieldBlancoHint();
        txtEdadUsuario = new Vistas.TextFieldBlancoHint();
        txtDuiUsuario = new Vistas.TextFieldBlancoHint();
        btnCrearCuenta = new Vistas.btnRojoForms();
        btnVerUsuarios = new Vistas.btnRojoForms();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(239, 138, 76));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Account box.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, 208));

        imgBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Back_arrow.png"))); // NOI18N
        jPanel1.add(imgBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jcmbTipoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jcmbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbTipoUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jcmbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 196, 39));

        txtNombreUsuario.setHint("Ingresa el nombre del usuario");
        jPanel1.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 336, 49));

        txtContrasenaUsuario.setHint("Ingresa la contraseña del usuario");
        jPanel1.add(txtContrasenaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 336, 49));

        txtEdadUsuario.setHint("Edad");
        jPanel1.add(txtEdadUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 264, 49));

        txtDuiUsuario.setHint("DUI del usuario");
        jPanel1.add(txtDuiUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 299, 49));

        btnCrearCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Add User Male.png"))); // NOI18N
        btnCrearCuenta.setText("Crear cuenta");
        btnCrearCuenta.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jPanel1.add(btnCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 242, 55));

        btnVerUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/People.png"))); // NOI18N
        btnVerUsuarios.setText("Ver usuarios");
        btnVerUsuarios.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jPanel1.add(btnVerUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 242, 55));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcmbTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbTipoUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(frmCrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initFrmCrearCuenta();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnRojoForms btnCrearCuenta;
    public Vistas.btnRojoForms btnVerUsuarios;
    public javax.swing.JLabel imgBack;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JComboBox jcmbTipoUsuario;
    public Vistas.TextFieldBlancoHint txtContrasenaUsuario;
    public Vistas.TextFieldBlancoHint txtDuiUsuario;
    public Vistas.TextFieldBlancoHint txtEdadUsuario;
    public Vistas.TextFieldBlancoHint txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
