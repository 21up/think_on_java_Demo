package com.wen.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send_Direct {
    private final static String EXCHANGE_NAME="direct_exchange_test";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connction = ConnectionUtil.getConnction();
        Channel channel = connction.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        String message="商品新增了，id=1001";
        channel.basicPublish(EXCHANGE_NAME,"insert",null,message.getBytes());
        System.out.println("[商品服务：]Send "+message);
        channel.close();
        connction.close();
    }
}
