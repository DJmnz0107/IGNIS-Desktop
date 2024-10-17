
package Controlador;

import Modelo.CredencialesRecuContra;
import Modelo.EnviarCodigo;
import Modelo.Usuarios;
import Vistas.frmLogin;
import Vistas.frmRecuperacionContrasena;
import Vistas.frmVerificarCodigo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;






public class ctrlRecuContrasena implements MouseListener {
    
    static Random random = new Random();
           
     static int numeroAleatorio = 100000 + random.nextInt(900000);
     
     public static Usuarios verificarUsuario = new Usuarios();

    
     
   private CredencialesRecuContra Modelo;
    private frmRecuperacionContrasena Vistas;

    public ctrlRecuContrasena(CredencialesRecuContra Modelo,frmRecuperacionContrasena Vistas){
    
        this.Modelo = Modelo;
        this.Vistas = Vistas;
        
         Vistas.btnRecuContra.addMouseListener(this);
         Vistas.btnVerficarCode.addMouseListener(this);
         Vistas.imgBack.addMouseListener(this);

    
    }

    @Override
public void mouseClicked(MouseEvent e) {
    if(e.getSource() == Vistas.btnRecuContra) {
        
        
        
        if(Vistas.txtRecuCorreo.getText().isEmpty() || Vistas.txtRecuUsuario.getText().isEmpty()) {            
            JOptionPane.showMessageDialog(Vistas, "Porfavor, llena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                 return;            
        }
        
        verificarUsuario.setNombre_usuario(Vistas.txtRecuUsuario.getText()); 
        
        
        boolean ReviarUser = verificarUsuario.revisarRecuperacionContra();
        if (ReviarUser) {
           
        String recipient = Vistas.txtRecuCorreo.getText();
        String subject = "Recuperación de contraseña";
        String codigoRecu = String.valueOf(numeroAleatorio); // Convertir el número aleatorio a String
        String mensaje = "Hola, aquí tienes tu código de recuperación"; // Mensaje personalizado

        EnviarCodigo.enviarCorreo(recipient, subject, codigoRecu, mensaje);
        } else {
            JOptionPane.showMessageDialog(Vistas, "Usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    if(e.getSource() == Vistas.btnVerficarCode) {
        frmVerificarCodigo.initFrmVerificar();
        Vistas.dispose();
    }
    
    if(e.getSource() == Vistas.imgBack) {
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
