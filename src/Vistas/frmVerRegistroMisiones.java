/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlMisiones;
import Modelo.ClaseConexion;
import Modelo.Misiones;
import Vistas.drawer.MyDrawerBuilder;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

/**
 *
 * @author User
 */
public class frmVerRegistroMisiones extends javax.swing.JFrame {

    /**
     * Creates new form frmVerRegistroMisiones
     */
    public frmVerRegistroMisiones() {
        GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        initComponents();
        
        jtbMisiones.setDefaultEditor(Object.class, null); // Deshabilita la edición

        int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
    }
    
    public static void initFrmVerRegistroMisiones() {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("vistas.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatLightLaf.setup();
          UIManager.put("Table.background", new Color(0xFFFFFF));              
        UIManager.put("Table.foreground", Color.BLACK);                       
        UIManager.put("Table.selectionBackground", new Color(0xFFAD7A));       
        UIManager.put("Table.selectionForeground", Color.WHITE);               
        UIManager.put("Table.gridColor", new Color(0xDDDDDD));              
        UIManager.put("TableHeader.background", new Color(0xF5F5F5));          
        UIManager.put("TableHeader.foreground", Color.BLACK);                  
        UIManager.put("TableHeader.font", new Font("Microsoft Jheng UI", Font.BOLD, 14));  
        UIManager.put("Table.alternateRowColor", new Color(0xF8F8F8));        
        
        frmVerRegistroMisiones vista = new frmVerRegistroMisiones();
        Misiones modelo = new Misiones();
        ctrlMisiones controlador = new ctrlMisiones(vista, modelo);
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
        panelRound1 = new Vistas.PanelRound();
        btnMenu = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMisiones = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        JTextField = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JLabel();
        btnActualizar = new Vistas.btnRojoForms();
        btnEliminar = new Vistas.btnRojoForms();
        btnGenerarReporte = new Vistas.btnNegroForms();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 139, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 673));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Misiones > Ver Registro ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 47, -1, -1));

        jtbMisiones.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jtbMisiones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbMisiones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 107, 774, -1));

        txtBuscar.setBackground(new java.awt.Color(255, 173, 122));
        txtBuscar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setBorder(null);
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.setMargin(new java.awt.Insets(2, 10, 2, 6));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 556, 350, 45));

        JTextField.setBackground(new java.awt.Color(192, 109, 58));
        JTextField.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        JTextField.setForeground(new java.awt.Color(255, 255, 255));
        JTextField.setText("   Buscar:");
        JTextField.setBorder(null);
        JTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JTextField.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        JTextField.setEnabled(false);
        JTextField.setMargin(new java.awt.Insets(2, 10, 2, 6));
        jPanel1.add(JTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 556, 110, 45));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Buscar.png"))); // NOI18N
        btnBuscar.setToolTipText("");
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 556, 30, 45));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/ActualizarNew.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 212, 190, 60));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/EliminarNew.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 372, 190, 60));

        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/informe.png"))); // NOI18N
        btnGenerarReporte.setText("  Generar reporte");
        btnGenerarReporte.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 20)); // NOI18N
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 568, 266, 66));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
    try {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vistas/Misiones.jasper"));
    JasperPrint jprint = JasperFillManager.fillReport(report, null, ClaseConexion.getConexion());

    JasperViewer view = new JasperViewer(jprint, false);
    view.setTitle("Reporte de misiones");
    view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    view.setVisible(true);
} catch (Exception e) {
    System.out.println("Error al mostrar el reporte: " + e);
}
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

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
            java.util.logging.Logger.getLogger(frmVerRegistroMisiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVerRegistroMisiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVerRegistroMisiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVerRegistroMisiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextField;
    public Vistas.btnRojoForms btnActualizar;
    public javax.swing.JLabel btnBuscar;
    public Vistas.btnRojoForms btnEliminar;
    public Vistas.btnNegroForms btnGenerarReporte;
    public javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbMisiones;
    private Vistas.PanelRound panelRound1;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
