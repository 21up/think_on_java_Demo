package com.wen.function_interface;

import org.springframework.aop.scope.ScopedProxyUtils;

import java.util.function.Predicate;

public class Demo16PredicateAnd {
    public static void main(String[] args) {
        method(s->s.contains("H"),s->s.contains("W"));
    }
    public static void method(Predicate<String> one,Predicate<String> two){
        boolean hello_world = one.and(two).test("Hello World");
        System.out.println("字符串符合要求吗 "+hello_world);
    }
}
