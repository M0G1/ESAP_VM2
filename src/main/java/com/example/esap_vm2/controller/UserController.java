package com.example.esap_vm2.controller;

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
    public String getCreatePage(Model model){
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user){
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping
    public String getAll(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users",users);
        return "show_users";
    }

    @GetMapping("/{id}/update")
    public String getUpdatePage(@PathVariable("id") Long userId, @ModelAttribute User user){
        userService.update(userId,user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/users";
    }
}
