package com.example.esap_vm2.controller;

import com.example.esap_vm2.model.Drive;
import com.example.esap_vm2.model.User;
import com.example.esap_vm2.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/drives")
public class DriveController {

    @Autowired
    private DriveService driveService;

    @Autowired
    private BikeService bikeService;

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("drive",new Drive());
        model.addAttribute("bikes", bikeService.getAll());
        model.addAttribute("users", userService.getAll());
        return "create_drive";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Drive drive, @RequestParam Long userId, @RequestParam Long bikeId){
        driveService.create(drive, userId, bikeId);
        return "redirect:/drives";
    }

    @GetMapping
    public String getAll(Model model){
        List<Drive> drives = driveService.getAll();
        model.addAttribute("drives", drives);
        return "show_drives";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        driveService.delete(id);
        return "redirect:/drives";
    }
}
