package com.example.filedb.application;

import com.example.filedb.application.dto.ReadPostCommand;
import com.example.filedb.application.dto.ReadPostInfo;
import com.example.filedb.application.exception.PostNotFoundException;
import com.example.filedb.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadPostService {
    private final PostPersistencePort postPersistencePort;

    public ReadPostInfo command(ReadPostCommand command) {
//        Optional<Post> savedPost = postPersistencePort.findByTitle(command.getTitle());
        Post savedPost = postPersistencePort.findByTitle(command.getTitle())
                .orElseThrow(() -> new PostNotFoundException(command.getTitle()));

        return new ReadPostInfo(savedPost.getTitle(), savedPost.getContent());
    }
}
