package com.Jaziel.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 王杰
 * @date 2021/5/5 11:27
 */
public class ConnectionUtil {
    public static Connection getConnection() throws IOException, TimeoutException {
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
        return connectionFactory.newConnection();
    }
}
