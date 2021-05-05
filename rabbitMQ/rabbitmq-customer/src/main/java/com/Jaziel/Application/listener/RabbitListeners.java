package com.Jaziel.Application.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 王杰
 * @date 2021/5/5 17:14
 */
@Component
public class RabbitListeners {

    @RabbitListener(queues = "jaziel_queue")
    public void myListener(String message){
        System.out.println("接收到的消息是：" + message);
    }
}
