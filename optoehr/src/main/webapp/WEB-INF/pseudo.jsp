<!-- @RequestMapping("/registration")
public String registration(
        @Valid @ModelAttribute("user") User user,
        BindingResult result,
        Model model,
        HttpSession session,
        HttpServletRequest request) {
    userValidator.validate(user, result);
    String password = user.getPassword();
    if (result.hasErrors()) {
        return "loginPage.jsp";
    }
    if (userService.allUsers().size() == 0) {
        userService.newUser(user, "ROLE_OWNER");
    } else {
        userService.newUser(user, "ROLE_USER");
    }
    authWithHttpServletRequest(request, user.getUsername(), password);
    return "redirect:/";
} -->

<!-- @RequestMapping("/login")
public String login(
        @ModelAttribute("user") User user,
        @RequestParam(value = "error", required = false) String error,
        @RequestParam(value = "logout", required = false) String logout, Model model) {
    if (error != null) {
        model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
    }
    if (logout != null) {
        model.addAttribute("logoutMessage", "Logout Successful!");
    }
    return "loginPage.jsp";
} -->

<!-- @GetMapping("/prescription")
public String rxForm(Principal principal, Model model) {
    String username = principal.getName();
    User user = userService.findByUsername(username);
    model.addAttribute("currentUser", userService.findByUsername(username));
    model.addAttribute("user", user);
    model.addAttribute("patient", patientService.allPatients());
    return "prescriptionForm.jsp";
} -->
