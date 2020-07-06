package com.wen.stream;

import java.util.stream.Stream;

public class Demo07StreamFilter {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("张三", "张三分", "周芷若");
        Stream<String> stream = original.filter(s -> s.startsWith("张"));
        stream.forEach(System.out::println);
    }
}
