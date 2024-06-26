package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Notification;
import com.apprenant_p4.Gestion_Ticket.modele.Ticket;
import com.apprenant_p4.Gestion_Ticket.repository.NotificationRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl {
    private final JavaMailSender javaMailSender;
    private final NotificationRepository notificationRepository;

    public void envoyerNotification(Ticket ticket, String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setTicket(ticket);
        notification.setUtilisateur(ticket.getUtilisateur());

        notificationRepository.save(notification);
        sendEmailNotification(ticket.getUtilisateur().getEmail(), message);
    }

    private void sendEmailNotification(String mail, String message) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(mail);
            mimeMessageHelper.setSubject("Nouvelle Notification du Ticket");
            mimeMessageHelper.setText(message, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
