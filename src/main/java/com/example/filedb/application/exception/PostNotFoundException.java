package com.example.filedb.application.exception;

import com.example.filedb.common.exception.BusinessException;

public class PostNotFoundException extends BusinessException {
    public PostNotFoundException(String message) {
        super(message);
    }
}
