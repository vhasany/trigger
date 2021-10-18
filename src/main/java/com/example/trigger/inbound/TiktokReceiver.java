package com.example.trigger.inbound;

import com.example.trigger.service.TriggerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TiktokReceiver {
    private final TriggerService triggerService;

    @RabbitListener(queues = "${trigger.queue}")
    public void listener(String message) {
        log.debug(message + " received");
        try {
            triggerService.operateTriggers();
        } catch (Exception exception) {
            log.warn("operateTriggers exception");
            throw new AmqpRejectAndDontRequeueException("operateTriggers exception",exception);
        }
    }
}
