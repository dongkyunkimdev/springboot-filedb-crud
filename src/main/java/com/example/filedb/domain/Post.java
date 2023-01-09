package com.example.filedb.domain;

import lombok.Getter;

@Getter
public class Post {
    private String title;
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
