package com.wen.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv2_Fanout {
    private final static String EXCHANGE_NAME="fanout_exchange_test";
    private final static String QUEUE_NAME="fanout_queue_2";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connction = ConnectionUtil.getConnction();
        Channel channel = connction.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[消费者2] received:"+msg+" !");
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }

}
