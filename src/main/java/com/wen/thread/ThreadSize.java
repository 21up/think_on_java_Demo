package com.wen.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 21up on 2020/8/4
 */
public class ThreadSize {
    static class Dummy extends Thread{
        @Override
        public void run() {
           // new Nap(1);
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        int count=0;
        try {
            while (true){
                exec.execute(new Dummy());
                count++;
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName()+":"+count);
            e.printStackTrace();
            System.exit(0);
        }finally {
            exec.shutdown();
        }
    }
}
