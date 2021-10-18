package com.example.trigger.repository;

import com.example.trigger.model.Trigger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TriggerRepository extends JpaRepository<Trigger, Long> {
    List<Trigger> findTriggersByActivatedAndTimeIsLessThanEqual(Boolean activated, LocalDateTime timeEvent);
}
