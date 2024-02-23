package com.example.s18g2.repository;

import com.example.s18g2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM fsweb.vegetable AS v ORDER BY v.price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM fsweb.vegetable AS v ORDER BY v.price ASC", nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);

}
