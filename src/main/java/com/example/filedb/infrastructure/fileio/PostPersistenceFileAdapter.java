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
        String path = directory + "/" + post.getTitle() + ".txt";
        File newFile = new File(path);
        createDirectoryIfNotExists(newFile);

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
        String content = "";

        try (BufferedReader br = new BufferedReader(new FileReader(newFile))) {
            while ((content += br.readLine()) != null) {}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(new Post(title, content));
    }

    private void validateDirectory(String directory) {
        File directoryFile = new File(directory);
        if (!directoryFile.exists()) {
            throw new DirectoryNotFoundException(directory);
        }
    }

    private static void createDirectoryIfNotExists(File newFile) {
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
    }
}
