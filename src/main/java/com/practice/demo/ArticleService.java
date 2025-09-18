package com.practice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Value("${article.blacklist}")
    private String blacklistRaw;

    ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public Long create (Article articleDTO) {
        String[] blacklist = blacklistRaw.split(",");

        for (String banned : blacklist) {
            if (articleDTO.getContent() != null && articleDTO.getContent().contains(banned)) {
                throw new RuntimeException("Article contains forbidden words" );
            }
        }

        Article saved = articleRepository.save(articleDTO);

        return saved.getId();
    }

    public Article update (Article article) {
        String[] blacklist = blacklistRaw.split(",");

        Optional<Article> articleResult = Optional.ofNullable(articleRepository.findById(article.getId())
                .orElseThrow(() -> new RuntimeException("Article not found")));

        for(String banned: blacklist) {
            if(article.getContent() != null && article.getContent().contains(banned)) {
                throw new RuntimeException("Article content contains forbidden words");
            }
        }

        return articleRepository.save(article);
    }

    public Article delete (Article article) {
        Article existingArticle = articleRepository.findById(article.getId())
                .orElseThrow(() -> new RuntimeException("Article not found"));

        articleRepository.delete(existingArticle);

        return existingArticle;
    }
}
