package com.trxjster.springbootexample.exceptions;

public class LoginFailureException extends Exception {

    public LoginFailureException(String message){
        super(message);
    }
}
