package com.Jaziel.Application.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王杰
 * @date 2021/5/5 18:20
 */
@Configuration
public class RabbitConfig {
    // 交换机名称
    public static final String JAZIEL_TOPIC_EXCHANGE = "jaziel_topic_exchange";
    // 队列名称
    public static final String JAZIEL_QUEUE = "jaziel_queue";

    @Bean("jazielTopicExchange")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(JAZIEL_TOPIC_EXCHANGE).durable(true).build();
    }

    @Bean("jazielQueue")
    public Queue topicQueue(){
        return QueueBuilder.durable(JAZIEL_QUEUE).build();
    }

    @Bean
    public Binding topicBinding(@Qualifier("jazielQueue") Queue queue, @Qualifier("jazielTopicExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("jaziel.#").noargs();
    }
}

