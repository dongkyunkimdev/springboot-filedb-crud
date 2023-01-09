package com.example.filedb.application;

import com.example.filedb.application.dto.WritePostCommand;
import com.example.filedb.application.dto.WritePostInfo;
import com.example.filedb.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WritePostService {
    private final PostPersistencePort postPersistencePort;

    public WritePostInfo command(WritePostCommand command) {
        Post savedPost = postPersistencePort.save(command.toEntity());

        return new WritePostInfo(savedPost.getTitle(), savedPost.getContent());
    }
}
