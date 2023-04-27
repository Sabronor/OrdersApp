package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public String name;
    public String lastName;
    public String city;
    public String phone;
}
