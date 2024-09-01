/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlTransportes;
import Modelo.Transportes;

/**
 *
 * @author angel
 */
public class frmAgregarTransportes extends javax.swing.JFrame {

    /**
     * Creates new form frmAgregarTransportes
     */
    public frmAgregarTransportes() {
        initComponents();
        
        
    }
    
    public static void initfrmAgregarTransportes() {
        Transportes modelo = new Transportes();
        frmAgregarTransportes vista = new frmAgregarTransportes();
        frmVerRegistroTransporter Regsitro = new frmVerRegistroTransporter();

        ctrlTransportes controlador = new ctrlTransportes(modelo,vista, Regsitro);
        
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
        txtPlaca = new Vistas.TextFieldRedondeado();
        btnAgregar = new Vistas.buttonLogin();
        cmbDisponibilidad = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtEstado = new Vistas.TextFieldRedondeado();
        jLabel7 = new javax.swing.JLabel();
        txtCapacidad = new Vistas.TextFieldRedondeado();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroTransporte = new Vistas.TextFieldRedondeado();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbAgregarTransportes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnVerRegistro = new Vistas.btnNaranjaForms();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 139, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 270, 30));

        btnAgregar.setForeground(new java.awt.Color(240, 139, 77));
        btnAgregar.setText("Agregar");
        btnAgregar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 150, 50));

        cmbDisponibilidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "No disponible", " " }));
        jPanel1.add(cmbDisponibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dsiponibilidad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, -1, -1));
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 270, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estado:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, -1));
        jPanel1.add(txtCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 270, 30));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Capacidad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, -1, 30));
        jPanel1.add(txtNumeroTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 270, 30));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Número de transporte:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Placa:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        cmbAgregarTransportes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Camión de bomberos", "PickUp" }));
        jPanel1.add(cmbAgregarTransportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/camionBombero.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iamgen para agregar bomberos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 600, 390));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("> Transporte");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("IGNIS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        btnVerRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/verificar (3).png"))); // NOI18N
        btnVerRegistro.setText("Ver registro");
        btnVerRegistro.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(btnVerRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 240, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

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
            java.util.logging.Logger.getLogger(frmAgregarTransportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarTransportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarTransportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarTransportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgregarTransportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.buttonLogin btnAgregar;
    public Vistas.btnNaranjaForms btnVerRegistro;
    public javax.swing.JComboBox<String> cmbAgregarTransportes;
    public javax.swing.JComboBox<String> cmbDisponibilidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public Vistas.TextFieldRedondeado txtCapacidad;
    public Vistas.TextFieldRedondeado txtEstado;
    public Vistas.TextFieldRedondeado txtNumeroTransporte;
    public Vistas.TextFieldRedondeado txtPlaca;
    // End of variables declaration//GEN-END:variables
}
