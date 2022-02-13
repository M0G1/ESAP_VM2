package com.example.esap_vm2.controller;

import com.example.esap_vm2.model.Drive;
import com.example.esap_vm2.model.User;
import com.example.esap_vm2.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("user", new User());
        return "create_user"; // должно совпадать с именем файла view/____.html. == view/create_user.html
    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping
    public String getAll(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "show_users";
    }

    @GetMapping("/{id}/update")
    public String getUpdatePage(@PathVariable("id") Long userId, Model model) {
        model.addAttribute("user", userService.get(userId));
        return "update_user";
    }

    @PatchMapping("/{id}/update")
    public String update(@PathVariable("id") Long userId,@ModelAttribute User user) {
        userService.update(userId, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/drives")
    public String getDrives(@PathVariable Long id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
//        model.addAttribute("name", user.getName());
        System.out.println("\nThe page require drives of user\n");
        return "show_user_drives";
    }
}
