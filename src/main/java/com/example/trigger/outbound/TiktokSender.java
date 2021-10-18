package com.example.trigger.outbound;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@Component
public class TiktokSender {
    @Value("${trigger.exchange}")
    String txTrigger;
    @Value("${trigger.routingKey}")
    String rkTrigger;
    private final RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate = 1000)
    public void send() {
        String message = LocalDateTime.now().toString();
        log.debug(message+ " sent");
        rabbitTemplate.convertAndSend(txTrigger, rkTrigger, message);
    }
}
