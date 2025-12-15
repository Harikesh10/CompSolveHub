package lt.codeacademy.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendStatusUpdateEmail(String toEmail,
                                      String complaintTitle,
                                      String newStatus) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Complaint Status Update");
        message.setText(
                "Hello,\n\n" +
                "Your complaint titled \"" + complaintTitle + "\" has been updated.\n\n" +
                "Current Status: " + newStatus + "\n\n" +
                "Regards,\nComplaintTrack Team"
        );

        mailSender.send(message);
    }
}
