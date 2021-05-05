package com.Jaziel.work;

import com.Jaziel.utils.ConnectionUtil;
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
        Connection connection = ConnectionUtil.getConnection();
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
        for (int i =1; i<=10; i++) {
            String message = "hello, rabbit" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }
        System.out.println("消息已经发送");
        // 6. 关闭资源
        channel.close();
        connection.close();
    }
}
