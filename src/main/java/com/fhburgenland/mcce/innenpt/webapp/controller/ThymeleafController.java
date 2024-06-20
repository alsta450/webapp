package com.fhburgenland.mcce.innenpt.webapp.controller;

import com.fhburgenland.mcce.innenpt.webapp.model.BlogPost;
import com.fhburgenland.mcce.innenpt.webapp.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThymeleafController {

    @Autowired
    private BlogPostService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", service.getAllPosts());
        return "index";
    }

    @GetMapping("/post/{id}")
    public String post(@PathVariable Long id, Model model) {
        BlogPost post = service.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/post/new")
    public String newPost(Model model) {
        model.addAttribute("post", new BlogPost());
        return "form";
    }

    @GetMapping("/post/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        BlogPost post = service.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        model.addAttribute("post", post);
        return "form";
    }

    @PostMapping("/post")
    public String savePost(@ModelAttribute BlogPost post) {
        service.createOrUpdatePost(post);
        return "redirect:/";
    }

    @DeleteMapping("/post/{id}")
    @ResponseBody
    public void deletePost(@PathVariable Long id) {
        service.deletePost(id);
    }
}