package com.wen.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.IllegalCharsetNameException;
import java.util.concurrent.TimeoutException;

public class Send_WorkQueue {
    private final static String QUEUE_NAME="test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connction = ConnectionUtil.getConnction();
        Channel channel = connction.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        for (int i=0;i<50;i++){
            String message="task.."+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("[x] Sent "+message);
            Thread.sleep(i*2);
        }
        channel.close();
        connction.close();
    }
}
