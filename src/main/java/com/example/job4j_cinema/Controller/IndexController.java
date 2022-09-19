package com.example.job4j_cinema.Controller;

import com.example.job4j_cinema.Model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

public class IndexController {
    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
        }
        model.addAttribute("user", user);
        return "index";
    }
}
