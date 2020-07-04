package com.wen.function_interface;

import java.util.function.Supplier;

public class Demo08Supplier {
    private static String getString(Supplier<String> functions){
        return functions.get();
    }

    public static void main(String[] args) {
        String msgA="Hello";
        String msgB="World";
        System.out.println(getString(()->msgA+msgB));
    }
}
