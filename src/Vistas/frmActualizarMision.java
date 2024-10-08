/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlActualizarInventario;
import Controlador.ctrlActualizarMision;
import Modelo.Misiones;
import Modelo.Recursos;
import Vistas.drawer.MyDrawerBuilder;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

/**
 *
 * @author Diego
 */
public class frmActualizarMision extends javax.swing.JFrame {

                private int idMision;
                private Misiones mision;

    /**
     * Creates new form frmActualizarMision
     */
    public frmActualizarMision(Misiones mision) {
                GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        
        this.mision = mision;
        
          if (mision == null) {
        System.out.println("El objeto mision es null");
    } else {
        System.out.println("La mision tiene los siguientes datos: ");
        System.out.println("idMision: " + mision.getIdMision());
        System.out.println("Descripción: " + mision.getDescripcionMision());
        System.out.println("Fecha: " + mision.getFechaMision());
        System.out.println("Descripcion emergencia: " + mision.getDescripcionEmergencia());
        System.out.println("idEmergencia: " + mision.getIdEmergencia());

    }
        
        initComponents();
        int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
                        dtcEmergencia.getDateEditor().setEnabled(false);
        cargarDatos();
    }
    
    
     public static void initfrmActualizarInventario(Misiones mision) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
          UIManager.put("ComboBox.background", new Color(0xFFFFFF));       
        UIManager.put("ComboBox.foreground", Color.DARK_GRAY);              
        UIManager.put("ComboBox.selectionBackground", new Color(0xFF7043)); 
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);         
        UIManager.put("ComboBox.border", BorderFactory.createLineBorder(new Color(0xD9D9D9), 1)); 
        UIManager.put( "Component.arrowType", "triangle" );

        UIManager.put("TextField.arc", 50); 
        UIManager.put("ComboBox.arc", 50);   
        Misiones modelo = new Misiones();
        frmActualizarMision vista = new frmActualizarMision(mision);
        ctrlActualizarMision controlador = new ctrlActualizarMision(modelo, vista);
        vista.setVisible(true);
    }
     
      private  void cargarDatos() {
        txtDescripcion.setText(mision.getDescripcionMision());
        dtcEmergencia.setDate(mision.getFechaMision());
        Misiones modelo = new Misiones();
         modelo.cargarComboBoxEmergencias(cmbEmergencia, mision.getIdEmergencia());
           idMision = mision.getIdMision();
    }
       
        public int obtenerIdMision() {
        return idMision; 
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
        panelRound2 = new Vistas.PanelRound();
        txtDescripcion = new Vistas.TextFieldGris();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dtcEmergencia = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cmbEmergencia = new javax.swing.JComboBox<>();
        btnEmergencias = new Vistas.btnRojoForms();
        btnVerRegistro = new Vistas.btnNaranjaForms();
        btnActualizar = new Vistas.btnNaranjaForms();
        btnInformes = new Vistas.btnRojoForms();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtDescripcion.setHint("");
        panelRound2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 490, 120));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Emergencia tratada");
        panelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Descripción de la misión");
        panelRound2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        panelRound2.add(dtcEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 230, 40));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha de la misión");
        panelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        panelRound2.add(cmbEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 230, 40));

        btnEmergencias.setText("Ver emergencias");
        btnEmergencias.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnEmergencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergenciasActionPerformed(evt);
            }
        });
        panelRound2.add(btnEmergencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 160, 30));

        btnVerRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/contrato.png"))); // NOI18N
        btnVerRegistro.setText("Ver registro");
        btnVerRegistro.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        panelRound2.add(btnVerRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 210, 50));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/anadir.png"))); // NOI18N
        btnActualizar.setText("Actualizar datos");
        btnActualizar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        panelRound2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 240, 50));

        btnInformes.setText("Ver informes");
        btnInformes.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformesActionPerformed(evt);
            }
        });
        panelRound2.add(btnInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 140, 30));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Informe");
        panelRound2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/misionNew.png"))); // NOI18N
        panelRound2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 300, 270));

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 910, 540));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(" Ver registro misiones > Actualizar misión");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnEmergenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmergenciasActionPerformed

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
            java.util.logging.Logger.getLogger(frmActualizarMision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmActualizarMision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmActualizarMision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmActualizarMision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnNaranjaForms btnActualizar;
    public Vistas.btnRojoForms btnEmergencias;
    public Vistas.btnRojoForms btnInformes;
    public javax.swing.JButton btnMenu;
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
