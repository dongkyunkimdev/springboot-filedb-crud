package com.example.filedb.presentation;

import com.example.filedb.application.WritePostService;
import com.example.filedb.application.dto.WritePostInfo;
import com.example.filedb.presentation.dto.WritePostRequestDto;
import com.example.filedb.presentation.dto.WritePostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WritePostController {
    private final WritePostService writePostService;

    @PostMapping("/post/write")
    public ResponseEntity<WritePostResponseDto> writePost(@RequestBody WritePostRequestDto dto) {
        WritePostInfo info = writePostService.command(dto.toCommand());

        return new ResponseEntity(new WritePostResponseDto(info.getTitle(), info.getContent()), HttpStatus.CREATED);
    }
}
