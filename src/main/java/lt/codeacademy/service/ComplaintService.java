package lt.codeacademy.service;

import lt.codeacademy.entity.Complaint;
import lt.codeacademy.service.EmailService;

import lt.codeacademy.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository repo;
    private final EmailService emailService;

    public ComplaintService(ComplaintRepository repo,EmailService emailService) {
        this.repo = repo;
        this.emailService = emailService;
    }

    public void createComplaint(Complaint complaint) {
        complaint.setStatus("OPEN");
        complaint.setCreatedAt(LocalDateTime.now());
        repo.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return repo.findAll();
    }

    public List<Complaint> getUserComplaints(Long userId) {
        return repo.findByUserId(userId);
    }

    public void updateStatus(Long id, String status) {
        Complaint c = repo.findById(id).orElseThrow();

        c.setStatus(status);

        if ("RESOLVED".equals(status)) {
            c.setResolvedAt(LocalDateTime.now());
        }

        repo.save(c);

        // ✅ SEND EMAIL AFTER STATUS UPDATE
        emailService.sendStatusUpdateEmail(
                c.getUser().getEmail(),
                c.getTitle(),
                status
        );
    }

}
