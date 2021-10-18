package com.example.trigger.model.mapper;

import com.example.trigger.controller.dto.TriggerDto;
import com.example.trigger.model.Trigger;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper
public interface TriggerMapper {
    Trigger trigger(TriggerDto triggerDto);

    TriggerDto triggerDto(Trigger trigger);

    List<TriggerDto> triggerDtos(List<Trigger> triggers);

    @AfterMapping
    default void afterMapping(@MappingTarget Trigger trigger, TriggerDto triggerDto) {
        try {
            trigger.setTime(LocalDateTime.parse(triggerDto.getTriggerTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "triggerTime does not have a suitable format");
        }
    }

    @AfterMapping
    default void afterMapping(@MappingTarget TriggerDto triggerDto, Trigger trigger) {
        triggerDto.setTriggerTime(trigger.getTime().toString());
    }
}
