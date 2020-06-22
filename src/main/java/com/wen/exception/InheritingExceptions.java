package com.wen.exception;

public class InheritingExceptions extends Exception {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
}
