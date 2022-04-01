package com.pichincha.msastore.exception;

public class NotFoundStoreException extends StoreException {

    public NotFoundStoreException() {
        super("ERROR-404", "Store not found");
    }
}
