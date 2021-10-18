package com.example.trigger.service.impl;

import com.example.trigger.model.Trigger;
import com.example.trigger.repository.TriggerRepository;
import com.example.trigger.service.TriggerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TriggerServiceImpl implements TriggerService {
    private final TriggerRepository triggerRepository;

    @Override
    public Trigger save(Trigger trigger) {
        return triggerRepository.save(trigger);
    }

    @Override
    public List<Trigger> getAll() {
        return triggerRepository.findAll();
    }

    @Override
    public void operateTriggers() {
        List<Trigger> triggers = triggerRepository.findTriggersByActivatedAndTimeIsLessThanEqual(Boolean.FALSE, LocalDateTime.now());
        if (triggers.size() > 0) {
            triggers.forEach(trigger -> {
                trigger.setActivated(Boolean.TRUE);
                log.info("trigger activated: " + trigger);
            });
            triggerRepository.saveAll(triggers);
        }
    }
}
