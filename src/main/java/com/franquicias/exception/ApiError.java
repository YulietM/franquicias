package com.franquicias.exception;
import lombok.Data;
import java.time.LocalDateTime;

@Data

public class ApiError {

    private String error;
    private String message;
    private  Integer status;
    private Object data;
    private LocalDateTime timesTime;

    public ApiError(){
        this.timesTime = LocalDateTime.now();
    }

    public ApiError(String error, String message, Integer status, Object data) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.data = data;
    }

}
