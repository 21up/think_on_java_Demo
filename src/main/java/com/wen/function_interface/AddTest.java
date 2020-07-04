package com.wen.function_interface;

public class AddTest{
    private static int add(FunctionTest test){
        //此处为方法调用，必须出入实参
        return test.add(5,7);
    }

    public static void main(String[] args) {
        AddTest addTest = new AddTest();
        int result = addTest.add((a,b)->a+b);
        System.out.println(result);
    }
}
