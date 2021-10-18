package com.example.trigger.controller.dto;

import lombok.Data;

@Data
public class TriggerDto {
    private String triggerTime;
    private String description;
    private boolean activated;
}
