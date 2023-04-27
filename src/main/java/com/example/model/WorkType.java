package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class WorkType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public String type;

}
