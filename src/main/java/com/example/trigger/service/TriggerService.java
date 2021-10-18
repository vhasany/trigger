package com.example.trigger.service;

import com.example.trigger.model.Trigger;

import java.util.List;

public interface TriggerService {
    Trigger save(Trigger trigger);

    List<Trigger> getAll();

    void operateTriggers();

}
