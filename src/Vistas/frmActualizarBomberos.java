/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlActualizarBomberos;
import Modelo.Bomberos;
import Vistas.drawer.MyDrawerBuilder;
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
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

/**
 *
 * @author User
 */
public class frmActualizarBomberos extends javax.swing.JFrame {

    
    
    private Bomberos bomberos;
    private int idBombero;
    private String rutaImagen;
    private int idUsuario;
    /**
     * Creates new form frmActualizarBomberos
     */
    public frmActualizarBomberos(Bomberos bomberos) {
        GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        
        setTitle("IGNIS - Actualizar Bomberos");
        
        
        this.bomberos = bomberos;
        
        if (bomberos == null) {
        System.out.println("El objeto aspirante es null");
    } else {
        System.out.println("El recurso tiene los siguientes datos: ");
        System.out.println("Nombre: " + bomberos.getNombre_bombero());
        System.out.println("Apellido: " + bomberos.getApellido_bombero());
        System.out.println("Experiencia: " + bomberos.getExperiencia_bombero());
        System.out.println("Especializacion: " + bomberos.getEspecializacion_bombero());
        System.out.println("Foto: " + bomberos.getFoto_bombero());
        System.out.println("idUsuario: " + bomberos.getId_usuario());
         System.out.println("NombreUsuario: " + bomberos.getNombre_usuario());
         
                System.out.println("idBombero: " + bomberos.getId_bombero());

                  


    }

        initComponents();
        int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
                   
        cargarDatos();
    }
    
    public static void initfrmActualizarBomberos(Bomberos bomberos){
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
        
    
    Bomberos Modelo = new Bomberos();
    frmActualizarBomberos Vistas = new frmActualizarBomberos(bomberos);
    ctrlActualizarBomberos controlador = new ctrlActualizarBomberos(Modelo, Vistas);
    Vistas.setVisible(true);
    
    }
    
    
    public void cargarDatos() {
    // Cargar los datos del aspirante
    txtNombreBombero.setText(bomberos.getNombre_bombero());
    txtApellidoBombero.setText(bomberos.getApellido_bombero());
    txtExperiencia.setText(bomberos.getExperiencia_bombero());
    txtEspecializacion.setText(bomberos.getEspecializacion_bombero());

            Bomberos modelo = new Bomberos();
                modelo.CargarComboUsuariosUpdate(cmbUsuario, bomberos.getId_usuario());

    lblFoto.setIcon(redimensionarImagen(bomberos.getFoto_bombero(), 150, 150));
    idUsuario = bomberos.getId_usuario();
    idBombero = bomberos.getId_bombero();
    rutaImagen = bomberos.getFoto_bombero();
}
    
                 private ImageIcon redimensionarImagen(String rutaImagen, int ancho, int alto) {
    ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
    Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    return new ImageIcon(imagenEscalada);
}
                 
                 public int obtenerIdUsuario() {
                     return idUsuario;
                 }
    
    
         public int obtenerIdBombero() {
             
        return idBombero; 
    }
        
        public String obtenerRutaImagen() {
        return rutaImagen; 
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
        lblFoto = new javax.swing.JLabel();
        panelRound31 = new Vistas.panelRound3();
        jLabel1 = new javax.swing.JLabel();
        txtNombreBombero = new Vistas.TextFieldGris();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoBombero = new Vistas.TextFieldGris();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEspecializacion = new Vistas.TextFieldGris();
        jLabel5 = new javax.swing.JLabel();
        cmbUsuario = new javax.swing.JComboBox<>();
        btnVerRegistro = new Vistas.btnRojoForms();
        btnActualizar = new Vistas.btnRojoForms();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtExperiencia = new javax.swing.JTextArea();
        btnAgregarFoto1 = new Vistas.btnRojoForms();
        imgBack = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 100, 110));

        panelRound31.setRoundBottomRight(50);
        panelRound31.setRoundTopLeft(50);
        panelRound31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setText("Ingresar especialización");
        panelRound31.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        txtNombreBombero.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreBombero.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtNombreBombero.setHint("");
        panelRound31.add(txtNombreBombero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 330, 40));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setText("Ingresar apellido");
        panelRound31.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        txtApellidoBombero.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoBombero.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtApellidoBombero.setHint("");
        panelRound31.add(txtApellidoBombero, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 330, 40));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel3.setText("Ingresar nombre");
        panelRound31.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel4.setText("Ingresar experiencia");
        panelRound31.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtEspecializacion.setForeground(new java.awt.Color(0, 0, 0));
        txtEspecializacion.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtEspecializacion.setHint("");
        panelRound31.add(txtEspecializacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 380, 40));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel5.setText("Usuario");
        panelRound31.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 72, -1));

        cmbUsuario.setBackground(new java.awt.Color(217, 217, 217));
        cmbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuarioActionPerformed(evt);
            }
        });
        panelRound31.add(cmbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 220, 40));

        btnVerRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/contrato.png"))); // NOI18N
        btnVerRegistro.setText("     Ver registro");
        btnVerRegistro.setToolTipText("");
        btnVerRegistro.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnVerRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRegistroActionPerformed(evt);
            }
        });
        panelRound31.add(btnVerRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 220, 50));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/ActualizarNew.png"))); // NOI18N
        btnActualizar.setText("    Actualizar Informacion");
        btnActualizar.setToolTipText("");
        btnActualizar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound31.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 270, 50));

        txtExperiencia.setBackground(new java.awt.Color(217, 217, 217));
        txtExperiencia.setColumns(20);
        txtExperiencia.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtExperiencia.setRows(5);
        jScrollPane2.setViewportView(txtExperiencia);

        panelRound31.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 830, 130));

        jPanel1.add(panelRound31, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 960, 450));

        btnAgregarFoto1.setText("     Agregar foto");
        btnAgregarFoto1.setToolTipText("");
        btnAgregarFoto1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnAgregarFoto1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(btnAgregarFoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 190, 40));

        imgBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Volver.png"))); // NOI18N
        jPanel1.add(imgBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 40, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("IGNIS");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, -1, -1));

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
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void cmbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsuarioActionPerformed

    private void btnVerRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(frmActualizarBomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmActualizarBomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmActualizarBomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmActualizarBomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vistas.btnRojoForms btnActualizar;
    public Vistas.btnRojoForms btnAgregarFoto1;
    public javax.swing.JButton btnMenu;
    public Vistas.btnRojoForms btnVerRegistro;
    public javax.swing.JComboBox<String> cmbUsuario;
    public javax.swing.JLabel imgBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblFoto;
    private Vistas.PanelRound panelRound1;
    private Vistas.panelRound3 panelRound31;
    public Vistas.TextFieldGris txtApellidoBombero;
    public Vistas.TextFieldGris txtEspecializacion;
    public javax.swing.JTextArea txtExperiencia;
    public Vistas.TextFieldGris txtNombreBombero;
    // End of variables declaration//GEN-END:variables
}
