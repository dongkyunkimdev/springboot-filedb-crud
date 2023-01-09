package com.example.filedb.presentation;

import com.example.filedb.application.ReadPostService;
import com.example.filedb.application.dto.ReadPostCommand;
import com.example.filedb.application.dto.ReadPostInfo;
import com.example.filedb.presentation.dto.ReadPostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReadPostController {
    private final ReadPostService readPostService;

    @GetMapping("/post/{title}")
    public ResponseEntity<ReadPostResponseDto> readPost(@PathVariable String title) {
        ReadPostInfo info = readPostService.command(new ReadPostCommand(title));

        return ResponseEntity.ok().body(new ReadPostResponseDto(info.getTitle(), info.getContent()));
    }
}
