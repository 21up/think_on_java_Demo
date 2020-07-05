package com.wen.stream;

import java.util.ArrayList;
import java.util.List;

public class Demo04GetStream {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.stream().forEach(System.out::println);
    }
}
