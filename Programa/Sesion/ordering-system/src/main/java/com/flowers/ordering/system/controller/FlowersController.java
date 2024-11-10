package com.flowers.ordering.system.controller;

import com.flowers.ordering.system.model.Flower;
import com.flowers.ordering.system.services.FlowerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/flowers")
public class FlowersController {

    private final FlowerService flowerService;

    public FlowersController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> findAll() {
        return this.flowerService.findAll();
    }

    @GetMapping("{flowerId}")
    public Optional<Flower> findById(@PathVariable Integer flowerId) {
        return this.flowerService.findById(flowerId);
    }

    @PostMapping
    public Flower create(@RequestBody Flower flower) {
        return this.flowerService.save(flower);
    }

    @PutMapping("{flowerId}")
    public Flower update(@PathVariable Integer flowerId, @RequestBody Flower flower) {
        flower.setId(flowerId);
        return this.flowerService.save(flower);
    }

    @DeleteMapping("{flowerId}")
    public Flower delete(@PathVariable Integer flowerId) {
        return this.flowerService.deleteById(flowerId);
    }
}