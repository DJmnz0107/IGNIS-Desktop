/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlAgregarInventario;
import Controlador.ctrlTransportes;
import Modelo.Recursos;
import Modelo.Transportes;
import Vistas.drawer.MyDrawerBuilder;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

/**
 *
 * @author Diego
 */
public class frmAgregarInventario extends javax.swing.JFrame {
    private static frmAgregarInventario instance;

    /**
     * Creates new form frmAgregarInventario
     */
    public frmAgregarInventario() {
         GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
    
        initComponents();
        int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
        setLocationRelativeTo(null);
    

    }
    
    public static void initfrmAgregarInventario() {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
        frmAgregarInventario vista = new frmAgregarInventario();
        Recursos modelo = new Recursos();
        ctrlAgregarInventario controlador = new ctrlAgregarInventario(vista, modelo);
        vista.setVisible(true);
        
}

public static frmAgregarInventario getInstance() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbDisponibilidad = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        imgInventario = new javax.swing.JLabel();
        imgAgregar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionRecurso = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dtcRecepcion = new com.toedter.calendar.JDateChooser();
        panelRound1 = new Vistas.PanelRound();
        btnMenu = new javax.swing.JButton();
        txtNombreInventario = new Vistas.TextFieldBlanco();
        btnVerInventario = new Vistas.btnRojoForms();
        btnInsertar = new Vistas.btnRojoForms();
        imgRecurso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 139, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar foto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, 20));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inicio > Inventario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción del recurso");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, 20));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre del recurso");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, 20));

        cmbDisponibilidad.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        cmbDisponibilidad.setForeground(new java.awt.Color(240, 139, 77));
        cmbDisponibilidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "En uso" }));
        jPanel1.add(cmbDisponibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 200, 40));

        cmbEstado.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        cmbEstado.setForeground(new java.awt.Color(240, 139, 77));
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arruinado", "Usado", "Nuevo" }));
        jPanel1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 200, 40));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado en el que se encuentra");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, -1, 20));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de recepción");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, -1, 20));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Disponibilidad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, 20));

        imgInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/inventarioMedio.png"))); // NOI18N
        jPanel1.add(imgInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 340, 280));

        imgAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/agregarBlanco.png"))); // NOI18N
        jPanel1.add(imgAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 40, 40));

        txtDescripcionRecurso.setColumns(20);
        txtDescripcionRecurso.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtDescripcionRecurso.setForeground(new java.awt.Color(240, 139, 77));
        txtDescripcionRecurso.setLineWrap(true);
        txtDescripcionRecurso.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionRecurso);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 430, 180));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Volver.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 40, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("IGNIS");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, -1));

        dtcRecepcion.setBackground(new java.awt.Color(255, 255, 255));
        dtcRecepcion.setForeground(new java.awt.Color(240, 139, 77));
        jPanel1.add(dtcRecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 230, 40));

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
                .addContainerGap(594, Short.MAX_VALUE))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 650));
        jPanel1.add(txtNombreInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 430, 70));

        btnVerInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/verInventarioMini.png"))); // NOI18N
        btnVerInventario.setText("Ver inventario");
        btnVerInventario.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jPanel1.add(btnVerInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 220, 50));

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/agregarNew.png"))); // NOI18N
        btnInsertar.setText("Agregar información");
        btnInsertar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jPanel1.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 220, 50));
        jPanel1.add(imgRecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 200, 120));

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

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(frmAgregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnRojoForms btnInsertar;
    public javax.swing.JButton btnMenu;
    public Vistas.btnRojoForms btnVerInventario;
    public javax.swing.JComboBox<String> cmbDisponibilidad;
    public javax.swing.JComboBox<String> cmbEstado;
    public com.toedter.calendar.JDateChooser dtcRecepcion;
    public javax.swing.JLabel imgAgregar;
    public javax.swing.JLabel imgInventario;
    public javax.swing.JLabel imgRecurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private Vistas.PanelRound panelRound1;
    public javax.swing.JTextArea txtDescripcionRecurso;
    public Vistas.TextFieldBlanco txtNombreInventario;
    // End of variables declaration//GEN-END:variables
}
