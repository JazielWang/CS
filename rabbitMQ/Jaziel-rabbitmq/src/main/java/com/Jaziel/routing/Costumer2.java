package com.Jaziel.routing;



import com.Jaziel.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 王杰
 * @date 2021/5/5 11:25
 */
public class Costumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1. 创建连接工厂；
        //2. 创建连接；（抽取一个获取连接的工具类）
        Connection connection = ConnectionUtil.getConnection();
        //3. 创建频道；
        final Channel channel = connection.createChannel();
        // 4. 声明交换机
        channel.exchangeDeclare(Producer.DIRECT_EXCHANGE, BuiltinExchangeType.DIRECT);
        //4. 声明队列；
        /**
         * 参数1：队列名称
         * 参数2：是否定义持久化队列（消息会持久化保存在服务器上）
         * 参数3：是否独占本连接
         * 参数4：是否在不使用的时候队列自动删除
         * 参数5：其它参数
         */
        channel.queueDeclare(Producer.DIRECT_QUEUE_UPDATE, true, false, false, null);
        // 5. 将队列绑定到交换机
        channel.queueBind(Producer.DIRECT_QUEUE_UPDATE, Producer.DIRECT_EXCHANGE, "update");
        //5. 创建消费者（接收消息并处理消息）；
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //接收到的消息
                System.out.println("接收到的消息为：" + new String(body, "utf-8"));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //确认消息
                /**
                 * 参数1：消息id
                 * 参数2：false表示只有当前这条被处理
                 */
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 6. 监听队列
        /**
         * 参数1：队列名
         * 参数2：是否要自动确认；设置为true表示消息接收到自动向MQ回复接收到了，MQ则会将消息从队列中删除；
         * 如果设置为false则需要手动确认
         * 参数3：消费者
         */
        channel.basicConsume(Producer.DIRECT_QUEUE_UPDATE, true, defaultConsumer);
    }
}
