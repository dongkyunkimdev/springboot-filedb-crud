package com.example.filedb.infrastructure.fileio.exception;

import com.example.filedb.common.exception.BusinessException;

public class PostDeleteFailedException extends BusinessException {
    public PostDeleteFailedException(String message) {
        super(message);
    }
}
