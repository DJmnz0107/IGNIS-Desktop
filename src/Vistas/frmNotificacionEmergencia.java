/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlNotificacion;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author angel
 */
public class frmNotificacionEmergencia extends javax.swing.JFrame {

    private frmNotificacionEmergencia vistaNotificacion; 
    /**
     * Creates new form frmNotificacionEmergencia
     */
    
    public frmNotificacionEmergencia() {
        initComponents();
        int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
                        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
public void initfrmNotificacionEmergencia(String descripcion, String gravedad, String tipo) {
    System.out.println(descripcion + gravedad + tipo);

    if (vistaNotificacion == null) {
        vistaNotificacion = new frmNotificacionEmergencia();
        ctrlNotificacion controlador = new ctrlNotificacion(vistaNotificacion);
    }

    // Actualiza los textos de los labels en la instancia actual
    vistaNotificacion.lblDescripcion.setText("Descripción: " + descripcion);
    vistaNotificacion.lblGravedad.setText("Gravedad: " + gravedad);
    vistaNotificacion.lblTipo.setText("Se ha enviado una señal de " + tipo);

    // Asegúrate de que la vista actual sea visible
    vistaNotificacion.setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblGravedad = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblDenegar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(239, 138, 76));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/notificacion.png"))); // NOI18N
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 17, -1, -1));

        lblTipo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(239, 138, 76));
        lblTipo.setText("Se ha enviado una señal de emergencia");
        panelRound1.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        lblGravedad.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        lblGravedad.setForeground(new java.awt.Color(239, 138, 76));
        lblGravedad.setText("Gravedad");
        panelRound1.add(lblGravedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        lblDescripcion.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(239, 138, 76));
        lblDescripcion.setText("Descripción:");
        panelRound1.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 330, 50));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, 480, 140));

        lblDenegar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        lblDenegar.setForeground(new java.awt.Color(255, 255, 255));
        lblDenegar.setText("Denegar ayuda");
        jPanel1.add(lblDenegar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ayuda enviada");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ayuda en proceso");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(frmNotificacionEmergencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNotificacionEmergencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNotificacionEmergencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNotificacionEmergencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblDenegar;
    public javax.swing.JLabel lblDescripcion;
    public javax.swing.JLabel lblGravedad;
    public javax.swing.JLabel lblTipo;
    private Vistas.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
