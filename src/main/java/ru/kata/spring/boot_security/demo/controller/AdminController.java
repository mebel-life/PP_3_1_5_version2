package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin")

public class AdminController {
    private final UserService userService;
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()

    public String allUsers(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("admin", user);
        model.addAttribute("newUser", new User());
        model.addAttribute("rolesAdd", userService.listRoles());

        return "/admin";
    }

//    @GetMapping("/create")
//    public String createUserForm(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        model.addAttribute("listRoles", userService.listRoles());
//        return "admin/create";
//    }
    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) throws Exception {
        userService.saveUser(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
//    @GetMapping("/update/{id}")
//    public String updateUserForm(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userService.getUser(id)); // добавил
//        model.addAttribute("listRoles", userService.listRoles());
//        return "admin/update";
//    }
    @PatchMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }
}


