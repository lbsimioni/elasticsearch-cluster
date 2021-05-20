package br.com.elasticsearchcluster.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public abstract class BaseException extends RuntimeException {
    private final HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;

    protected BaseException(HttpStatus status) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    protected BaseException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
