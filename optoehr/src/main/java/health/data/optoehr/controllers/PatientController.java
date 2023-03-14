package health.data.optoehr.controllers;

import javax.validation.Valid;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import health.data.optoehr.models.Patient;
import health.data.optoehr.models.User;
import health.data.optoehr.services.PatientService;
import health.data.optoehr.services.UserService;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;

    @GetMapping("/patient/forms")
    public String newPatient(@ModelAttribute("patient") Patient patient, Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("user", user);
        model.addAttribute("users", userService.allUsers());
        return "patientForm.jsp";
    }

    @PostMapping("/patients")
    public String createPatients(@Valid @ModelAttribute("patient") Patient patient) {
        patientService.createPatient(patient);

        return "redirect:/";
    }

    @GetMapping("/allpatients")
    public String getAllPatients(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("patient", patientService.allPatients());
        return "allPatients.jsp";
    }

    @GetMapping("/search")
    public String patientAll(Model model) {
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("patients", patientService.allPatients());
        return "searchPatient.jsp";
    }

    @PostMapping("/searchp")
    public String searchPatients(@RequestParam(value = "firstNameSearch") String firstNameSearch, Model model) {
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("patients", patientService.allPatients());
        model.addAttribute("searchResults", patientService.findByFirstName(firstNameSearch));
        return "searchPatient.jsp";
    }

}
