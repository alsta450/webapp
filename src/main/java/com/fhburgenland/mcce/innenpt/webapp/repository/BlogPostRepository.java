package com.fhburgenland.mcce.innenpt.webapp.repository;

import com.fhburgenland.mcce.innenpt.webapp.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByCategory(String category);
    List<BlogPost> findByTagsContaining(String tag);
}
