package com.example.filedb.application;

import com.example.filedb.domain.Post;

import java.util.Optional;

public interface PostPersistencePort {
    Post save(Post toEntity);

    Optional<Post> findByTitle(String title);
}
