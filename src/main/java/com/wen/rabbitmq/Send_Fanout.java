package com.wen.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send_Fanout {
    private final static String EXCHANGE_NAME="fanout_exchange_test";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connction = ConnectionUtil.getConnction();
        Channel channel = connction.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        String msg = "Hello everyone";
        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());;
        System.out.println("[生产者] Send"+msg);
        channel.close();
        connction.close();
    }
}
