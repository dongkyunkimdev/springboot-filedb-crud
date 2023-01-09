package com.example.filedb.infrastructure.fileio;

import com.example.filedb.application.PostPersistencePort;
import com.example.filedb.domain.Post;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class PostPersistenceFileAdapter implements PostPersistencePort {
    @Override
    public Post save(Post post) {
        LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
        String path = "./filedb/post/" + now + "/" + post.getTitle() + ".txt";
        File newFile = new File(path);
        createDirectory(newFile);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {
            bw.write(post.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return post;
    }

    private static void createDirectory(File newFile) {
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
    }
}
