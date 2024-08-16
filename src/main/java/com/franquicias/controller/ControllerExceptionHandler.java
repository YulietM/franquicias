package com.franquicias.controller;
import com.franquicias.exception.ApiError;
import com.franquicias.exception.FranquiciaExisteException;
import com.franquicias.exception.FranquiciaNoExiste;
import com.franquicias.exception.ProductoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(FranquiciaNoExiste.class)
    @ResponseBody
    public ResponseEntity<ApiError> errorFranquiciaNoException(Exception e){
        ApiError apiError = new ApiError(
                "la franquicia no existe",
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                null
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FranquiciaExisteException.class)
    @ResponseBody
    public ResponseEntity<ApiError> errorFranquiciaException(Exception e){
        ApiError apiError = new ApiError(
                "la franquicia ya existe",
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                null
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductoException.class)
    @ResponseBody
    public ResponseEntity<ApiError> errorProductoExceptions(Exception e) {
        ApiError apiError = new ApiError(
                "producto ya existe",
                e.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                null
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    /* @ExceptionHandler(ProductoException.class)
    @ResponseBody
    public ResponseEntity<ApiError> errorStock(Exception e) {
        ApiError apiError = new ApiError(
                "error calculando el stock",
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                null
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    } */
}
