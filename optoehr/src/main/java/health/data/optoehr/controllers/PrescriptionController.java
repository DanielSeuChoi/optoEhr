package health.data.optoehr.controllers;

import javax.validation.Valid;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import health.data.optoehr.models.Patient;
import health.data.optoehr.models.Prescription;
import health.data.optoehr.models.User;
import health.data.optoehr.services.PatientService;
import health.data.optoehr.services.UserService;
import health.data.optoehr.validators.PrescriptionValidator;
import health.data.optoehr.services.PrescriptionService;

@Controller
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;

    @PostMapping("/createrx")
    public String rxForm(
            @Valid @ModelAttribute("prescription") Prescription prescription,
            Model model,
            BindingResult result) {
        prescriptionService.createRx(prescription);
        return "redirect:/search";
    }

    @RequestMapping("/patients/{id}")
    public String showPatient(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("prescription") Prescription prescription,
            Model model, Principal principal, Patient patientRx, BindingResult result) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("patientRx", prescriptionService.getPatientRx(patientRx));
        model.addAttribute("patient", patientService.getOnePatient(id));
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "prescriptionForm.jsp";
        }
        if (user.getRoles().get(0).getName().contains("ROLE_OWNER")
                || user.getRoles().get(0).getName().contains("ROLE_ADMIN")) {
            model.addAttribute("currentUser", userService.findByUsername(username));
            model.addAttribute("users", userService.allUsers());
            return "prescriptionForm.jsp";
        }

        return "prescriptionForm.jsp";
    }

    @GetMapping("/allrx")
    public String rxAll(Model model) {
        model.addAttribute("prescription", prescriptionService.allRx());
        return "redirect:/allpatients";
    }

}
