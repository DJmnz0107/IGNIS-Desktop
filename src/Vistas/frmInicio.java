/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlInicio;
import Controlador.ctrlLogin;
import Modelo.Usuarios;
import Vistas.drawer.MyDrawerBuilder;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

/**
 *
 * @author angel
 */
public class frmInicio extends javax.swing.JFrame {
        private static frmInicio instance;


    /**
     * Creates new form frmInicio
     */
    public frmInicio() {
               initComponents();
         GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        
        int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
        
        
        
        String usuario = ctrlLogin.nombreUsuario;
        
        
       if (usuario != null) {
            jlblTextoInicio.setText("Bienvenido a IGNIS, nos alegra verte de nuevo " + usuario);
        } else {
            jlblTextoInicio.setText("Bienvenido a IGNIS");
        }
    }
    
    
    public static void initfrmInicio() {       
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatLightLaf.setup();      
        frmInicio vista = new frmInicio();
        ctrlInicio controlador = new ctrlInicio(vista);       
        vista.setVisible(true);
}
    
       public static frmInicio getInstance() {
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
        jlblTextoInicio = new javax.swing.JLabel();
        panelRound1 = new Vistas.PanelRound();
        btnMenu = new javax.swing.JButton();
        btnCrearUsuario = new Vistas.btnInicio2();
        btnCerrarSesión = new Vistas.btnInicio3();
        btnVerCambios = new Vistas.btnInicio4();
        panelRound2 = new Vistas.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        btnSeguimiento = new Vistas.btnInicio();
        btnBomberos = new Vistas.btnInicio();
        btnTransporte = new Vistas.btnInicio();
        btnInventario = new Vistas.btnInicio();
        btnEstadisticas = new Vistas.btnInicio();
        btnMisiones = new Vistas.btnInicio();
        btnInformes = new Vistas.btnInicio();
        btnEmergencias = new Vistas.btnInicio();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 139, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTextoInicio.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 28)); // NOI18N
        jlblTextoInicio.setForeground(new java.awt.Color(255, 255, 255));
        jlblTextoInicio.setText("Text");
        jPanel1.add(jlblTextoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 890, 50));

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

        btnCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoAgregarU.png"))); // NOI18N
        btnCrearUsuario.setText("Crear nuevo usuario");
        btnCrearUsuario.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jPanel1.add(btnCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 250, 50));

        btnCerrarSesión.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoCerrar.png"))); // NOI18N
        btnCerrarSesión.setText("Cerrar sesión");
        btnCerrarSesión.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jPanel1.add(btnCerrarSesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 240, 50));

        btnVerCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/iconoVer.png"))); // NOI18N
        btnVerCambios.setText("Ver cambios");
        btnVerCambios.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jPanel1.add(btnVerCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, 230, 50));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 173, 122));
        jLabel2.setText("Funciones principales");
        panelRound2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        btnSeguimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/hiring.png"))); // NOI18N
        btnSeguimiento.setText("Seguimiento");
        btnSeguimiento.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        panelRound2.add(btnSeguimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 190, 60));

        btnBomberos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/firefighter (1).png"))); // NOI18N
        btnBomberos.setText("Bomberos");
        btnBomberos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        panelRound2.add(btnBomberos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 190, 60));

        btnTransporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/truck.png"))); // NOI18N
        btnTransporte.setText("Transporte");
        btnTransporte.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        panelRound2.add(btnTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 190, 60));

        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/inventory.png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        panelRound2.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 190, 60));

        btnEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/pie-chart.png"))); // NOI18N
        btnEstadisticas.setText("Estadisticas");
        btnEstadisticas.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        panelRound2.add(btnEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 190, 60));

        btnMisiones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/mission.png"))); // NOI18N
        btnMisiones.setText("Misiones");
        btnMisiones.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        panelRound2.add(btnMisiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 190, 60));

        btnInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/file (2).png"))); // NOI18N
        btnInformes.setText("Informes");
        btnInformes.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        panelRound2.add(btnInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 190, 60));

        btnEmergencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/siren.png"))); // NOI18N
        btnEmergencias.setText("Emergencias");
        btnEmergencias.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        panelRound2.add(btnEmergencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 190, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/ignisMinii.png"))); // NOI18N
        panelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 780, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmInicio();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnInicio btnBomberos;
    public Vistas.btnInicio3 btnCerrarSesión;
    public Vistas.btnInicio2 btnCrearUsuario;
    public Vistas.btnInicio btnEmergencias;
    public Vistas.btnInicio btnEstadisticas;
    public Vistas.btnInicio btnInformes;
    public Vistas.btnInicio btnInventario;
    public javax.swing.JButton btnMenu;
    public Vistas.btnInicio btnMisiones;
    public Vistas.btnInicio btnSeguimiento;
    public Vistas.btnInicio btnTransporte;
    public Vistas.btnInicio4 btnVerCambios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jlblTextoInicio;
    private Vistas.PanelRound panelRound1;
    private Vistas.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
