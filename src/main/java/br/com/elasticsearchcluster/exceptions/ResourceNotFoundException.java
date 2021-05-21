package br.com.elasticsearchcluster.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException() {
        this("Resource not found");
    }

    public ResourceNotFoundException(String msg) {
        super(msg, HttpStatus.NOT_FOUND);
    }
}
