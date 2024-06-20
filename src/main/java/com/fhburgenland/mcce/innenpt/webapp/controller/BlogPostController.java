package com.fhburgenland.mcce.innenpt.webapp.controller;

import com.fhburgenland.mcce.innenpt.webapp.model.BlogPost;
import com.fhburgenland.mcce.innenpt.webapp.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class BlogPostController {

    @Autowired
    private BlogPostService service;

    @GetMapping
    public List<BlogPost> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<BlogPost> getPostById(@PathVariable Long id) {
        return service.getPostById(id);
    }

    @PostMapping
    public BlogPost createPost(@ModelAttribute BlogPost post) {
        return service.createOrUpdatePost(post);
    }

    @PutMapping("/{id}")
    public BlogPost updatePost(@PathVariable Long id, @ModelAttribute BlogPost post) {
        post.setId(id);
        return service.createOrUpdatePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        service.deletePost(id);
    }

    @GetMapping("/category/{category}")
    public List<BlogPost> getPostsByCategory(@PathVariable String category) {
        return service.getPostsByCategory(category);
    }

    @GetMapping("/tag/{tag}")
    public List<BlogPost> getPostsByTag(@PathVariable String tag) {
        return service.getPostsByTag(tag);
    }
}