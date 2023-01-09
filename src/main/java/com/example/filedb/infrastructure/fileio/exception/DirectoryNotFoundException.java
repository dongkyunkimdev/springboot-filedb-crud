package com.example.filedb.infrastructure.fileio.exception;

import com.example.filedb.common.exception.BusinessException;

public class DirectoryNotFoundException extends BusinessException {
    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
