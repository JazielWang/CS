package com.Jaziel.sample;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 王杰
 * @date 2021/5/5 10:30
 */
public class Producer {
    public static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 创建连接工厂（设置RabbitMQ的连接参数）
        ConnectionFactory connectionFactory = new ConnectionFactory();
        /*1.1 主机：默认localhost
        * 1.2 连接端口：默认5672
        * 1.3 虚拟主机：默认/
        * 1.4 用户名密码：guest/guest
        */
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/Jaziel");
        connectionFactory.setUsername("Jaziel");
        connectionFactory.setPassword("wedzbze74");
        // 2. 创建连接
        Connection connection = connectionFactory.newConnection();
        // 3. 创建频道
        Channel channel = connection.createChannel();
        /**
         * 4. 声明队列
         * 参数1：队列名称
         * 参数2：是否定义持久化队列（消息会持久化保存在服务器上）
         * 参数3：是否独占本连接
         * 参数4：是否在不使用的时候队列自动删除
         * 参数5：其它参数
         */
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        // 5. 发送消息
        String message = "hello, rabbit";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("消息已经发送" + message);
        // 6. 关闭资源
        channel.close();
        connection.close();
    }
}
