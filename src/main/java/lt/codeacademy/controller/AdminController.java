package lt.codeacademy.controller;

import lt.codeacademy.service.ComplaintService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ComplaintService service;

    public AdminController(ComplaintService service) {
        this.service = service;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("complaints", service.getAllComplaints());
        return "admin-dashboard";
    }

    @PostMapping("/update-status")
    public String updateStatus(Long id, String status) {
        service.updateStatus(id, status);
        return "redirect:/admin/dashboard";
    }
}
