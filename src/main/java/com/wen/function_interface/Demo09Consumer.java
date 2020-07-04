package com.wen.function_interface;

import java.util.function.Consumer;

public class Demo09Consumer {
    public static void main(String[] args) {

         consumerString((String s)-> System.out.println(s),"test");
    }
    private static void consumerString(Consumer<String> function,String s){
        function.accept(s+"10");
    }
}
