package com.Jaziel.routing;

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
    static final String DIRECT_EXCHANGE = "direct_exchange";
    static final String DIRECT_QUEUE_INSERT = "direct_queue_insert";
    static final String DIRECT_QUEUE_UPDATE = "direct_queue_update";


    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 创建连接工厂（设置RabbitMQ的连接参数）
        Connection connection = ConnectionUtil.getConnection();
        // 3. 创建频道
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare(DIRECT_EXCHANGE, BuiltinExchangeType.DIRECT);

        // 5. 发送消息
        String insert ="这是一个商品 insert";
        channel.basicPublish(DIRECT_EXCHANGE, "insert", null, insert.getBytes());

        insert ="这是一个商品 update";
        channel.basicPublish(DIRECT_EXCHANGE, "update", null, insert.getBytes());
        // 6. 关闭资源
        channel.close();
        connection.close();
    }
}
