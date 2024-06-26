package com.apprenant_p4.Gestion_Ticket.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@AllArgsConstructor
public class Mail {
    private final JavaMailSender javaMailSender;

    private void sendEmailNotification(String mail, String message){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(mail);
            mimeMessageHelper.setSubject("Nouvelle Notification de Soumission de Tickey");
            mimeMessageHelper.setText(message, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
