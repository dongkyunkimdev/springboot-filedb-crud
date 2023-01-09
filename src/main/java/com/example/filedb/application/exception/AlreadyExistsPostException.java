package com.example.filedb.application.exception;

import com.example.filedb.common.exception.BusinessException;

public class AlreadyExistsPostException extends BusinessException {
    public AlreadyExistsPostException(String message) {
        super(message);
    }
}
