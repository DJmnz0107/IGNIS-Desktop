/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


/**
 *
 
@author USUARIO*/
public class EnviarCodigo {

    public static void enviarCorreo(String recipient, String subject, String codigoRecu, String mensaje) {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");


        final String myAccountEmail = "ignissoftwaredevelopers@gmail.com";
        final String password = "kllj pgxb dmrr zhgn";


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);

                        // Aquí establecemos el contenido HTML del mensaje
            String htmlContent = "<html>" +
                    "<body style='background-color: #fefefe; font-family: Arial, sans-serif;'>" +
                    "<div style='max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px;'>" +
                    "<h2 style='color: #FF7043; text-align: center;'>Recuperación de Contraseña</h2>" +
                    "<p style='color: #555; font-size: 16px;'>" +
                    "<strong>" + mensaje + "</strong>,<br><br>" +
                    "Te saluda el equipo de Ignis Software Developers.<br>" +
                    "Aquí tienes tu código de recuperación:" +
                    "</p>" +
                    "<div style='background-color: #FF7043; color: white; font-size: 24px; text-align: center; padding: 15px; border-radius: 5px;'>" +
                    codigoRecu +
                    "</div>" +
                    "<p style='color: #555; font-size: 14px;'>" +
                    "Si no has solicitado este código, por favor ignora este mensaje.<br><br>" +
                    "Gracias,<br>" +
                    "El equipo de Ignis." +
                    "</p>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            message.setContent(htmlContent, "text/html");

            Transport.send(message);


            JOptionPane.showMessageDialog(null, "Correo enviado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException e) {
            // Mostrar mensaje de error en caso de falla
            JOptionPane.showMessageDialog(null, "Error al enviar el correo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
