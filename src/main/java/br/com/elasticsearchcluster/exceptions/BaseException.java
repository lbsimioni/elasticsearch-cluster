package br.com.elasticsearchcluster.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class BaseException extends RuntimeException {
    protected BaseException(String msg) {
        super(msg);
    }
}
