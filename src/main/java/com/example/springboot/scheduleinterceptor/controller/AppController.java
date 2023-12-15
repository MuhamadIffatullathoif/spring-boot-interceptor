package com.example.springboot.scheduleinterceptor.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Value("${config.schedule.opening}")
    private Integer opening;
    @Value("${config.schedule.closing}")
    private Integer closing;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Welcome to customer service hours");
        return "index";
    }

    @GetMapping("/closed")
    public String closed(Model model) {
        StringBuilder message = new StringBuilder("Closed. Please visit us from ");
        message.append(opening);
        message.append(" and the ");
        message.append(closing);
        message.append(" hrs. Thank you.");
        model.addAttribute("title", "Out of business hours");
        model.addAttribute("message", message);
        return "closed";
    }
}
