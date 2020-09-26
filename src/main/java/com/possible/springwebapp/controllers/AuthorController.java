package com.possible.springwebapp.controllers;

import com.possible.springwebapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}
