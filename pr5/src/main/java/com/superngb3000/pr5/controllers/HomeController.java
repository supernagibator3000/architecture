package com.superngb3000.pr5.controllers;

import com.superngb3000.pr5.models.Item;
import com.superngb3000.pr5.models.User;
import com.superngb3000.pr5.services.ItemService;
import com.superngb3000.pr5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String home(Model models){
        models.addAttribute("users", userService.findAll());
        models.addAttribute("items", itemService.findAll());
        return "home";
    }

    @PostMapping("/users")
    public String createUser(@RequestParam(defaultValue = "username") String username,
                             @RequestParam(defaultValue = "password") String password,
                             @RequestParam(defaultValue = "email@email.email") String email){
        userService.saveUser(new User(username, password, email));
        return "redirect:/";
    }

    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/items")
    public String createItem(@RequestParam(defaultValue = "name") String name,
                             @RequestParam(defaultValue = "0.0") Double price,
                             @RequestParam(defaultValue = "description") String description){
        itemService.saveItem(new Item(name, price, description));
        return "redirect:/";
    }

    @PostMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return "redirect:/";
    }
}
