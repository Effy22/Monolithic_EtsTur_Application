package com.elif.exception;

import lombok.Getter;



@Getter
public class OtelException extends RuntimeException{

    private final ErrorType errorType;

    public OtelException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }
    public OtelException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}