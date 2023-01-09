package com.example.filedb.application;

import com.example.filedb.application.dto.WritePostCommand;
import com.example.filedb.application.exception.AlreadyExistsPostException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.openMocks;

class WritePostServiceTest {

    @Mock
    private PostPersistencePort mockPostPersistencePort;

    @InjectMocks
    private WritePostService writePostService;

    @BeforeEach
    void setUp() {
        openMocks(this);
        writePostService = new WritePostService(mockPostPersistencePort);
    }

    @Test
    void post_작성_실패_title이_중복됨() {
        // given
        WritePostCommand duplicatedTitleCommand = new WritePostCommand("duplicatedTitle", "content");
        given(mockPostPersistencePort.isExistsPostByTitle(duplicatedTitleCommand.getTitle())).willReturn(true);

        // when && then
        assertThrows(AlreadyExistsPostException.class, () -> {
            writePostService.command(duplicatedTitleCommand);
        });
    }
}