package com.wen.function_interface;

import javax.naming.Name;
import java.util.function.Consumer;

public class DemoConsumer {

    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        printInSomeway(s-> System.out.print("姓名："+s.split(",")[0]),
                s-> System.out.println(",性别："+s.split(",")[1]),array);
    }
    public static void printInSomeway(Consumer<String> name, Consumer<String> sex, String[] array) {
        for (int i = 0; i < 3; i++) {
            name.andThen(sex).accept(array[i]);
        }
    }
}
