package com.wen.function_interface;

        import java.util.function.Function;

public class DemoFunction {
    public static void main(String[] args) {
        String str = "赵丽颖,20";
        method(s->Integer.parseInt(s.split(",")[1]),s->s=s+100,str);
    }
    public static void method(Function<String,Integer> one,
                              Function<Integer,Integer> two,String str){
        Integer apply = one.andThen(two).apply(str);
        System.out.println(apply);
    }
}
