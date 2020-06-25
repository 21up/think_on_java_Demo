package com.wen.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private final static String QUEUE_NAME="simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connction = ConnectionUtil.getConnction();
        Channel channel = connction.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "Hello World";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("[x] Send"+ message+"");
        channel.close();
        connction.close();
    }
}
