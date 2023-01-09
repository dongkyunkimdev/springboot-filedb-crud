package com.example.filedb.infrastructure.fileio;

import com.example.filedb.application.PostPersistencePort;
import com.example.filedb.domain.Post;
import com.example.filedb.infrastructure.fileio.exception.DirectoryNotFoundException;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Optional;

@Component
public class PostPersistenceFileAdapter implements PostPersistencePort {
    @Override
    public Post save(Post post) {
        String directory = "./filedb/post";
        createDirectoryIfNotExists(directory);

        String path = directory + "/" + post.getTitle() + ".txt";
        File newFile = new File(path);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {
            bw.write(post.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return post;
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        String directory = "./filedb/post";
        validateDirectory(directory);

        String path = directory + "/" + title + ".txt";
        File newFile = new File(path);
        String line = "";
        String content = "";

        try (BufferedReader br = new BufferedReader(new FileReader(newFile))) {
            while ((line = br.readLine()) != null) {
                content += line;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(new Post(title, content));
    }

    @Override
    public boolean isExistsPostByTitle(String title) {
        String directory = "./filedb/post";
        String path = directory + "/" + title + ".txt";
        File savedFile = new File(path);

        return savedFile.exists();
    }

    private void validateDirectory(String directory) {
        File directoryFile = new File(directory);
        if (!directoryFile.exists()) {
            throw new DirectoryNotFoundException(directory);
        }
    }

    private static void createDirectoryIfNotExists(String directory) {
        File directoryFile = new File(directory);
        if (!directoryFile.exists()) {
            directoryFile.mkdirs();
        }
    }
}
