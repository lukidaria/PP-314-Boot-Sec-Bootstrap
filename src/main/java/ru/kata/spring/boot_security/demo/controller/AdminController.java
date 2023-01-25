package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {

    final private UserService userService;

    @Autowired
    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/admin")
    public String showAllUsers(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("getUser", user);
        model.addAttribute("user", userService.allUsers());
        model.addAttribute("allRoles", userService.allRoles());
        return "admin";
    }

    @GetMapping("/admin/logout")
    public String logout(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            request.getSession().invalidate();
        }
        return "logout";
    }

    @GetMapping(value = "/admin/add")
    public String createUser(Model model, Principal principal) {
        User userToEntered = userService.findByUsername(principal.getName());
        model.addAttribute("userGet", userToEntered);
        model.addAttribute("user", new User());
        model.addAttribute("roles", userService.allRoles());
        return "users_info";
    }

    @PostMapping("/admin/saveUser")
    public String saveEmployee(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/update")
    public String updateUser(Long id, User user) {
        userService.updateUser(id, user);
        return "redirect:/admin";
    }
}
