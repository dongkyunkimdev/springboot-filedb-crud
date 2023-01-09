package com.example.filedb.application;

import com.example.filedb.application.dto.DeletePostCommand;
import com.example.filedb.application.dto.DeletePostInfo;
import com.example.filedb.application.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostService {
    private final PostPersistencePort postPersistencePort;

    public DeletePostInfo command(DeletePostCommand command) {
        if (!postPersistencePort.isExistsPostByTitle(command.getTitle())) {
            throw new PostNotFoundException(command.getTitle());
        }

        String deletedTitle = postPersistencePort.delete(command.getTitle());
        return new DeletePostInfo(deletedTitle);
    }
}
