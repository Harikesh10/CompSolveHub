package lt.codeacademy.controller;

import lt.codeacademy.entity.Complaint;
import lt.codeacademy.entity.User;
import lt.codeacademy.service.ComplaintService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final ComplaintService service;

    public UserController(ComplaintService service) {
        this.service = service;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("complaints", service.getUserComplaints(user.getId()));
        return "user-dashboard";
    }

    @GetMapping("/create")
    public String createPage() {
        return "create-complaint";
    }

    @PostMapping("/create")
    public String create(Complaint complaint, HttpSession session) {
        User user = (User) session.getAttribute("user");
        complaint.setUser(user);
        service.createComplaint(complaint);
        return "redirect:/user/dashboard";
    }
}
