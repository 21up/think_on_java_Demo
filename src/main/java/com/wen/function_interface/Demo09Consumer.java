package com.wen.function_interface;

import java.util.function.Consumer;

public class Demo09Consumer {
    public static void main(String[] args) {
         consumerString(s-> System.out.println(s));
    }
    private static void consumerString(Consumer<String> function){
        function.accept("Hello");
    }
}
