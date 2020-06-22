package com.wen.exception;

public class MyException extends Exception {
    MyException(){};
    MyException(String msg){
        super(msg);
    }
}
