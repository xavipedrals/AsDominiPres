package com.company.Domini.Mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by xavivaio on 13/06/2015.
 */
public class MailService {

    public static void main(String[] args) {
        //TODO Falta trure tot de la funcio main
        String username = "projecte.as.grup.emx@gmail.com";
        String password = "1597535emx";
        String destinatari = "xavi.pedrals@gmail.com";
        String asunto = "Hola hola";
        int puntuacio = 100;
        String contingutMail = "Hola Crac" +
                "\n\n Firmat: emailDummy";


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatari));
            message.setSubject(asunto);
            message.setText(contingutMail);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
