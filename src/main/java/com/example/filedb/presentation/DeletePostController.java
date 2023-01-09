package com.example.filedb.presentation;

import com.example.filedb.application.DeletePostService;
import com.example.filedb.application.dto.DeletePostCommand;
import com.example.filedb.application.dto.DeletePostInfo;
import com.example.filedb.presentation.dto.DeletePostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeletePostController {
    private final DeletePostService deletePostService;

    @DeleteMapping("/post/{title}")
    public ResponseEntity<DeletePostResponseDto> deletePost(@PathVariable String title) {
        DeletePostInfo info = deletePostService.command(new DeletePostCommand(title));

        return ResponseEntity.ok().body(new DeletePostResponseDto(info.getTitle()));
    }
}
