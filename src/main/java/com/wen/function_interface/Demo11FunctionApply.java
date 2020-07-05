package com.wen.function_interface;

import java.util.function.Function;

public class Demo11FunctionApply {
    public static void main(String[] args) {
        method(s->Integer.parseInt(s));
    }
    public static void method(Function<String,Integer> function){
        Integer num = function.apply("10");
        System.out.println(num+20);
    }
}
