package com.practice.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(name="title", nullable = false, length = 80)
    private String title;

    @NotEmpty
    @NotNull
    @Column(name = "content", nullable = false, length = 350)
    private String content;
}

