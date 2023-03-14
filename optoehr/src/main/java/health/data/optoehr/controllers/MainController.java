package health.data.optoehr.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import health.data.optoehr.models.User;
import health.data.optoehr.services.UserService;
import health.data.optoehr.validators.UserValidator;

@Controller
public class MainController {

    private UserService userService;

    private UserValidator userValidator;

    public MainController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registerPage.jsp";
    }

    @PostMapping("/registration")
    public String registration(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Model model,
            HttpSession session,
            HttpServletRequest request) {
        userValidator.validate(user, result);
        String password = user.getPassword();
        if (result.hasErrors()) {
            return "registerPage.jsp";
        }
        if (userService.allUsers().size() == 0) {
            userService.newUser(user, "ROLE_OWNER");
        } else {
            userService.newUser(user, "ROLE_USER");
        }
        authWithHttpServletRequest(request, user.getUsername(), password);
        return "redirect:/";
    }

    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            System.out.println("Error while login: " + e);
        }
    }

    @RequestMapping("/login")
    public String login(
            @ModelAttribute("user") User user,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }

    @PostMapping("/login")
    public String loginPage(
            @Valid @ModelAttribute("user") User user,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "redirect:/";
    }

    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("users", userService.allUsers());
        return "adminPage.jsp";
    }

    @RequestMapping("/admin/{id}")
    public String makeAdmin(@PathVariable("id") Long id, Model model) {

        User user = userService.findById(id);
        userService.upgradeUser(user);

        model.addAttribute("users", userService.allUsers());

        return "redirect:/admin";
    }

    @RequestMapping(value = { "/", "/home" })
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        if (user != null) {
            userService.updateUser(user);
            if (user.getRoles().get(0).getName().contains("ROLE_OWNER")
                    || user.getRoles().get(0).getName().contains("ROLE_ADMIN")
                    || user.getRoles().get(0).getName().contains("ROLE_USER")) {
                model.addAttribute("currentUser", userService.findByUsername(username));
                model.addAttribute("users", userService.allUsers());
                return "adminPage.jsp";
            }
        }
        return "homePage.jsp";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, HttpSession session, Model model) {
        User user = userService.findById(id);
        userService.deleteUser(user);

        model.addAttribute("users", userService.allUsers());

        return "redirect:/admin";
    }
}
