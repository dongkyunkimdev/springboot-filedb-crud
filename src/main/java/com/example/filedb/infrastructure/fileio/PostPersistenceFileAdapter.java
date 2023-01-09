package com.example.filedb.infrastructure.fileio;

import com.example.filedb.application.PostPersistencePort;
import com.example.filedb.domain.Post;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class PostPersistenceFileAdapter implements PostPersistencePort {
    @Override
    public Post save(Post post) {
        String path = "/filedb/post/" + post.getTitle() + ".txt";
        File newFile = new File(path);

        try(FileWriter fw = new FileWriter(newFile)) {
            fw.write(post.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return post;
    }
}
