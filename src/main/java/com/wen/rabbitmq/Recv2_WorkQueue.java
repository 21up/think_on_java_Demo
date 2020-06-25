package com.wen.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv2_WorkQueue {
    private final static String QUEUE_NAME="test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connction = ConnectionUtil.getConnction();
        final Channel channel = connction.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //设置每个消费者同时只能处理一条消息
        channel.basicQos(1);
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
               String msg = new String(body);
                System.out.println("[Consumer2] received:"+msg+"!");
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,false,consumer);
    }
}
