package com.example.s18g2.controller;

import com.example.s18g2.dto.VegetableResponse;
import com.example.s18g2.entity.Vegetable;
import com.example.s18g2.service.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private final VegetableService vegetableService;

    @GetMapping
    public List<Vegetable> findAll(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public VegetableResponse get(@Positive @PathVariable long id){
        return new VegetableResponse("find by id succeed!", vegetableService.getById(id));
    }

    @GetMapping("/desc")
    public List<Vegetable> findAllDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping("/search/{name}")
    public List<Vegetable> searchByName(@Size(min = 2, max = 45, message = "name is not valid 2-45") @PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@Positive @PathVariable long id){
        return vegetableService.delete(id);
    }
}
