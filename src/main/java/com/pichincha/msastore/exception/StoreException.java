package com.pichincha.msastore.exception;

import lombok.Getter;

public class StoreException extends RuntimeException {

    @Getter
    private final String code;

    public StoreException(String code) {
        this.code = code;
    }

    public StoreException(String code, String message) {
        super(message);
        this.code = code;
    }
}
