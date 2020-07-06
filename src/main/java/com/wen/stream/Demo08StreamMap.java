package com.wen.stream;


import java.util.stream.Stream;

public class Demo08StreamMap {
    public static void main(String[] args) {
        Stream<String> original=Stream.of("10","12","18");
        Stream<String> skip = original.skip(2);
        System.out.println(skip.count());
    }
}
