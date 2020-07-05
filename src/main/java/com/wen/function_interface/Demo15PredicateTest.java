package com.wen.function_interface;

import java.util.function.Predicate;

public class Demo15PredicateTest {
    public static void main(String[] args) {
        method(s->s.length()>5);
    }
    public static void method(Predicate<String> predicate){
        boolean helloWorld = predicate.test("HelloWorld");
        System.out.println("字符串很长吗"+helloWorld);
    }
}
