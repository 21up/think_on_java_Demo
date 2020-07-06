package com.wen.stream;

import java.util.stream.Stream;

public class Demo12StreamConcat {
    public static void main(String[] args) {
        Stream<String> streamA = Stream.of("张五金");
        Stream<String> streamB = Stream.of("菲菲");
        Stream<String> concat = Stream.concat(streamA, streamB);
        concat.forEach(System.out::println);
    }
}
