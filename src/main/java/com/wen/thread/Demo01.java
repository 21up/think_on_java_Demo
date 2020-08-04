package com.wen.thread;

/**
 * Created by 21up on 2020/8/4
 */
public class Demo01 {
    public static void main(String[] args) {
        Mythread mt = new Mythread("新的线程");
        mt.start();
        for (int i=0;i<10;i++){
            System.out.println("main线程！"+i);
        }
    }
}
