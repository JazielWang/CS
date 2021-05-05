package com.Jaziel.pubandsub;

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
    //交换机名称
    static final String FANOUT_EXCHANGE = "fanout_exchange";
    //队列名称
    static final String FANOUT_QUEUE_1 = "fanout_queue_1";
    //队列名称
    static final String FANOUT_QUEUE_2 = "fanout_queue_2";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 创建连接工厂（设置RabbitMQ的连接参数）
        Connection connection = ConnectionUtil.getConnection();
        // 2. 创建频道
        Channel channel = connection.createChannel();
        /**
         * 3. 声明交换机
         * 参数1：交换机名称
         * 参数2：交换机类型，fanout、topic、direct、headers
         */
        channel.exchangeDeclare(FANOUT_EXCHANGE, BuiltinExchangeType.FANOUT);
        /**
         * 4. 声明队列
         * 参数1：队列名称
         * 参数2：是否定义持久化队列（消息会持久化保存在服务器上）
         * 参数3：是否独占本连接
         * 参数4：是否在不使用的时候队列自动删除
         * 参数5：其它参数
         */
        channel.queueDeclare(FANOUT_QUEUE_1, true, false, false, null);
        channel.queueDeclare(FANOUT_QUEUE_2, true, false, false, null);

        // 队列绑定到交换机；参数1：队列名称，参数2：交换机名称，参数3：路由key
        channel.queueBind(FANOUT_QUEUE_1, FANOUT_EXCHANGE, "");
        channel.queueBind(FANOUT_QUEUE_2, FANOUT_EXCHANGE, "");
        // 5. 发送消息
        for (int i =1; i<=10; i++) {
            String message = "hello, rabbit" + i;
            channel.basicPublish(FANOUT_EXCHANGE, "", null, message.getBytes());
        }
        System.out.println("消息已经发送");
        // 6. 关闭资源
        channel.close();
        connection.close();
    }
}
