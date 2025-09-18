package com.practice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticle(@PathVariable Long id) {
        return Optional.ofNullable(articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article nof found!")));
    }

    @PostMapping
    public Article create(@RequestBody Article article) {

    }


}
