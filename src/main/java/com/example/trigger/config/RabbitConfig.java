package com.example.trigger.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    @Value("${trigger.exchange}")
    String dxTrigger;
    @Value("${trigger.queue}")
    String qTrigger;
    @Value("${trigger.routingKey}")
    String rkTrigger;

    @Bean
    Queue queue() {
        return new Queue(qTrigger, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(dxTrigger);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rkTrigger);
    }

}
