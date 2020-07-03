package com.wen.function_interface;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

public class Demo03LoggerDalay {
    public static void main(String[] args) {
        String messageA="Hello";
        String messageB="World";
        String messageC="Java";
        log(2,()->{
            System.out.println("Lambda执行");
            return messageA+messageB+messageC;
        });
    }
    public static void log(int level,MessageBuilder messageBuilder){
        if (level==1){
            System.out.println(messageBuilder.builderMessage());
        }
    }
}
