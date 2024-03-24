package com.example.construire.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HtmlController {
    private static final Logger logger = LoggerFactory.getLogger(HtmlController.class);

    public void myMethod() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", " Coelho Cedina!");
        return "hello-template"; // Correspond au nom du fichier HTML sans l'extension
    }
}
