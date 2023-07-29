package com.example.shoppingverse.Exception;

import org.aspectj.weaver.tools.ISupportsMessageContext;

public class EmptyCardException extends RuntimeException{
    public EmptyCardException (String message){
        super(message);
    }
}
