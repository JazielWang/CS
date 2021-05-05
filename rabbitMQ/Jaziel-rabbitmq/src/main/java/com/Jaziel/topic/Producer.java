package com.Jaziel.topic;

import com.Jaziel.utils.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 王杰
 * @date 2021/5/5 10:30
 */
public class Producer {
    static final String TOPIC_EXCHANGE = "topic_exchange";
    static final String DIRECT_QUEUE_1 = "direct_queue_1";
    static final String DIRECT_QUEUE_2 = "direct_queue_2";


    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 创建连接工厂（设置RabbitMQ的连接参数）
        Connection connection = ConnectionUtil.getConnection();
        // 3. 创建频道
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare(TOPIC_EXCHANGE, BuiltinExchangeType.TOPIC);

        // 5. 发送消息
        String insert ="这是一个商品 insert";
        channel.basicPublish(TOPIC_EXCHANGE, "jaziel.insert", null, insert.getBytes());

        insert ="这是一个商品 update";
        channel.basicPublish(TOPIC_EXCHANGE, "jaziel.update", null, insert.getBytes());

        insert ="这是一个商品 delete";
        channel.basicPublish(TOPIC_EXCHANGE, "jaziel.delete", null, insert.getBytes());
        // 6. 关闭资源
        channel.close();
        connection.close();
    }
}
