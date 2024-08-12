package com.franquicias.exception;

public class FranquiciaNoExiste extends RuntimeException {
    public FranquiciaNoExiste(String error) {
        super(error);
    }
}
