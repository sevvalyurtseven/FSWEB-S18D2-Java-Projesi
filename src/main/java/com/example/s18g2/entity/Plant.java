package com.example.s18g2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    @NotNull
    @Size(min=2, max=45, message = "name size must be between 2 to 45")
    private String name;

    @Column(name = "price")
    @DecimalMin("10")
    private double price;
}
