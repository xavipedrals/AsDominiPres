package com.company.Services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by xavivaio on 13/06/2015.
 */
public class MailService {

    public void enviaMail(String dest, int punts) throws MessagingException {
        final String username = "projecte.as.grup.emx@gmail.com";
        final String password = "1597535emx";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        String asunto = "JOC2048 -";
        String contingutMail = "La teva puntuacio es de " + punts + "." +
                "\n\n Firmat: Servei de correu de 2048.";

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
                    InternetAddress.parse(dest));
            message.setSubject(asunto);
            message.setText(contingutMail);
            System.out.println("Transport send");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }



}
