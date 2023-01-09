package com.example.filedb.application.dto;

import com.example.filedb.domain.Post;
import lombok.Data;

@Data
public class WritePostCommand {
    private final String title;
    private final String content;

    public Post toEntity() {
        return new Post(title, content);
    }
}
