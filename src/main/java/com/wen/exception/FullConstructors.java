package com.wen.exception;

public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throw SimpleException from f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("Throw SimpleException from g()");
        throw new MyException("Originated in g()");
    }
    public static void main(String [] args){
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
