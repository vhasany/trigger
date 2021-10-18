package com.example.trigger.controller;

import com.example.trigger.controller.dto.TriggerDto;
import com.example.trigger.model.mapper.TriggerMapper;
import com.example.trigger.service.TriggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("triggers")
@RequiredArgsConstructor
public class TriggerController {
    private final TriggerService triggerService;
    private final TriggerMapper triggerMapper;

    @PostMapping
    public ResponseEntity createTrigger(@RequestBody final TriggerDto triggerDto) {
        return ResponseEntity
                .ok(triggerMapper.triggerDto(triggerService.save(triggerMapper.trigger(triggerDto))));
    }

    @GetMapping
    public ResponseEntity getTriggers() {
        return ResponseEntity.ok(triggerMapper.triggerDtos(triggerService.getAll()));
    }
}
