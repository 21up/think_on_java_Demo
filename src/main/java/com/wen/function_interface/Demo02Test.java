package com.wen.function_interface;

import java.util.function.Supplier;

public class Demo02Test {
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,2,8,10,9};
        int maxNum=getMax(()->{
            int max=arr[0];
            for (int i:arr){
                if (i>max){
                    max=i;
                }
            }
            return max;
        });
        System.out.println(maxNum);
    }
}
