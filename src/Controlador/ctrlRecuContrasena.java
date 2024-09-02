
package Controlador;

import Modelo.CredencialesRecuContra;
import Modelo.EnviarCodigo;
import Vistas.frmRecuperacionContrasena;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;






public class ctrlRecuContrasena implements MouseListener {
    
   private CredencialesRecuContra Modelo;
    private frmRecuperacionContrasena Vistas;

    public ctrlRecuContrasena(CredencialesRecuContra Modelo,frmRecuperacionContrasena Vistas){
    
        this.Modelo = Modelo;
        this.Vistas = Vistas;
        
         Vistas.btnRecuContra.addMouseListener(this);

    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
          if(e.getSource()== Vistas.btnRecuContra)
        {
          Random random = new Random();
          
          int numeroAleatorio = 100000 + random.nextInt(900000);
          
           String recipient = Vistas.txtRecuCorreo.getText();
            String subject = "Recuperacion de contraseña";
            String content = "Este es el codigo de recuperacion:" + numeroAleatorio;

          EnviarCodigo.enviarCorreo(recipient, subject, content);
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
