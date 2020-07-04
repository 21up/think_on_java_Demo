package com.wen.function_interface;

public class AddTest implements FunctionTest{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        AddTest addTest = new AddTest();
        int result = addTest.add(1, 2);
        System.out.println(result);
    }
}
