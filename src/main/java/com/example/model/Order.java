package com.example.model;

import com.example.converter.JsonOrderDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = JsonOrderDeserializer.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(targetEntity = Customer.class)
    public Customer customer;

    @OneToOne(targetEntity = Executor.class)
    public Executor executor;

    @OneToOne(targetEntity = WorkType.class)
    public WorkType workType;
}
