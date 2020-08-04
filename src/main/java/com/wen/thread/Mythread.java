package com.wen.thread;

/**
 * Created by 21up on 2020/8/4
 */
public class Mythread extends Thread {
    public Mythread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(getName()+"正在执行!"+i);
        }
    }
}
