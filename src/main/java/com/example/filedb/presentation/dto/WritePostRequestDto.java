package com.example.filedb.presentation.dto;

import com.example.filedb.application.dto.WritePostCommand;
import lombok.Data;

@Data
public class WritePostRequestDto {
    private final String title;
    private final String content;

    public WritePostCommand toCommand() {
        return new WritePostCommand(title, content);
    }
}
