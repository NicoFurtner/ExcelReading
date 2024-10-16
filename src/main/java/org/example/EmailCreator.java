package org.example;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EmailCreator {

    public static void main(String[] args) {
        // E-Mail-Daten
        String to = "empfaenger@example.com"; // Empfänger
        String subject = "Betreff der E-Mail"; // Betreff
        String body = "Inhalt der E-Mail."; // Inhalt

        // Erstelle die E-Mail
        createEmailFile(to, subject, body);
    }

    private static void createEmailFile(String to, String subject, String body) {
        try {
            // Erstelle eine neue E-Mail-Nachricht
            MimeMessage message = new MimeMessage(Session.getInstance(new Properties()));
            message.setFrom(new InternetAddress("deinemail@example.com")); // Absender
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            // Speichere die E-Mail in einer .eml-Datei
            try (FileOutputStream fos = new FileOutputStream("email.eml")) {
                message.writeTo(fos);
            }

            System.out.println("E-Mail-Datei 'email.eml' wurde erfolgreich erstellt.");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}

