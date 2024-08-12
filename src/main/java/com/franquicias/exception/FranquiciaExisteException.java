package com.franquicias.exception;

public class FranquiciaExisteException extends RuntimeException {
    public FranquiciaExisteException(String error) {
        super(error);
    }
}
