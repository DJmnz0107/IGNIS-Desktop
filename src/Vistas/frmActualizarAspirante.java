/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ctrlActualizarAspirantes;
import Controlador.ctrlActualizarInventario;
import Modelo.Aspirantes;
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

/**
 *
 * @author Diego
 */
public class frmActualizarAspirante extends javax.swing.JFrame {

    
      private Aspirantes aspirante;
            private int idAspirante;
                        private String rutaImagen;

    /**
     * Creates new form frmActualizarAspirante
     */
    public frmActualizarAspirante(Aspirantes aspirante) {
         GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerBuilder=new MyDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(myDrawerBuilder);
        
        setTitle("IGNIS - Actualizar Aspirante");
        
        
        
        this.aspirante = aspirante;
        
        
        //Verificar datos
            if (aspirante == null) {
        System.out.println("El objeto aspirante es null");
    } else {
        System.out.println("El recurso tiene los siguientes datos: ");
        System.out.println("Nombre: " + aspirante.getNombre_aspirante());
        System.out.println("Apellido: " + aspirante.getApellido_aspirante());
        System.out.println("DUI: " + aspirante.getDui_aspirante());
        System.out.println("Entrenamiento: " + aspirante.getEntrenamiento_aspirante());
        System.out.println("Edad: " + aspirante.getEdad_usuario());
        System.out.println("Foto: " + aspirante.getFoto_aspirante());
         System.out.println("Progreso: " + aspirante.getProgreso_aspirante());
         System.out.println("idBombero: " + aspirante.getId_bombero());
         System.out.println("nombreBombero: " + aspirante.getNombre_bombero());
         
                System.out.println("idAspirante: " + aspirante.getId_aspirante());

                  


    }

        initComponents();
        int iconWidth = 32;
int iconHeight = 32;

ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Vistas/resources/ignisFormsCircular.png"));
Image originalImage = iconoOriginal.getImage();

Image scaledImage = originalImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

setIconImage(scaledImage);
                
         JTextField duiField = txtDuiAspirante; 
        ((AbstractDocument) duiField.getDocument()).setDocumentFilter(new DuiDocumentFilter());
        cargarDatos();

    }
    
    //Metodo para inicializar el formulario
       public static void initfrmActualizarAspirante(Aspirantes aspirante) {
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
        Aspirantes modelo = new Aspirantes();
        frmActualizarAspirante vista = new frmActualizarAspirante(aspirante);
        ctrlActualizarAspirantes controlador = new ctrlActualizarAspirantes(modelo, vista);
        vista.setVisible(true);

    }
    
    
    
        //Cargar datos traidos desde la tabla
           public void cargarDatos() {
        // Cargar los datos del aspirante
        txtNombreAspirante.setText(aspirante.getNombre_aspirante());
        txtApellidoAspirante.setText(aspirante.getApellido_aspirante());
        txtEdadAspirante.setText(Integer.toString(aspirante.getEdad_usuario()));
        txtDuiAspirante.setText(aspirante.getDui_aspirante());
        txtEntrenamientoAspirante.setText(aspirante.getEntrenamiento_aspirante());
                Aspirantes modelo = new Aspirantes();
                    modelo.CargarComboBomberosUpdate(cmbBomberoMentor, aspirante.getId_bombero());

        txtProgresoAspirante.setText(aspirante.getProgreso_aspirante());
        imgAspirante.setIcon(redimensionarImagen(aspirante.getFoto_aspirante(), 150, 150));
        idAspirante = aspirante.getId_aspirante();
        rutaImagen = aspirante.getFoto_aspirante();
    }

       
      //Redimensionar la imagen para que se vea bien 
             private ImageIcon redimensionarImagen(String rutaImagen, int ancho, int alto) {
    ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
    Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    return new ImageIcon(imagenEscalada);
}
       
