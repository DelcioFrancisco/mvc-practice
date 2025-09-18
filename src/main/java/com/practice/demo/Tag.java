package com.practice.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tag {

    @Id
    @ManyToMany
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @Id
    private String tag;
}
