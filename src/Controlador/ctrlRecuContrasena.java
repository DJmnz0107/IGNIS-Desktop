
package Controlador;

import Modelo.CredencialesRecuContra;
import Modelo.EnviarCodigo;
import Modelo.Usuarios;
import Vistas.frmRecuperacionContrasena;
import Vistas.frmVerificarCodigo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;






public class ctrlRecuContrasena implements MouseListener {
    
    static Random random = new Random();
           
     static int numeroAleatorio = 100000 + random.nextInt(900000);
    
     
   private CredencialesRecuContra Modelo;
    private frmRecuperacionContrasena Vistas;

    public ctrlRecuContrasena(CredencialesRecuContra Modelo,frmRecuperacionContrasena Vistas){
    
        this.Modelo = Modelo;
        this.Vistas = Vistas;
        
         Vistas.btnRecuContra.addMouseListener(this);
         Vistas.btnVerficarCode.addMouseListener(this);

    
    }

    @Override
public void mouseClicked(MouseEvent e) {
    if(e.getSource() == Vistas.btnRecuContra) {
        Usuarios VerificarUser = new Usuarios();
        VerificarUser.setNombre_usuario(Vistas.txtRecuUsuario.getText()); 
        
        
        boolean ReviarUser = VerificarUser.revisarRecuperacionContra();
        if (ReviarUser) {
            
          
            String recipient = Vistas.txtRecuCorreo.getText();
            String subject = "Recuperación de contraseña";
            String content = "Este es el código de recuperación: " + numeroAleatorio;

            EnviarCodigo.enviarCorreo(recipient, subject, content);
            JOptionPane.showMessageDialog(Vistas, "Correo enviado", "Recuperación de Contraseña", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(Vistas, "Usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    if(e.getSource() == Vistas.btnVerficarCode) {
        frmVerificarCodigo.initFrmVerificar();
        Vistas.dispose();
    }
}

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
    
    
}
