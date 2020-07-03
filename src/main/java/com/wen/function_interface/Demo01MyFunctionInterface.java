package com.wen.function_interface;

public class Demo01MyFunctionInterface {
    public static void main(String[] args) {
        doSomething(()->System.out.println("lamda执行了"));
    }
    public static void doSomething(MyFunctionInterface myFunctionInterface){
        myFunctionInterface.myMethod();
    }
}
