package com.practice.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ArticleDTO {
    private String title;
    private String context;
    private List<String> tags;
}
