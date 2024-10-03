/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

/**
 *
 * @author angel
 */
public class frmRegistroMisionesBomberos extends javax.swing.JFrame {

    /**
     * Creates new form frmRegistroMisionesBomberos
     */
    public frmRegistroMisionesBomberos() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInicio21 = new Vistas.btnInicio2();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imgBack = new javax.swing.JLabel();
        JTextField = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new Vistas.btnRojoForms();
        btnActualizar = new Vistas.btnRojoForms();

        btnInicio21.setText("btnInicio21");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(239, 138, 76));

        jPanel1.setBackground(new java.awt.Color(239, 138, 76));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asignar bomberos > Ver registro");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        imgBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Back_arrow.png"))); // NOI18N
        jPanel1.add(imgBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

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
        jPanel1.add(JTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 100, 40));

        txtBuscar.setBackground(new java.awt.Color(255, 173, 122));
        txtBuscar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setBorder(null);
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.setMargin(new java.awt.Insets(2, 10, 2, 6));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 380, 40));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Buscar.png"))); // NOI18N
        btnBuscar.setToolTipText("");
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setForeground(new java.awt.Color(239, 138, 76));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setSelectionBackground(new java.awt.Color(239, 138, 76));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 880, 380));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/EliminarNew.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 530, 200, 50));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/ActualizarNew.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 200, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextFieldActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(frmRegistroMisionesBomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistroMisionesBomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistroMisionesBomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistroMisionesBomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistroMisionesBomberos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextField;
    public Vistas.btnRojoForms btnActualizar;
    public javax.swing.JLabel btnBuscar;
    public Vistas.btnRojoForms btnEliminar;
    private Vistas.btnInicio2 btnInicio21;
    public javax.swing.JLabel imgBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
