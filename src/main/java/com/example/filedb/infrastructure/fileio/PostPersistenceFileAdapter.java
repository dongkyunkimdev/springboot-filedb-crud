package com.example.filedb.infrastructure.fileio;

import com.example.filedb.application.PostPersistencePort;
import com.example.filedb.domain.Post;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class PostPersistenceFileAdapter implements PostPersistencePort {
    @Override
    public Post save(Post post) {
        String path = "./" + post.getTitle() + ".txt";
        File newFile = new File(path);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {
            bw.write(post.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return post;
    }
}
