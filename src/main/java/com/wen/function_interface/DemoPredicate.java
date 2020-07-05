package com.wen.function_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DemoPredicate {
    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        method(array, s -> s.split(",")[0].length() == 4, s -> s.split(",")[1].equals("女"));
    }

    public static void method(String[] array, Predicate<String> one, Predicate<String> two) {
        List<String> list = new ArrayList<>();
        for (String s : array) {
            boolean valid = one.and(two).test(s);
            if (valid) {
                list.add(s);
            }
        }
        System.out.println(list.toString());
    }
}
