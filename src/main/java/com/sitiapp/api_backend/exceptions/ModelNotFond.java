package com.sitiapp.api_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFond extends RuntimeException{
    public ModelNotFond(String message) {
        super(message);
    }
}
