package com.zm.exception;

/**
 * Created by zouming on 17-3-10.
 */
public class PasswordInvalidException extends RuntimeException {

    public PasswordInvalidException(){
        super();
    }

    public PasswordInvalidException(String message){
        super(message);
    }
}
