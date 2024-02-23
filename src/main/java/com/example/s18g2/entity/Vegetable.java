package com.example.s18g2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vegetable", schema = "fsweb")
public class Vegetable extends Plant{
    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;
}
