package br.com.elasticsearchcluster.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
