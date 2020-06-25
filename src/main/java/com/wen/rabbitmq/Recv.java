package com.wen.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv {
    private final static String QUEUE_NAME="simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connction = ConnectionUtil.getConnction();
        Channel channel = connction.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
               String msg = new String(body);
                System.out.println("[x] received:"+msg+"!");
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
