package com.example.filedb.presentation.dto;

import com.example.filedb.application.dto.WritePostCommand;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WritePostRequestDto {
    private String title;
    private String content;

    public WritePostCommand toCommand() {
        return new WritePostCommand(title, content);
    }
}
