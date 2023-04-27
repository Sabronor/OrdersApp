package com.example.model;

import com.example.converter.JsonExecutorDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = JsonExecutorDeserializer.class)
public class Executor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public String name;
    public String lastName;

    @ManyToOne(targetEntity = WorkType.class, cascade = CascadeType.REMOVE)
    public WorkType type;

}
