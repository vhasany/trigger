package com.example.trigger.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbltrigger")
@Data
@NoArgsConstructor
public class Trigger {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean activated;
    private LocalDateTime time;
    private String description;

}
