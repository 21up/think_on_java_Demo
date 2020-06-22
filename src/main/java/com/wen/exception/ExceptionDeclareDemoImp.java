package com.wen.exception;

public class ExceptionDeclareDemoImp implements ExceptionDeclareDemo {
    public void f() throws NullPointerException {
        try {
            throw  new NullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void g() throws ArithmeticException {
        try {
            throw  new NullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
