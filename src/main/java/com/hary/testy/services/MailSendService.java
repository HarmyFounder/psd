package com.hary.testy.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSendService {


    final String from = "ofbrick121@gmail.com";


    String host = "smtp.gmail.com";
    String smtpPort = "465";

    Properties properties = new Properties();

    {
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }

    Session session = Session.getInstance(properties,
            new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "qzxhxzfbtplttsat");
                }
            });

    public void send(String text, String recipientGmail, String subject) throws MessagingException, InterruptedException {

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientGmail));
        message.setSubject(subject);
        message.setText(text);

        Transport.send(message);
        System.out.println("message sent");

    }

}
