package com.Jaziel.Application;


import com.Jaziel.Application.config.RabbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 王杰
 * @date 2021/5/5 17:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        rabbitTemplate.convertAndSend(RabbitConfig.JAZIEL_TOPIC_EXCHANGE, "jaziel.insert", "这是一个商品 insert");
        rabbitTemplate.convertAndSend(RabbitConfig.JAZIEL_TOPIC_EXCHANGE, "jaziel.update", "这是一个商品 update");
        rabbitTemplate.convertAndSend(RabbitConfig.JAZIEL_TOPIC_EXCHANGE, "s.jaziel.insert", "这是一个商品 s.insert");
    }
}
