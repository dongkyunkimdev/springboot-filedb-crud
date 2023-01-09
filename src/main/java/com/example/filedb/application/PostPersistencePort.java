package com.example.filedb.application;

import com.example.filedb.domain.Post;

public interface PostPersistencePort {
    Post save(Post toEntity);
}
