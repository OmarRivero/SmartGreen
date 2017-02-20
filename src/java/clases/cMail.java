/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class cMail {
    
    public String _error = "";
    public String _para = "";
    public String _cuerpoMsj = "";
    public String _de = "smartgreena@gmail.com";
    public String _titulo = "";
    
    public cMail()
    {
        
    }
    
    public boolean mandaMail(String para, String titulo, String msj)
    {
        boolean envio = false;
        this._titulo = titulo;
        this._cuerpoMsj = msj;
        this._para = para;
        
        try
        {
            
            // Configuracion de la cuenta de envio de mail
            Properties confMail = new Properties();
            confMail.setProperty("mail.smtp.host", "smtp.gmail.com");
            confMail.setProperty("mail.smtp.starttls.enable", "true");
            confMail.setProperty("mail.smtp.port", "587");
            confMail.setProperty("mail.smtp.user", "smartgreena@gmail.com");
            confMail.setProperty("mail.smtp.auth", "true");
            
            // Sesion
            Session session = Session.getDefaultInstance(confMail);
            
            // Creamos el Mail
            MimeMessage correo = new MimeMessage(session);
            correo.setFrom(new InternetAddress(this._de));
            correo.addRecipient(Message.RecipientType.TO, new InternetAddress(this._para));
            correo.setSubject(this._titulo);
            correo.setText(this._cuerpoMsj);

            // Enviamos Mail .
            Transport t = session.getTransport("smtp");
            t.connect("smartgreena@gmail.com", "gysobgxsiclhqpvh");
            t.sendMessage(correo, correo.getAllRecipients());

            // Cerramos conexion.
            t.close();
            envio = true;
        }
        catch (Exception e)
        {
            
            this._error = e.getMessage();
        }
        return envio;
    }
    
    public boolean emailContact(String email, String subject, String message, String name){
        
        _para = "smartgreena@gmail.com";      
        String asunto = "Mensaje de contacto para SmartGreen con el asunto: " + subject;
        String mensaje = "Contenido."
                       + "\nNombre:\n" + name
                       + "\nCorreo:\n" + email
                       + "\nMensaje:\n " + message;
        
        boolean envio = mandaMail(_para, asunto, mensaje);
        
        return envio;
    }
    
}