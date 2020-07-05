package com.wen.stream;

import java.util.stream.Stream;

public class Demo12StreamForEach {
    public static void main(String[] args) {
        Stream<String> stream=Stream.of("张无忌","张三丰","周芷若哦");
        stream.forEach(name-> System.out.println(name));
    }
}