        public int obtenerIdAspirante() {
        return idAspirante; 
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
        panelRound31 = new Vistas.panelRound3();
        txtNombreAspirante = new Vistas.TextFieldGris();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProgresoAspirante = new Vistas.TextFieldGris();
        jLabel4 = new javax.swing.JLabel();
        txtEdadAspirante = new Vistas.TextFieldGris();
        txtDuiAspirante = new Vistas.TextFieldGris();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbBomberoMentor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtApellidoAspirante = new Vistas.TextFieldGris();
        txtEntrenamientoAspirante = new Vistas.TextFieldGris();
        jLabel8 = new javax.swing.JLabel();
        btnAgregarFoto = new Vistas.btnRojoForms();
        btnActualizar = new Vistas.btnRojoForms();
        btnVerAspirantes = new Vistas.btnRojoForms();
        imgAspirante = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        imgBack = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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

        panelRound31.setRoundBottomLeft(20);
        panelRound31.setRoundBottomRight(20);
        panelRound31.setRoundTopLeft(20);
        panelRound31.setRoundTopRight(20);
        panelRound31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtNombreAspirante.setHint("");
        panelRound31.add(txtNombreAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 69, 290, 49));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel1.setText("Nombre del aspirante");
        panelRound31.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 200, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel3.setText("Apellido del aspirante");
        panelRound31.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 200, -1));

        txtProgresoAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtProgresoAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtProgresoAspirante.setHint("");
        panelRound31.add(txtProgresoAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 290, 80));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel4.setText("Edad");
        panelRound31.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 70, -1));

        txtEdadAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtEdadAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtEdadAspirante.setHint("");
        panelRound31.add(txtEdadAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 140, 49));

        txtDuiAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtDuiAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtDuiAspirante.setHint("");
        panelRound31.add(txtDuiAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 290, 49));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel5.setText("DUI");
        panelRound31.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 60, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel6.setText("Bombero mentor");
        panelRound31.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        cmbBomberoMentor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelRound31.add(cmbBomberoMentor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 160, 34));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel7.setText("Progreso del aspirante");
        panelRound31.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        txtApellidoAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtApellidoAspirante.setHint("");
        panelRound31.add(txtApellidoAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 290, 49));

        txtEntrenamientoAspirante.setForeground(new java.awt.Color(0, 0, 0));
        txtEntrenamientoAspirante.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtEntrenamientoAspirante.setHint("");
        panelRound31.add(txtEntrenamientoAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 370, 80));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 16)); // NOI18N
        jLabel8.setText("Entrenamiento del aspirante");
        panelRound31.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        btnAgregarFoto.setText("    Agregar foto");
        btnAgregarFoto.setAlignmentY(0.0F);
        btnAgregarFoto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFotoActionPerformed(evt);
            }
        });
        panelRound31.add(btnAgregarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, 155, 51));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/anadir.png"))); // NOI18N
        btnActualizar.setText("  Actualizar datos");
        btnActualizar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        panelRound31.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 246, 60));

        btnVerAspirantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/contrato.png"))); // NOI18N
        btnVerAspirantes.setText("   Ver aspirantes");
        btnVerAspirantes.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        panelRound31.add(btnVerAspirantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 224, 60));
        panelRound31.add(imgAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 150, 210));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/aspirantesMini.png"))); // NOI18N
        panelRound31.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 270, 210));

        jPanel1.add(panelRound31, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 1000, 570));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Registro aspirantes > Actualizar aspirantes");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        imgBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/resources/Volver.png"))); // NOI18N
        jPanel1.add(imgBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 6, 40, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("IGNIS");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
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

    private void btnAgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarFotoActionPerformed

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
            java.util.logging.Logger.getLogger(frmActualizarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmActualizarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmActualizarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmActualizarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public Vistas.btnRojoForms btnAgregarFoto;
    public javax.swing.JButton btnMenu;
    public Vistas.btnRojoForms btnVerAspirantes;
    public javax.swing.JComboBox<String> cmbBomberoMentor;
    public javax.swing.JLabel imgAspirante;
    public javax.swing.JLabel imgBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private Vistas.PanelRound panelRound1;
    private Vistas.panelRound3 panelRound31;
    public Vistas.TextFieldGris txtApellidoAspirante;
    public Vistas.TextFieldGris txtDuiAspirante;
    public Vistas.TextFieldGris txtEdadAspirante;
    public Vistas.TextFieldGris txtEntrenamientoAspirante;
    public Vistas.TextFieldGris txtNombreAspirante;
    public Vistas.TextFieldGris txtProgresoAspirante;
    // End of variables declaration//GEN-END:variables
}
