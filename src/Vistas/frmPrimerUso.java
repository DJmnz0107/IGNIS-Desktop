/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlPrimerUso;
import Modelo.Usuarios;
import javax.swing.JFrame;


/**
 *
 * @author Diego
 */
public class frmPrimerUso extends javax.swing.JFrame {
    
    

    /**
     * Creates new form frmPrimerUso
     */
    public frmPrimerUso() {
         initComponents();
           this.setSize(1080, 600);

        this.setLocationRelativeTo(null);
         

        
    }
    
      public static void initFrmCrearCuenta(){
        Usuarios modeloUsuarios = new Usuarios();
        frmPrimerUso vista = new frmPrimerUso();
        ctrlPrimerUso controlador  = new ctrlPrimerUso(modeloUsuarios, vista);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCrearPrimerCuenta = new Vistas.btnPrimerUso();
        txtEdadPrimer = new Vistas.TextFieldPrimerUso();
        txtNombreUsuarioPrimer = new Vistas.TextFieldPrimerUso();
        txtDUIPrimer = new Vistas.TextFieldPrimerUso();
        txtContrasenaPrimerUso = new Vistas.TextFieldPasswordPrimer();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 216, 99));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(217, 71, 62));
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(217, 71, 62));
        jLabel1.setText("¡Crea tu primer cuenta!");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(217, 71, 62));
        jLabel3.setText("Esperamos que el sistema cumpla con todas tus necesidades.");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 390, 40));

        btnCrearPrimerCuenta.setText("Crear Cuenta");
        btnCrearPrimerCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel2.add(btnCrearPrimerCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 200, 40));

        txtEdadPrimer.setPlaceholder("Ingresa tu edad");
        jPanel2.add(txtEdadPrimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 400, 50));

        txtNombreUsuarioPrimer.setPlaceholder("Ingresa tu nombre de usuario");
        jPanel2.add(txtNombreUsuarioPrimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 400, 50));

        txtDUIPrimer.setPlaceholder("Ingresa tu DUI");
        jPanel2.add(txtDUIPrimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 400, 50));

        txtContrasenaPrimerUso.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/eyeCerradoPrimer.png"))); // NOI18N
        jPanel2.add(txtContrasenaPrimerUso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 400, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 450, 410));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(217, 71, 62));
        jLabel2.setText("vez en el sistema de IGNIS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 310, 40));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(217, 71, 62));
        jLabel4.setText("Un gusto verte por primera vez ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 370, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/firefighter.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 450, 450));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/background2Mini.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmPrimerUso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrimerUso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrimerUso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrimerUso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrimerUso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnPrimerUso btnCrearPrimerCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public Vistas.TextFieldPasswordPrimer txtContrasenaPrimerUso;
    public Vistas.TextFieldPrimerUso txtDUIPrimer;
    public Vistas.TextFieldPrimerUso txtEdadPrimer;
    public Vistas.TextFieldPrimerUso txtNombreUsuarioPrimer;
    // End of variables declaration//GEN-END:variables
}


